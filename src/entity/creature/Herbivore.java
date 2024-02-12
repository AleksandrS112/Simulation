package entity.creature;

import MapWorld.MapWorld;
import entity.Entity;
import entity.motionoless.Grass;

import java.util.Optional;

/**
 * Класс "Травоядное", наследуется от Существа. Стремятся найти ресурс (траву),
 * может потратить свой ход на движение в сторону травы, либо на её поглощение.
 */


public class Herbivore extends Creature {

    private static final int INITIAL_HEALTH_POINT = 100;
    private static final int INITIAL_SPEED = 1;
    private static final int INITIAL_HUNGER = 3;
    private static final int INITIAL_RANGE = 1;
    private static final String IMAGE = "\uD83D\uDC2E";
    private static final int QUANTITY = 2;
    private static final int RESTORE_HEALTH = 30;

    private Grass target;

    public Herbivore(MapWorld mapWorld) {
        super(mapWorld, IMAGE, INITIAL_HEALTH_POINT, INITIAL_SPEED, INITIAL_HUNGER, INITIAL_RANGE);
    }

    public static int getQuantity() {
        return QUANTITY;
    }

    @Override
    public void makeMove(MapWorld map) {
        // если нет таргета то найти
        if (this.target == null) {
            Optional<? extends Entity> target = searchForGoal(map, Grass.class);
            if (target.isPresent())
                this.target = (Grass) target.get();
        }

        // если есть цель попробовать атаковать если не достает переместиться ближе
        if(this.target != null) {
            if ((Math.abs(this.getY() - this.target.getY()) <= this.getRange()) && (Math.abs(this.getX() - this.target.getX()) <= this.getRange())) {
                this.restoreHealth(RESTORE_HEALTH);
                map.setEntity(this.target.getY(), this.target.getX(), null);
                this.target = null;
                System.out.println("Травоядное сьело траву");
            }
            else {
                this.move(map, this, this.target);
            }
        }

        this.takeDamage(this.hunger, map);
    }
}
