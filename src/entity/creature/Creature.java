package entity.creature;

import entity.motionoless.Death;
import mapWorld.MapWorld;
import entity.Entity;
import mapWorld.Cell;
import java.util.LinkedList;
import java.util.Queue;

public abstract class Creature extends Entity {
    private int healthPoints;
    private int speed;
    private int hunger;
    private int attackRange;
    protected Cell target;

    Creature(MapWorld mapWorld, String image, int healthPoints, int speed, int hunger, int attackRange) {
        super(mapWorld, image);
        this.healthPoints = healthPoints;
        this.speed = speed;
        this.hunger = hunger;
        this.attackRange = attackRange;
    }

    public abstract void makeMove();

    public void motion() {
        Cell motionCell = target.getPath().poll();
        for(int motionCount = 0; motionCount < this.getSpeed() ; motionCount++) {
            if (this.target.getPath().size() > 1)
                motionCell = target.getPath().poll();
        }
        mapWorld.moveEntity(motionCell, this);
    }

    public int healthIncrease(int increaseHealth) {
        int oldHP = this.getHealthPoints();
        int newHP = oldHP + increaseHealth;
        if (newHP > 100)
            newHP = 100;
        int difHP = newHP - oldHP;
        this.healthPoints = newHP;
        System.out.println(this.getImage() +" " +oldHP +" + " +difHP + "(" +increaseHealth + ")" +" = [" +this.getHealthPoints() +"] HP");
        return difHP;
    }

    public int healthDecrease(int healthDecrease) {
        int oldHP = this.getHealthPoints();
        int newHP = oldHP - healthDecrease;
        int difHP = 0;
        if (newHP <= 0) {
            newHP = 0;
            this.healthPoints = 0;
            this.mapWorld.addEntity(mapWorld.getCellEntity(this), new Death(this.mapWorld));
        } else
            this.healthPoints = newHP;
        difHP = oldHP - newHP;
        System.out.print(this.getImage() + " " + oldHP + " - " + difHP + "(" +healthDecrease + ")" + " = [" + this.getHealthPoints() + "] HP");
        System.out.println(newHP == 0 ? " ☠\uFE0F" : "");
        return difHP;
    }

    public int getAttackRange() {
        return attackRange;
    }

    public Cell bfsDiagonalWithPath(MapWorld mapWorld, Class targetClass) {
        int maxY = mapWorld.getHeight();
        int maxX = mapWorld.getLength();
        boolean[][] visited = new boolean[maxY][maxX];
        Queue<Cell> queue = new LinkedList<>();
        Cell startCell = new Cell(this.getY(), this.getX());
        startCell.getPath().add(startCell);
        queue.add(startCell);
        visited[this.getY()][this.getX()] = true;

        int[] dx = {-1, 0, 1, 0, -1, -1, 1, 1};
        int[] dy = {0, 1, 0, -1, -1, 1, -1, 1};

        while (!queue.isEmpty()) {
            Cell currentCell = queue.poll();
            int y = currentCell.getY();
            int x = currentCell.getX();

            Cell nCell = new Cell(y, x);
            if (!mapWorld.cellIsEmpty(nCell)) {
                if (mapWorld.getEntity(nCell).getClass() == targetClass) {
                    return currentCell;
                }
            }

            for (int i = 0; i < 8; i++) {
                int newY = y + dy[i];
                int newX = x + dx[i];
                if (newX >= 0 && newX < maxX && newY >= 0 && newY < maxY && !visited[newY][newX]) {
                    visited[newY][newX] = true;
                    Cell newCell = new Cell(newY, newX);
                    newCell.getPath().addAll(currentCell.getPath());
                    newCell.getPath().add(newCell);
                    if (mapWorld.cellIsEmpty(newCell) || mapWorld.getEntity(newCell).getClass() == targetClass)
                        queue.add(newCell);
                }
            }
        }
        return null;
    }

    public Cell getTarget() {
        return target;
    }

    public int getHealthPoints() {
        return healthPoints;
    }

    public int getSpeed() {
        return this.speed;
    }

}