//package entity.creature.BFS;
//
//import MapWorld.MapWorld;
//import entity.Entity;
//
//import java.util.ArrayList;
//import java.util.LinkedList;
//import java.util.List;
//import java.util.Queue;
//
//public class BFS {
//
//    public Cell bfsDiagonalWithPath(MapWorld mapWorld, Entity entity, int startX, int startY, int target) {
//        int y = mapWorld.getHeight();
//        int x = mapWorld.getLength();
//        boolean[][] visited = new boolean[y][x];
//        Queue<Cell> queue = new LinkedList<>();
//        Cell startCell = new Cell(entity., startY);
//        startCell.path.add(startCell);
//        queue.add(startCell);
//        visited[startX][startY] = true;
//
//        int[] dx = {-1, 0, 1, 0, -1, -1, 1, 1};
//        int[] dy = {0, 1, 0, -1, -1, 1, -1, 1};
//
//        while (!queue.isEmpty()) {
//            Cell currentCell = queue.poll();
//            int x = currentCell.x;
//            int y = currentCell.y;
//
//            if (mapWorld[x][y] == target) {
//                return currentCell; // Нашли элемент, возвращаем текущую ячейку с путем до нее
//            }
//
//            for (int i = 0; i < 8; i++) { // Проверяем все возможные направления
//                int newX = x + dx[i];
//                int newY = y + dy[i];
//                if (newX >= 0 && newX < y && newY >= 0 && newY < x && !visited[newX][newY]) {
//                    visited[newX][newY] = true;
//                    Cell newCell = new Cell(newX, newY);
//                    newCell.path.addAll(currentCell.path); // Копируем путь до текущей ячейки
//                    newCell.path.add(newCell); // Добавляем текущую ячейку к пути
//                    queue.add(newCell);
//                }
//            }
//        }
//
//        return null; // Элемент не найден
//    }
//
//
//}
//
//class Cell {
//    int x;
//    int y;
//    List<Cell> path;
//
//    public Cell(int x, int y) {
//        this.x = x;
//        this.y = y;
//        this.path = new ArrayList<>();
//    }
//}