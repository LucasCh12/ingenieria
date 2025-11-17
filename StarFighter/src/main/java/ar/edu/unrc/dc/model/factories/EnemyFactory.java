package ar.edu.unrc.dc.model.factories;

import java.util.List;
import java.util.Random;

import ar.edu.unrc.dc.model.board.Board;
import ar.edu.unrc.dc.model.board.Position;
import ar.edu.unrc.dc.model.board.objects.entities.StatsEntities;
import ar.edu.unrc.dc.model.board.objects.entities.enemies.Carrier;
import ar.edu.unrc.dc.model.board.objects.entities.enemies.Enemy;
import ar.edu.unrc.dc.model.board.objects.entities.enemies.Fighter;
import ar.edu.unrc.dc.model.board.objects.entities.enemies.Grunt;
import ar.edu.unrc.dc.model.board.objects.entities.enemies.Interceptor;
import ar.edu.unrc.dc.model.board.objects.entities.enemies.Pylon;
import ar.edu.unrc.dc.model.equipment.gear.weapons.WeaponAbstract;

public class EnemyFactory {

    private Random random = new Random();
    private WeaponFactory weaponFactory = new WeaponFactory();
    private Board board;

    private List<String> tipos = List.of(
        "Grunt", "Fighter", "Carrier", "Interceptor", "Pylon"
    );

    public EnemyFactory (Board board) {this.board = board;}

    private Enemy createRandomEnemy(Position pos) {
        String type = tipos.get(random.nextInt(tipos.size()));
        WeaponAbstract weapon = weaponFactory.createRandomWeapon();
        return createEnemy(type, pos, weapon);
    }

    public Enemy createEnemy(){
        int minimo = board.getColumn()/2;
        int column = random.nextInt((board.getColumn()-1)- minimo + 1) + minimo; // Genere solo en la mitad derecha
        int row = random.nextInt(board.getRow()-1); // Cualquier fila
        Position position = new Position(row, column);
        return createRandomEnemy(position);
    }

    private Enemy createEnemy(String type, Position pos, WeaponAbstract weapon) {
        Enemy enemy; 
        if (type.equals("Grunt")) {
            enemy = new Grunt(weapon,null, null, pos, new StatsEntities(100, 1, 1, 5, "Grunt",3));
        } else if (type.equals("Fighter")) {
            enemy = new Fighter(weapon,null, null, pos, new StatsEntities(150, 5, 10, 10, "Fighter",4));
        } else if (type.equals("Carrier")) {
            enemy = new Carrier(weapon,null, null, pos, new StatsEntities(200, 10, 15, 15, "Carrier",1));
        } else if (type.equals("Interceptor")) {
            enemy = new Interceptor(weapon,null, null, pos, new StatsEntities(50, 0, 0, 5, "Interceptor",5));
        } else {
            enemy = new Pylon(weapon,null, null, pos,new StatsEntities(300, 0, 0, 5, "Pylon",1));
        }

        return enemy;
    }
}
