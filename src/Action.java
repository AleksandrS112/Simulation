import mapWorld.MapWorld;
import entity.creature.Creature;
import entity.creature.Herbivore;
import mapWorld.Cell;
import entity.creature.Predator;
import entity.motionoless.Grass;
import entity.motionoless.Rock;
import entity.motionoless.Tree;

import java.util.List;
import java.util.stream.Collectors;

public class Action {

    public static void initAndSpawnActions(Simulation sim) {
        // если количество конкретных Entity на карте меньше чем должно быть спавнит до необходимого
        MapWorld mapWorld = sim.getMapWorld();
        for (int i = mapWorld.countEntityClass(Herbivore.class) ; i<sim.getQuantityHerbivore(); i++)
            mapWorld.addEntity(Cell.findEmptyCell(mapWorld), new Herbivore(mapWorld));
        for (int i = mapWorld.countEntityClass(Predator.class); i<sim.getQuantityPredator(); i++)
            mapWorld.addEntity(Cell.findEmptyCell(mapWorld), new Predator(mapWorld));
        for (int i = mapWorld.countEntityClass(Grass.class) ; i<sim.getQuantityGrass(); i++)
            mapWorld.addEntity(Cell.findEmptyCell(mapWorld), new Grass(mapWorld));
        for (int i = mapWorld.countEntityClass(Rock.class) ; i<sim.getQuantityRock(); i++)
            mapWorld.addEntity(Cell.findEmptyCell(mapWorld), new Rock(mapWorld));
        for (int i = mapWorld.countEntityClass(Tree.class) ; i<sim.getQuantityTree(); i++)
            mapWorld.addEntity(Cell.findEmptyCell(mapWorld), new Tree(mapWorld));
    }

    public static void turnActions(Simulation sim) {
        //   - если по координатам перебирать, то кто-то может сходить 2 раза т.к. существа двигаются
        //   - поэтому через лист, но нужна проверка, что существо еще на карте т.к. оно может умереть
        //     пока ходят других существа и лист может быть уже не актуальным
        //   - сортировка по классу перед makeMove() для того, чтобы сначала сходили травоядные потому
        //     что они двигаются и будет некорректный рендер, из-за того, что рендер будет только после
        //     того как сходят все
        List<Creature> listCreature = sim.getMapWorld().getListCreature().stream()
                .sorted((o1, o2) -> {
                    if (o1.getClass() == Predator.class)
                        return 1;
                    else
                        return -1;})
                .collect(Collectors.toList());
        for (Creature creature : listCreature) {
            if (sim.getMapWorld().isTheEntityOnTheMap(creature)) {
                creature.makeMove();
            }
        }
    }

}