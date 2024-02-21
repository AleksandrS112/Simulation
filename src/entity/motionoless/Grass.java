package entity.motionoless;

import mapWorld.MapWorld;

public class Grass extends Motionless {

    private static final String INITIAL_IMAGE = "\uD83E\uDD6C";

    public Grass(MapWorld mapWorld) {
        super(mapWorld, INITIAL_IMAGE);
    }

}
