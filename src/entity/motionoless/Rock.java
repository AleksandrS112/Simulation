package entity.motionoless;

import MapWorld.MapWorld;

public class Rock extends Motionless {

    private static final String INITIAL_IMAGE = "\uD83E\uDDF1";

    public Rock(MapWorld mapWorld) {
        super(mapWorld, INITIAL_IMAGE);
    }

}
