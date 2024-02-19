import MapWorld.MapWorld;
import entity.Entity;
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
        MapWorld mapWorld = sim.getMapWorld();
        for ( mapWorld.countEntiry(Herbivore) ; i<sim.getQuantityHerbivore(); i++) 
            mapWorld.addEntity(Cell.findEmptyCell(mapWorld), Herbivore.createHerbivore(mapWorld));
        for ( mapWorld.countEntiry(Herbivore) ; i<sim.getQuantityHerbivore(); i++) 
            mapWorld.addEntity(Cell.findEmptyCell(mapWorld), Herbivore.createHerbivore(mapWorld));
        for (  mapWorld.countEntiry(Herbivore); i<sim.getQuantityHerbivore(); i++) 
            mapWorld.addEntity(Cell.findEmptyCell(mapWorld), Herbivore.createHerbivore(mapWorld));
        for (  mapWorld.countEntiry(Herbivore) ; i<sim.getQuantityHerbivore(); i++) 
            mapWorld.addEntity(Cell.findEmptyCell(mapWorld), Herbivore.createHerbivore(mapWorld));
        for (  mapWorld.countEntiry(Herbivore); i<sim.getQuantityHerbivore(); i++) 
            mapWorld.addEntity(Cell.findEmptyCell(mapWorld), Herbivore.createHerbivore(mapWorld));
    }

    public static void turnActions(Simulation sim) {
        // - если по координатам перебирать, то кто то может сходить 2 раза т.к. существа двигаются
        // - поэтому через лист но нужна проверка, что существо еще на карте т.к. оно может умереть
        //   пока ходят други существа и лист может быть уже не актуальным
        for (Entity creature : sim.getMapWorld().getListCreature()) {
            if (sim.getMapWorld().isTheEntityOnTheMap(creature)) {

            }
        }
        Action.initAndSpawnActions(sim);
    }

}
