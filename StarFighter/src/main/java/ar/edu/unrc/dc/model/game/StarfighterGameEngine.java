package ar.edu.unrc.dc.model.game;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unrc.dc.model.actions.AbortCommand;
import ar.edu.unrc.dc.model.actions.FireCommand;
import ar.edu.unrc.dc.model.actions.GameCommand;
import ar.edu.unrc.dc.model.actions.MoveCommand;
import ar.edu.unrc.dc.model.actions.PassCommand;
import ar.edu.unrc.dc.model.actions.PlayCommand;
import ar.edu.unrc.dc.model.actions.SetLoadOutCommand;
import ar.edu.unrc.dc.model.board.Board;
import ar.edu.unrc.dc.model.board.Position;
import ar.edu.unrc.dc.model.board.objects.entities.Entity;
import ar.edu.unrc.dc.model.board.objects.entities.StatsEntities;
import ar.edu.unrc.dc.model.board.objects.entities.enemies.Enemy;
import ar.edu.unrc.dc.model.board.objects.entities.fighters.StarFighter;
import ar.edu.unrc.dc.model.board.objects.projectiles.Projectile;
import ar.edu.unrc.dc.model.equipment.gear.weapons.Standard;
import ar.edu.unrc.dc.model.factories.EnemyFactory;
import ar.edu.unrc.dc.model.game.state.GameState;
import ar.edu.unrc.dc.model.game.state.InGameState;
import ar.edu.unrc.dc.model.game.state.NotStartedState;
import ar.edu.unrc.dc.model.game.state.SetupState;
import ar.edu.unrc.dc.model.rules.Rules;
import ar.edu.unrc.dc.model.rules.RulesImplements;
import ar.edu.unrc.dc.utils.Observer;
import ar.edu.unrc.dc.utils.Subject;

/**
 * The core engine for the Starfighter turn-based terminal game.
 * Manages the game state, including the grid, entities, and turn execution.
 */
public class StarfighterGameEngine implements Subject {
    
    private boolean isActive = false; 
    private List<Observer> observers = new ArrayList<>();
    private Board board;
    private Entity starFighter;
    private List<Enemy> enemies;
    private Rules rules;
    private GameState currentState;
    private GameCommand currentCommand = null;
    private LoadOut loadOut=new LoadOut();
    private GameConfiguration config;

    public StarfighterGameEngine() { 
        observers = new ArrayList<Observer>();
        this.currentState = new NotStartedState();
        this.rules = new RulesImplements(); 
        this.currentState.enterState(this);
        this.enemies = new ArrayList<>();
    }
    
    @Override
    public void attach(Observer o) { observers.add(o); }

    @Override
    public void detach(Observer o) { observers.remove(o); }

    @Override
    public void notifyObservers() {
        for (Observer o : observers) {
            o.update(this);
        }
    }

    public Board getBoard() { return this.board; }

    public Entity getStarFighter(){ return this.starFighter;}

    public GameCommand getCurrentcCommand(){return this.currentCommand;}

    private void advancePositionProjectile() {
    List<Projectile> projectilesToRemove = new ArrayList<>();
    
    for(Projectile projectile : board.getProjectiles()) {
        // No necesitas verificar "if(!(object instanceof Projectile))" 
        // porque ya estás iterando sobre getProjectiles()
        
        Position oldPosition = projectile.getPosition();
        Position newPosition = new Position(
            oldPosition.getRow(), 
            oldPosition.getColumn() + projectile.getHorizontalSpeed()
        );
        
        if(!board.isValidPosition(newPosition)) {
            projectilesToRemove.add(projectile);
        } else {
            projectile.setPosition(newPosition);  // Solo mover si es válida
        }
    }
    
    // Remover proyectiles que salieron del tablero
    for(Projectile projectile : projectilesToRemove) {
        board.getObjects().remove(projectile);
    }
}
    
    /**
     * Initializes a new game with the given parameters. This is the crucial starting command.
     *
     * @param r  Total rows in the grid (3 <= r <= 10)
     * @param c  Total columns in the grid (5 <= c <= 30)
     * @param m1 Max sum of vertical/horizontal moves for the Starfighter (1 <= m1 <= 40)
     * @param m2 Number of horizontal moves for a projectile (1 <= m2 <= 5)
     */
    public void play(int r, int c, int m1, int m2) {
        if (currentState instanceof InGameState && board != null) {
            throw new IllegalStateException("Game already in progress");
        }
        this.config = new GameConfiguration(r, c, m1, m2);
        initializeGame();
        GameCommand command = new PlayCommand(this);
        setCommand(command);
        command.execute();
        notifyObservers();
    }

