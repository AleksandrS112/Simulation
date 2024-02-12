package MapWorld;

public class Cell {

    private int x;
    private int y;

    Cell(int y, int x) {
        this.y = y;
        this.x = x;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public static Cell findEmptyCell(MapWorld mapWorld) {
        while (true) {
            int y = (int) (Math.random() * mapWorld.getHeight()-1);
            int x = (int) (Math.random() * mapWorld.getLength()-1);
            if (mapWorld.cellIsEmpty(y, x))
                return new Cell(y,x);
        }
    }

}
