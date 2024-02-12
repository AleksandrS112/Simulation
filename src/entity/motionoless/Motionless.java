package entity.motionoless;

import MapWorld.MapWorld;
import entity.Entity;

/**
 * Класс "НеподвижныйОбъект" наследуется от корневого абстрактного класа
 */

public abstract class Motionless extends Entity {

    Motionless (MapWorld mapWorld, String image) {
        super(mapWorld, image);
    }

}
