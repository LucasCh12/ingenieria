package ar.edu.unrc.dc.model;

import java.util.ArrayList;
import java.util.List;

/**
 * The core engine for the Starfighter turn-based terminal game.
 * Manages the game state, including the grid, entities, and turn execution.
 */
public class StarfighterGameEngine implements Subject {
    private boolean isActive = false; 
    private List<Observer> observers = new ArrayList<>();
    private Board board;
    private StarFighter starFighter;
    private Rules rules;

    public StarfighterGameEngine(){ observers = new ArrayList<Observer>(); }
    
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

    public StarFighter getStarFighter(){ return this.starFighter;}

    private void advancePositionProjectile () {

        List<BoardObject> removeProjectileOfList = new ArrayList<>();
        for(BoardObject object:board.getObjects()){
            if(!(object instanceof Projectile)) continue;
            Position oldPosition = ((Projectile)object).position;
            Position newPosition= new Position(oldPosition.getRow(), oldPosition.getColumn()+((Projectile)object).moveSpeed);
            if(!board.isValidPosition(newPosition)){
                removeProjectileOfList.add(object);
            }
            ((Projectile)object).setPosition(newPosition);
            
        }
        for(BoardObject object: removeProjectileOfList){
            board.getObjects().remove(object);
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

        this.board = new Board(r, c);
        Position startfighterPosition = new Position(r / 2, 0);
        this.starFighter = new StarFighter(startfighterPosition, m1, m2);
        board.addObjectToBoard(starFighter);
        this.rules = new RulesImplements();
        this.isActive = true;
        board.addObjectToBoard(starFighter);

        notifyObservers();

    }

    /**
     * Command to move the Starfighter. Moves vertically first, then horizontally.
     * Checks for collisions along the entire path.
     *
     * @param verticalMove   Number of spaces to move vertically (negative is up, positive is down)
     * @param horizontalMove Number of spaces to move horizontally (negative is left, positive is right)
     */
    public void move(int verticalMove, int horizontalMove) {

        if(!isGameActive()) throw new IllegalArgumentException("Inactive game");
        advancePositionProjectile();
        Turn t = new Move(verticalMove,horizontalMove);
        if(rules.gameOver(this, t)){
            isActive=false;
            Position explosionPosition = rules.getExplosionPosition();
            starFighter.setAlive(false);
            starFighter.setPosition(explosionPosition);
            notifyObservers();
            return;
        }
        int moveCost = verticalMove + horizontalMove;
        if(moveCost>starFighter.getmoveSpeed()){
            throw new IllegalArgumentException("Incorrect position for object in board");
        }

        Position actualStar = starFighter.getPosition();
        
        Position newPosStar = new Position(actualStar.getRow()+verticalMove,actualStar.getColumn()+horizontalMove);
        if(!board.isValidPosition(newPosStar)){
            throw new IllegalArgumentException("StarFighter out of limits");
        }
        starFighter.setPosition(newPosStar);
        notifyObservers();

    }

    /**
     * Command for the Starfighter to fire a new projectile.
     */
    public void fire() {
        if(!isGameActive()) throw new IllegalArgumentException("Inactive game");
        advancePositionProjectile();
        Turn t = new Fire();
        if(rules.gameOver(this,t)){
            isActive=false;
            starFighter.setAlive(false);
            notifyObservers();
            return;
        }
        Projectile nuevoProjectile = starFighter.createProjectile();
        board.addObjectToBoard(nuevoProjectile);
        notifyObservers();
        System.out.println(board.getObjectCount());
    }

    /**
     * Command for the Starfighter to do nothing for this turn.
     */
    public void pass() {
        if(!isGameActive()) throw new IllegalArgumentException("Inactive game");
        advancePositionProjectile();
        Turn t = new Pass();
        if(rules.gameOver(this,t)){
            isActive=false;
            starFighter.setAlive(false);
            notifyObservers();
            return;
        }
        notifyObservers();
    }

    /**
     * Aborts the current game. Can only be used when a game is active.
     */
    public void abort() {
        if(!isGameActive()) throw new IllegalArgumentException("Inactive game");
        isActive = false;
        notifyObservers();
    }

    public boolean isGameActive() { return isActive; }
}