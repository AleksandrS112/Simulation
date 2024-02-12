package entity.motionoless;

public class Grass extends Motionless {

    private static final String INITIAL_IMAGE = "\uD83E\uDD6C";
    private static final int QUANTITY = 3;

    public Grass() {
        super(INITIAL_IMAGE);
    }

    public static int getQuantity() {
        return QUANTITY;
    }
}
