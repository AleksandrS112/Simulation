package entity.motionoless;


/**
 * Класс "Трава" (ресурс для травоядных) наследуется от класса неподвижных объектов
 * Имеет количество HP
 */


public class Grass extends Motionless {

    private static final int INITIAL_AMOUNT = 10;
    private static final String INITIAL_IMAGE = "\uD83E\uDD6C";
    private static final int QUANTITY = 3;

    private int amount;

    public Grass() {
        super(INITIAL_IMAGE);
        this.amount = INITIAL_AMOUNT;
    }

    public static int getQuantity() {
        return QUANTITY;
    }

}
