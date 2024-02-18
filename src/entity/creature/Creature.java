package entity.creature;

import MapWorld.MapWorld;
import entity.Entity;

public abstract class Creature extends Entity {
    private int healthPoints;
    private int speed;
    protected int hunger;
    private int attackRange;

    Creature(MapWorld mapWorld, String image, int healthPoints, int speed, int hunger, int attackRange) {
        super(mapWorld, image);
        this.healthPoints = healthPoints;
        this.speed = speed;
        this.hunger = hunger;
        this.attackRange = attackRange;
    }

    abstract void makeMove();

}