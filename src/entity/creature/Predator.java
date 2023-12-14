package entity.creature;

/**
 * Класс "Хищник", наследуется от "Существа".
 * В дополнение к полям класса "Существа", имеет силу атаки.
 * На что может потратить ход хищник:
 *  - Переместиться (чтобы приблизиться к жертве - травоядному)
 *  - Атаковать травоядное. При этом количество HP травоядного уменьшается на силу атаки хищника.
 *    Если значение HP жертвы опускается до 0, травоядное исчезает.
 */
public class Predator extends Creature {

    private static final int INITIAL_HEALTH_POINT = 20;
    private static final int INITIAL_SPEED = 2;
    private static final int INITIAL_HUNGER = 3;
    private static final String INITIAL_IMAGE = "\uD83D\uDC2F";
    private static final int INITIAL_ATTACK_POWER = 2;
    private static final int INITIAL_ATTACK_RANGE = 2;
    private static final int QUANTITY = 2;

    private static int аttackPower;
    private static int аttackRange;

    private Herbivore target;


    public Predator() {
        super(INITIAL_HEALTH_POINT, INITIAL_SPEED, INITIAL_HUNGER, INITIAL_IMAGE);
        this.аttackPower = INITIAL_ATTACK_POWER;
        this.аttackRange = INITIAL_ATTACK_RANGE;
    }

    public static int getQuantity() {
        return QUANTITY;
    }

}
