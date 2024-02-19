package MapWorld;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class Cell {

    private int y;
    private int x;
    LinkedList<Cell> path;

    public Cell(int y, int x) {
        this.y = y;
        this.x = x;
        this.path = new LinkedList<>();
    }

    public int getY() {
        return y;
    }

    public int getX() {
        return x;
    }

    public static Cell findEmptyCell(MapWorld mapWorld) {
        while (true) {
            int y = (int) (Math.random() * mapWorld.getHeight());
            int x = (int) (Math.random() * mapWorld.getLength());
            Cell newCell = new Cell(y, x);
            if (mapWorld.cellIsEmpty(newCell)) {
                Cell newEmptyCell = newCell;
                return newEmptyCell;
            }
        }

    }

    public LinkedList<Cell> getPath() {
        return path;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cell cell = (Cell) o;
        return y == cell.y && x == cell.x;
    }

    @Override
    public int hashCode() {
        return Objects.hash(y, x);
    }
}
