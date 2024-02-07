import entity.*;

/**
 * Карта, содержит в себе коллекцию для хранения существ и их расположения.
 */

public class Mapa {

    private static final int LENGTH = 10;   //- максимальная длина
    private static final int HEIGHT = 5;    //- максимальная высота
    private Entity[][] matrixMap;           //- двумерный массив из объектов (сущностей)

    public Mapa() {
        this.matrixMap = new Entity[HEIGHT][LENGTH];
    }

    public Entity getEntity(int x, int y) {
        return this.matrixMap[y][x];
    }

    public void setEntity(int x, int y, Entity entity) {
        this.matrixMap[y][x] = entity;
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
    Entity[][] getMatrixMap() {
        return this.matrixMap;
    }

    int getLength() {
        return LENGTH;
    }

    int getHeight() {
        return HEIGHT;
    }




}






