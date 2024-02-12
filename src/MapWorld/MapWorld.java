package MapWorld;

import entity.*;

import java.util.Arrays;

/**
 * Карта, содержит в себе коллекцию для хранения существ и их расположения.
 */

public class MapWorld {

    private static final int LENGTH = 10;   //- максимальная длина
    private static final int HEIGHT = 8;    //- максимальная высота
    private Entity[][] matrixMap;           //- двумерный массив из объектов (сущностей)

    public MapWorld() {
        this.matrixMap = new Entity[HEIGHT][LENGTH];
    }

    public Entity getEntity(int y, int x) {
        return this.matrixMap[y][x];
    }

    public void setEntity(int y, int x, Entity entity) {
        if (entity == null)
            this.matrixMap[y][x] = null;
        else {
            this.matrixMap[y][x] = entity;
            this.matrixMap[entity.getY()][entity.getX()] = null;
            entity.setYX(y, x);
            System.out.println(entity.getImage() + " -> [" + y + ";" + x + "]");
        }
    }

    public void setEntity(Cell cell, Entity entity) {
        setEntity(cell.getY(),cell.getX(), entity);
    }

    boolean cellIsEmpty(int y, int x) {
        return this.getEntity(y, x) == null ? true : false;
    }

    public int countOfEntityOnTheMap(Class<? extends Entity> classEntity) {
        return (int) Arrays.stream(this.getMatrixMap()).flatMap(Arrays::stream)
                .filter(classEntity::isInstance).count();
    }

    public String prepareMapDisplay() {         //подготовить отображение карты
        String displayMap = "";
        for (int i = 0; i<this.HEIGHT; i++) {
            for (int j = 0; j<this.LENGTH; j++) {
                if (this.matrixMap[i][j] != null)
                    displayMap += this.matrixMap[i][j].getImage();
                else
                    displayMap += "⬜";
            }
            if (i<this.HEIGHT-1)
                displayMap += "\n";
        }
        return displayMap;
    }
    public Entity[][] getMatrixMap() {
        return this.matrixMap;
    }

    public int getLength() {
        return LENGTH;
    }

    public int getHeight() {
        return HEIGHT;
    }




}






