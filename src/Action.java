import MapWorld.MapWorld;
import entity.creature.Herbivore;
import entity.creature.Predator;
import entity.motionoless.Grass;
import entity.motionoless.Rock;
import entity.motionoless.Tree;
import MapWorld.*;

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
        for (int i = mapWorld.countOfEntityOnTheMap(Herbivore.class); i < Herbivore.getQuantity(); i++)
            mapWorld.setEntity(Cell.findEmptyCell(mapWorld), new Herbivore(mapWorld));
        for (int i = mapWorld.countOfEntityOnTheMap(Predator.class); i < Predator.getQuantity(); i++)
            mapWorld.setEntity(Cell.findEmptyCell(mapWorld), new Predator(mapWorld));
        for (int i = mapWorld.countOfEntityOnTheMap(Grass.class); i < Grass.getQuantity(); i++)
            mapWorld.setEntity(Cell.findEmptyCell(mapWorld), new Grass(mapWorld));
        for (int i = mapWorld.countOfEntityOnTheMap(Rock.class); i < Rock.getQuantity(); i++)
            mapWorld.setEntity(Cell.findEmptyCell(mapWorld), new Rock(mapWorld));
        for (int i = mapWorld.countOfEntityOnTheMap(Tree.class); i < Tree.getQuantity(); i++)
            mapWorld.setEntity(Cell.findEmptyCell(mapWorld), new Tree(mapWorld));
    }

}