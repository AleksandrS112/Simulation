package entity.creature;

import mapWorld.MapWorld;
import entity.motionoless.Grass;
import mapWorld.Cell;

public class Herbivore extends Creature {

    private static final String IMAGE = "\uD83D\uDC2E";
    private static final int INITIAL_HEALTH_POINT = 100;
    private static final int INITIAL_SPEED = 1;
    private static final int INITIAL_HUNGER = 5;
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
            this.target = this.bfsDiagonalWithPath(mapWorld, Grass.class);
            if (target != null) {
                if ((Math.abs(target.getY()-this.getY()) <= this.getAttackRange()) && (Math.abs(target.getX()-this.getX()) <= this.getAttackRange())) {
                    mapWorld.moveEntity(target, this);
                    this.healthIncrease(RESTORE_HEALTH);
                    this.target = null;
                } else {  // !!!!!!!!!!!!!!!!!!!!перенести эту часть в общий класс
                    Cell moveCell = target.getPath().poll();
                    for(int motion = 0; motion < this.getSpeed() ; motion++) {
                        if (this.target.getPath().size() > 1)
                            moveCell = target.getPath().poll();
                    }
                    mapWorld.moveEntity(moveCell, this);
                }
            }
            this.healthDecrease(INITIAL_HUNGER);
    }

}
