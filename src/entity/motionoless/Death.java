package entity.motionoless;

import mapWorld.MapWorld;

public class Death extends Motionless {


    private static final String INITIAL_IMAGE = "☠\uFE0F";

    public Death(MapWorld mapWorld) {
        super(mapWorld, INITIAL_IMAGE);
    }

}