    /**
     * Command to move the Starfighter. Moves vertically first, then horizontally.
     * Checks for collisions along the entire path.
     *
     * @param verticalMove   Number of spaces to move vertically (negative is up, positive is down)
     * @param horizontalMove Number of spaces to move horizontally (negative is left, positive is right)
     */
    public void move(Position position) {
        if (!isGameActive()) throw new IllegalArgumentException("Inactive game");
        if (!(currentState instanceof InGameState)) {
            throw new IllegalStateException("Move allowed only during InGame state");
        }
        advancePositionProjectile();
        GameCommand command = new MoveCommand(position, this);
        
        if (rules.gameOver(this, command)) {
            handleGameOver(command);
            return;
        }

        command.execute();
        this.currentCommand = command;
        advancePositionProjectile();
        notifyObservers();;
    }

    /**
     * Command for the Starfighter to fire a new projectile.
     */
    public void fire() {
        if (!isGameActive()) throw new IllegalArgumentException("Inactive game");
        if (!(currentState instanceof InGameState)) {
            throw new IllegalStateException("Fire allowed only during InGame state");
        }
        advancePositionProjectile();
        GameCommand command = new FireCommand(this);
        if (rules.gameOver(this, command)) {
            handleGameOver(command);
            return;
        }
        command.execute();
        this.currentCommand = command;
        notifyObservers();
    }

    private void updateEnemyVision() {
        
    }

    public List<Enemy> getEnemies () {
        return enemies;
    }

    /**
     * Command for the Starfighter to do nothing for this turn.
     */
    public void pass() {
         if (!isGameActive()) throw new IllegalArgumentException("Inactive game");
        if (!(currentState instanceof InGameState)) {
            throw new IllegalStateException("Pass allowed only during InGame state");
        }
        
        advancePositionProjectile();  // ← Avanza proyectiles UNA vez
        
        GameCommand command = new PassCommand();
        if (rules.gameOver(this, command)) {
            handleGameOver(command);
            return;
        }
        
        command.execute();
        this.currentCommand = command;
        notifyObservers();           
    }

    /**
     * Aborts the current game. Can only be used when a game is active.
     */
    public void abort() {
       if (!isGameActive()) {
            throw new IllegalArgumentException("Inactive game");
        }
        GameCommand command = new AbortCommand();
        command.execute();
        setState(new NotStartedState());
        setActive(false);
        this.currentCommand = command;
        advancePositionProjectile();
        notifyObservers();
    }

    private void handleGameOver(GameCommand command) {
        currentState = new NotStartedState();
        Position explosionPosition = rules.getExplosionPosition();
        starFighter.setAlive(false);
        starFighter.setPosition(explosionPosition);
        this.currentCommand = command;  
        notifyObservers();
    }

    public boolean isGameActive() { return isActive; }

    public void setState(GameState setupState) {
        currentState = setupState;
        if(this.currentState!=null){
            this.currentState.enterState(this);
        }
    }

    public void setCommand(GameCommand cmd) {
        this.currentCommand = cmd;
        notifyObservers();
    }

    public GameState getState(){
        return this.currentState;
    }

    public LoadOut getLoadOut(){
        return this.loadOut;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public void setConfig(GameConfiguration configuration) { this.config = configuration; }

    public void setupNext(int n) {
        if (!(currentState instanceof SetupState state)){
            throw new IllegalStateException("Not in setup stage");
        }
        state.setupNext(this, n);
    }
    public void setupBack(int n) {
        if (!(currentState instanceof SetupState state)){
            throw new IllegalStateException("Not in setup stage");
        }
        state.setupBack(this, n);
    }
    public void setupSelect(int option) {
        if (!(currentState instanceof SetupState state)){
            throw new IllegalStateException("Not in setup stage");
        }    
        state.setupSelect(this, option);
    }

    public boolean isOutOfVision(Position pos) {
        StatsEntities stats = starFighter.getStatsEntities();
        return getManhathanDistance(pos) > stats.getVision();
    }

    public int getManhathanDistance(Position pos) {
        Position starFighterPosition = starFighter.getPosition();
        return Math.abs(pos.getRow() - starFighterPosition.getRow()) + Math.abs(pos.getColumn() - starFighterPosition.getColumn());
    }

    public void initializeGame() {
        Position startfighterPosition = new Position(config.getRows() / 2, 0); 
        StatsEntities statsStarFighter = new StatsEntities(100, 10, 20, 13, "star", config.getStarFighterSpeed());
        this.starFighter = new StarFighter(startfighterPosition, new Standard(config.getProjectileSpeed()), null, null, statsStarFighter, 15, config.getProjectileSpeed());
        System.out.println("weapon: " + ((StarFighter) starFighter).getWeapon());
        GameCommand command = new SetLoadOutCommand(loadOut, starFighter);
        System.out.println("Loadout applied:\n" + loadOut.getSummary());
        System.out.println("armor: " + statsStarFighter.getArmour());
        System.out.println("weapon: " + ((StarFighter) starFighter).getWeapon());
        this.board = new Board(config.getRows(), config.getColumns(), starFighter);
        this.rules = new RulesImplements();
        this.isActive = true;
        EnemyFactory factory = new EnemyFactory(board);
        Entity enemy = factory.createEnemy();
        board.addObjectToBoard(enemy);
        notifyObservers();
    }

    public void startSetup() {
        setState(new SetupState());
    }
}