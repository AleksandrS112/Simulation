package entity.creature;

import entity.Entity;

/**
 * Абстрактный класс "Существо" наследуется от корневого абстрактного класа, имеет:
 *  - количество HP; ☑
 *  - скорость (сколько клеток может пройти за 1 ход); ☑
 *  - способность к голоду (сколько HP отнимается за 1 ход); ☑
 *
 * Абстрактный метод makeMove() - сделать ход.
 */
public abstract class Creature extends Entity {
    private int healthPoints;
    private int speed;
    private int hunger;

    protected Creature(int healthPoints, int speed, int hunger, String image) {
        super(image);
        this.healthPoints = healthPoints;
        this.speed = speed;
        this.hunger = hunger;
    }

    void makeMove(Creature creature) {

    }

}
