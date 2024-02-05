import entity.Entity;
import entity.creature.Herbivore;
import entity.creature.Predator;
import entity.motionoless.Grass;
import entity.motionoless.Rock;
import entity.motionoless.Tree;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

    public Action(Map map) {

    }

    static void initAndTurnActions(Map map) {
        int i = (int) Arrays.stream(map.getMatrixMap()).flatMap(Arrays::stream)
                    .filter(Herbivore.class::isInstance).count();
        for( ; i< Herbivore.getQuantity(); i++) {
            Cell cell = findEmptyCell(map);
            map.setEntity(cell.getX(),cell.getY(), new Herbivore());
        }
        i = (int) Arrays.stream(map.getMatrixMap()).flatMap(Arrays::stream)
                .filter(Predator.class::isInstance).count();
        for( ; i< Predator.getQuantity(); i++) {
            Cell cell = findEmptyCell(map);
            map.setEntity(cell.getX(),cell.getY(), new Predator());
        }
        i = (int) Arrays.stream(map.getMatrixMap()).flatMap(Arrays::stream)
                .filter(Grass.class::isInstance).count();
        for( ; i< Grass.getQuantity(); i++) {
            Cell cell = findEmptyCell(map);
            map.setEntity(cell.getX(),cell.getY(), new Grass());
        }
        i = (int) Arrays.stream(map.getMatrixMap()).flatMap(Arrays::stream)
                .filter(Rock.class::isInstance).count();
        for( ; i< Rock.getQuantity(); i++) {
            Cell cell = findEmptyCell(map);
            map.setEntity(cell.getX(),cell.getY(), new Rock());
        }
        i = (int) Arrays.stream(map.getMatrixMap()).flatMap(Arrays::stream)
                .filter(Tree.class::isInstance).count();
        for(; i< Tree.getQuantity(); i++) {
            Cell cell = findEmptyCell(map);
            map.setEntity(cell.getX(),cell.getY(), new Tree());
        }
    }

    static Cell findEmptyCell(Map map) {
        while (true) {
            int x = (int) (Math.random() * map.getLength());
            int y = (int) (Math.random() * map.getHeight());
            if (map.getEntity(x, y) == null) {
                return new Cell(x,y);
            }
        }
    }

}
class Cell {

    int x;
    int y;

    Cell(int x, int y) {
        this.x = x;
        this.y = y;
    }

    int getX() {
        return this.x;
    }

    int getY() {
        return this.y;
    }


}

