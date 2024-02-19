package entity.creature;

import MapWorld.MapWorld;
import entity.creature.BFS.BFS;
import entity.motionoless.Grass;
import MapWorld.Cell;

/**
 * Класс "Травоядное", наследуется от Существа. Стремятся найти ресурс (траву),
 * может потратить свой ход на движение в сторону травы, либо на её поглощение.
 */


public class Herbivore extends Creature {

    private static final String IMAGE = "\uD83D\uDC2E";
    private static final int INITIAL_HEALTH_POINT = 100;
    private static final int INITIAL_SPEED = 1;
    private static final int INITIAL_HUNGER = 3;
    private static final int INITIAL_RANGE = 1;
    private static final int RESTORE_HEALTH = 30;
    private Cell target;

    public Herbivore(MapWorld mapWorld) {
        super(mapWorld, IMAGE, INITIAL_HEALTH_POINT, INITIAL_SPEED, INITIAL_HUNGER, INITIAL_RANGE);
    }

    public Cell getTarget() {
        return target;
    }

    public void makeMove() {
            this.target = BFS.bfsDiagonalWithPath(mapWorld, this, Grass.class);
            if (target != null) {
                if ((Math.abs(target.getY()-this.getY()) <= this.getAttackRange()) && (Math.abs(target.getX()-this.getX()) <= this.getAttackRange())) {
                    mapWorld.moveEntity(target, this);
                    this.target = BFS.bfsDiagonalWithPath(mapWorld, this, Grass.class);
                    this.increaseHealth(RESTORE_HEALTH);
                } else {
                    target.getPath().removeFirst();
                    mapWorld.moveEntity(target.getPath().getFirst(), this);
                }
            }
            //если есть таргет
                //попробовать сьесть
                //иначе двигаться

            //испытать голод

    }

}