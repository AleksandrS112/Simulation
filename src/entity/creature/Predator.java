package entity.creature;

import mapWorld.MapWorld;
import mapWorld.Cell;

public class Predator extends Creature {

    private static final String IMAGE = "\uD83D\uDC2F";
    private static final int INITIAL_HEALTH_POINT = 100;
    private static final int INITIAL_SPEED = 2;
    private static final int INITIAL_HUNGER = 10;
    private static final int INITIAL_ATTACK_POWER = 30;
    private static final int INITIAL_ATTACK_RANGE = 2;

    private int аttackPower;
    private Cell target;


    public Predator(MapWorld mapWorld) {
        super(mapWorld, IMAGE, INITIAL_HEALTH_POINT, INITIAL_SPEED, INITIAL_HUNGER, INITIAL_ATTACK_RANGE);
        this.аttackPower = INITIAL_ATTACK_POWER;
    }

    public void makeMove(){
        this.target = this.bfsDiagonalWithPath(mapWorld, Herbivore.class);
        if (target != null) {
                if ((Math.abs(target.getY()-this.getY()) <= this.getAttackRange()) && (Math.abs(target.getX()-this.getX()) <= this.getAttackRange())) {
                    this.healthIncrease(((Herbivore) mapWorld.getEntity(target)).healthDecrease(this.аttackPower));
                } else {
                    Cell moveCell = target.getPath().poll();
                    for(int motion = 0; motion < this.getSpeed() ; motion++) {
                        if (target.getPath().size() > 1)
                            moveCell = target.getPath().poll();
                    }
                    mapWorld.moveEntity(moveCell, this);
                }
            }
        this.healthDecrease(INITIAL_HUNGER);
        }

    public Cell getTarget() {
        return target;
    }
}
