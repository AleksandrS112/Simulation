package entity.creature;

import MapWorld.MapWorld;

/*
 * Класс "Хищник", наследуется от "Существа".
 * В дополнение к полям класса "Существа", имеет силу атаки.
 * На что может потратить ход хищник:
 *  - Переместиться (чтобы приблизиться к жертве - травоядному)
 *  - Атаковать травоядное. При этом количество HP травоядного уменьшается на силу атаки хищника.
 *    Если значение HP жертвы опускается до 0, травоядное исчезает.
 */

public class Predator extends Creature {

    private static final String IMAGE = "\uD83D\uDC2F";
    private static final int INITIAL_HEALTH_POINT = 100;
    private static final int INITIAL_SPEED = 2;
    private static final int INITIAL_HUNGER = 3;
    private static final int INITIAL_ATTACK_POWER = 30;
    private static final int INITIAL_ATTACK_RANGE = 2;

    private int аttackPower;
    private Herbivore target;


    public Predator(MapWorld mapWorld) {
        super(mapWorld, IMAGE, INITIAL_HEALTH_POINT, INITIAL_SPEED, INITIAL_HUNGER, INITIAL_ATTACK_RANGE);
        this.аttackPower = INITIAL_ATTACK_POWER;
    }

    void makeMove(){
        //
    }

}
