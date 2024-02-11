package entity.creature;

import MapWorld.MapWorld;
import entity.Entity;

import java.util.Optional;

/**
 * Класс "Хищник", наследуется от "Существа".
 * В дополнение к полям класса "Существа", имеет силу атаки.
 * На что может потратить ход хищник:
 *  - Переместиться (чтобы приблизиться к жертве - травоядному)
 *  - Атаковать травоядное. При этом количество HP травоядного уменьшается на силу атаки хищника.
 *    Если значение HP жертвы опускается до 0, травоядное исчезает.
 */
public class Predator extends Creature {

    private static final int INITIAL_HEALTH_POINT = 100;
    private static final int INITIAL_SPEED = 2;
    private static final int INITIAL_HUNGER = 3;
    private static final String IMAGE = "\uD83D\uDC2F";
    private static final int INITIAL_ATTACK_POWER = 30;
    private static final int INITIAL_RANGE = 2;
    private static final int QUANTITY = 1;

    private int аttackPower;
    private Herbivore target;


    public Predator() {
        super(IMAGE, INITIAL_HEALTH_POINT, INITIAL_SPEED, INITIAL_HUNGER, INITIAL_RANGE);
        this.аttackPower = INITIAL_ATTACK_POWER;
    }

    public static int getQuantity() {
        return QUANTITY;
    }

    @Override
    public void makeMove(MapWorld map) {
        if (this.target != null && this.target.getHealthPoints() <= 0)
            this.target = null;
        if (this.target == null) {
            Optional<? extends Entity> target = searchForGoal(map, Herbivore.class);
            if (target.isPresent())
                this.target = (Herbivore) target.get();
        }

        // если есть цель попробовать атаковать если не достает переместиться ближе
        if(this.target != null) {
            if ((Math.abs(this.getY() - this.target.getY()) <= this.getRange()) && (Math.abs(this.getX() - this.target.getX()) <= this.getRange())) {
                target.takeDamage(this.аttackPower, map);
                this.restoreHealth(this.аttackPower);
                System.out.println("Хищник атаковал травоядного.");
            }
            else {
                this.move(map, this, this.target);
            }
        }

        this.takeDamage(this.hunger, map);
    }
}
