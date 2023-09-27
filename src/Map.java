import entity.Entity;
/**
 * Карта, содержит в себе коллекцию для хранения существ и их расположения.
 */
public class Map {

    static final int MAX_LENGTH = 30;
    static final int MAX_HEIGHT = 8;
    public Entity[][] matrix;

    public Map () {
        Entity[][] matrix = new Entity[MAX_HEIGHT][MAX_LENGTH];
        this.matrix = matrix;
    }

    public Entity getEntity(int x, int y) {
        return this.matrix[y][x];
    }
    public void setEntity(int x, int y, Entity entity) {
        this.matrix[y][x] = entity;
    }

    public String prepareMapDisplay() {
        String displayMap = "";
        for (int i = 0; i<this.MAX_HEIGHT; i++) {
            for (int j = 0; j<this.MAX_LENGTH; j++) {
                if (this.matrix[i][j] != null)
                    displayMap += this.matrix[i][j].getImage() + " ";
                else
                    System.out.print("  ");
            }
            displayMap += "\n";
        }
        return displayMap;
    }




}






