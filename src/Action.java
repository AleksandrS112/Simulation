import MapWorld.MapWorld;
import entity.Entity;
import entity.creature.Creature;
import entity.creature.Herbivore;
import MapWorld.Cell;
import entity.creature.Predator;
import entity.motionoless.Grass;
import entity.motionoless.Rock;
import entity.motionoless.Tree;
import java.util.List;

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

    public static void initAndSpawnActions(Simulation sim) {
        // если количество конкретных Entity на карте меньше чем должно быть спавнит до необходимого
        MapWorld mapWorld = sim.getMapWorld();
        for (int i = mapWorld.countEntityClass(Herbivore.class) ; i<sim.getQuantityHerbivore(); i++) {
            Cell emptyCell = Cell.findEmptyCell(mapWorld);
            mapWorld.addEntity(emptyCell, new Herbivore(mapWorld));
        }
        for (int i = mapWorld.countEntityClass(Predator.class); i<sim.getQuantityPredator(); i++) {
            Cell emptyCell = Cell.findEmptyCell(mapWorld);
            mapWorld.addEntity(emptyCell, new Predator(mapWorld));
        }
        for (int i = mapWorld.countEntityClass(Grass.class) ; i<sim.getQuantityGrass(); i++) {
            Cell emptyCell = Cell.findEmptyCell(mapWorld);
            mapWorld.addEntity(emptyCell, new Grass(mapWorld));
        }
        for (int i = mapWorld.countEntityClass(Rock.class) ; i<sim.getQuantityRock(); i++) {
            Cell emptyCell = Cell.findEmptyCell(mapWorld);
            mapWorld.addEntity(emptyCell, new Rock(mapWorld));
        }
        for (int i = mapWorld.countEntityClass(Tree.class) ; i<sim.getQuantityTree(); i++) {
            Cell emptyCell = Cell.findEmptyCell(mapWorld);
            mapWorld.addEntity(emptyCell, new Tree(mapWorld));
        }
    }

    public static void turnActions(Simulation sim) {
        // - если по координатам перебирать, то кто то может сходить 2 раза т.к. существа двигаются
        // - поэтому через лист но нужна проверка, что существо еще на карте т.к. оно может умереть
        //   пока ходят други существа и лист может быть уже не актуальным
        for (Creature creature : sim.getMapWorld().getListCreature()) {
            if (sim.getMapWorld().isTheEntityOnTheMap(creature)) {
                creature.makeMove();
            }
        }
    }

}