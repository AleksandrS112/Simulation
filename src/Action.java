import MapWorld.MapWorld;
import entity.creature.Herbivore;
import entity.creature.Predator;
import entity.motionoless.Grass;
import entity.motionoless.Rock;
import entity.motionoless.Tree;

import java.util.Arrays;

/**
 *  Action - действие, совершаемое над миром. Например - сходить всеми существами.
 *  Это действие итерировало бы существ и вызывало каждому makeMove().
 *  Каждое действие описывается отдельным классом и совершает операции над картой.
 *
 *  Симуляция содержит 2 массива действий:
 *   - initActions - действия, совершаемые перед стартом симуляции. Пример - расставить объекты и существ на карте
 *   - turnActions - действия, совершаемые каждый ход. Примеры - передвижение существ, добавить травы или травоядных,
 *     если их осталось слишком мало
 */

public class Action {

    public Action(MapWorld mapWorld) {

    }

    static void initAndTurnActions(MapWorld mapWorld) {
        int i = (int) Arrays.stream(mapWorld.getMatrixMap()).flatMap(Arrays::stream)
                    .filter(Herbivore.class::isInstance).count();
        for( ; i< Herbivore.getQuantity(); i++) {
            Cell cell = findEmptyCell(mapWorld);
            mapWorld.setEntity(cell.getY(),cell.getX(), new Herbivore());
            System.out.println("создалось Травоядное [" +cell.getY() +";" +cell.getX() +"]");
        }
        i = (int) Arrays.stream(mapWorld.getMatrixMap()).flatMap(Arrays::stream)
                .filter(Predator.class::isInstance).count();
        for( ; i< Predator.getQuantity(); i++) {
            Cell cell = findEmptyCell(mapWorld);
            mapWorld.setEntity(cell.getY(),cell.getX(), new Predator());
            System.out.println("создалось Хищник [" +cell.getY() +";" +cell.getX() +"]");
        }
        i = (int) Arrays.stream(mapWorld.getMatrixMap()).flatMap(Arrays::stream)
                .filter(Grass.class::isInstance).count();
        for( ; i< Grass.getQuantity(); i++) {
            Cell cell = findEmptyCell(mapWorld);
            mapWorld.setEntity(cell.getY(),cell.getX(), new Grass());
            System.out.println("создалось Трава [" +cell.getY() +";" +cell.getX() +"]");
        }
        i = (int) Arrays.stream(mapWorld.getMatrixMap()).flatMap(Arrays::stream)
                .filter(Rock.class::isInstance).count();
        for( ; i< Rock.getQuantity(); i++) {
            Cell cell = findEmptyCell(mapWorld);
            mapWorld.setEntity(cell.getY(),cell.getX(), new Rock());
            System.out.println("создалось Камень [" +cell.getY() +";" +cell.getX() +"]");
        }
        i = (int) Arrays.stream(mapWorld.getMatrixMap()).flatMap(Arrays::stream)
                .filter(Tree.class::isInstance).count();
        for(; i< Tree.getQuantity(); i++) {
            Cell cell = findEmptyCell(mapWorld);
            mapWorld.setEntity(cell.getY(),cell.getX(), new Tree());
            System.out.println("создалось Дерево [" +cell.getY() +";" +cell.getX() +"]");
        }
    }

    static Cell findEmptyCell(MapWorld mapWorld) {
        while (true) {
            int y = (int) (Math.random() * mapWorld.getHeight()-1);
            int x = (int) (Math.random() * mapWorld.getLength()-1);
            if (mapWorld.getEntity(y, x) == null) {
                return new Cell(y,x);
            }
        }
    }


}
class Cell {

    int x;
    int y;

    Cell(int y, int x) {
        this.y = y;
        this.x = x;
    }

    int getX() {
        return this.x;
    }

    int getY() {
        return this.y;
    }


}

