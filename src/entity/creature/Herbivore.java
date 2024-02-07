package entity.creature;

/**
 * Класс "Травоядное", наследуется от Существа. Стремятся найти ресурс (траву),
 * может потратить свой ход на движение в сторону травы, либо на её поглощение.
 */


public class Herbivore extends Creature {

    private static final int INITIAL_HEALTH_POINT = 10;
    private static final int INITIAL_SPEED = 1;
    private static final int INITIAL_HUNGER = 1;
    private static final String IMAGE = "\uD83D\uDC2E";
    private static final int QUANTITY = 2;

    public Herbivore() {
        super(INITIAL_HEALTH_POINT, INITIAL_SPEED, INITIAL_HUNGER, IMAGE);
    }

    public static int getQuantity() {
        return QUANTITY;
    }

}
