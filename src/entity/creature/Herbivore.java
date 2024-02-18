package entity.creature;

import MapWorld.MapWorld;
import entity.motionoless.Grass;

/**
 * Класс "Травоядное", наследуется от Существа. Стремятся найти ресурс (траву),
 * может потратить свой ход на движение в сторону травы, либо на её поглощение.
 */


public class Herbivore extends Creature {

    private static final String IMAGE = "\uD83D\uDC2E";
    private static final int INITIAL_HEALTH_POINT = 100;
    private static final int INITIAL_SPEED = 1;
    private static final int INITIAL_HUNGER = 3;
    private static final int INITIAL_RANGE = 1;
    private static final int RESTORE_HEALTH = 30;

    private Grass target;

    public Herbivore(MapWorld mapWorld) {
        super(mapWorld, IMAGE, INITIAL_HEALTH_POINT, INITIAL_SPEED, INITIAL_HUNGER, INITIAL_RANGE);
    }

    public static Herbivore createHerbivore(MapWorld mapWorld) {
        return new Herbivore(mapWorld);
    }

    void makeMove() {

            //найти обновить таргет и сохранить путь до него
            //если есть таргет
                //попробовать сьесть
                //иначе двигаться

            //испытать голод

    }

}