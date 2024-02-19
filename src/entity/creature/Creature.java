package entity.creature;

import MapWorld.MapWorld;
import entity.Entity;

public abstract class Creature extends Entity {
    private int healthPoints;
    private int speed;
    private int hunger;
    private int attackRange;

    Creature(MapWorld mapWorld, String image, int healthPoints, int speed, int hunger, int attackRange) {
        super(mapWorld, image);
        this.healthPoints = healthPoints;
        this.speed = speed;
        this.hunger = hunger;
        this.attackRange = attackRange;
    }

    public abstract void makeMove();

    public void increaseHealth(int increaseHealth) {
        int oldHP = this.getHealthPoints();
        int newHP = oldHP + increaseHealth;
        if (newHP > 100)
            newHP = 100;
        this.healthPoints = newHP;
        System.out.println(this.getImage() +"->" +oldHP +" + " +(newHP - oldHP) +" = [" +this.getHealthPoints() +"] HP");
    }

    public int getAttackRange() {
        return attackRange;
    }

    public int getHealthPoints() {
        return healthPoints;
    }
}