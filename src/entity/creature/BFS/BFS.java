package entity.creature.BFS;

import MapWorld.*;
import entity.Entity;
import entity.motionoless.Grass;

import java.util.LinkedList;
import java.util.Queue;

public class BFS {

    public static Cell bfsDiagonalWithPath(MapWorld mapWorld, Entity entity, Class targetClass) {
        int maxY = mapWorld.getHeight();
        int maxX = mapWorld.getLength();
        boolean[][] visited = new boolean[maxY][maxX];
        Queue<Cell> queue = new LinkedList<>();
        Cell startCell = new Cell(entity.getY(), entity.getX());
        startCell.getPath().add(startCell);
        queue.add(startCell);
        visited[entity.getY()][entity.getX()] = true;

        int[] dx = {-1, 0, 1, 0, -1, -1, 1, 1};
        int[] dy = {0, 1, 0, -1, -1, 1, -1, 1};

        while (!queue.isEmpty()) {
            Cell currentCell = queue.poll();
            int y = currentCell.getY();
            int x = currentCell.getX();

            Cell nCell = new Cell(y, x);
            if (!mapWorld.cellIsEmpty(nCell)) {
                if (mapWorld.getEntity(nCell).getClass() == targetClass) {
                    return currentCell; // Нашли элемент, возвращаем текущую ячейку с путем до нее
                }
            }

            for (int i = 0; i < 8; i++) { // Проверяем все возможные направления
                int newY = y + dy[i];
                int newX = x + dx[i];
                if (newX >= 0 && newX < maxX && newY >= 0 && newY < maxY && !visited[newY][newX]) {
                    visited[newY][newX] = true;
                    Cell newCell = new Cell(newY, newX);
                    newCell.getPath().addAll(currentCell.getPath()); // Копируем путь до текущей ячейки
                    newCell.getPath().add(newCell); // Добавляем текущую ячейку к пути
                    if (mapWorld.cellIsEmpty(newCell) || mapWorld.getEntity(newCell) instanceof Grass)
                        queue.add(newCell);
                }
            }
        }
        return null;
    }


}