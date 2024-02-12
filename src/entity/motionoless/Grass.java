package entity.motionoless;

import MapWorld.MapWorld;

public class Grass extends Motionless {

    private static final String INITIAL_IMAGE = "\uD83E\uDD6C";
    private static final int QUANTITY = 3;

    public Grass(MapWorld mapWorld) {
        super(mapWorld, INITIAL_IMAGE);
    }

    public static int getQuantity() {
        return QUANTITY;
    }
}
