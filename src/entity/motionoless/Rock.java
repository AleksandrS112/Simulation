package entity.motionoless;

import MapWorld.MapWorld;
import entity.motionoless.Motionless;

/**
 * Класс "Камень" наследуется от класса неподвижных объектов
 */

public class Rock extends Motionless {

    private static final String INITIAL_IMAGE = "\uD83E\uDDF1";
    private static final int QUANTITY = 3;

    public Rock(MapWorld mapWorld) {
        super(mapWorld, INITIAL_IMAGE);
    }

    public static int getQuantity() {
        return QUANTITY;
    }

}
