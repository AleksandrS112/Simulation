import mapWorld.Cell;
import mapWorld.MapWorld;
import entity.Entity;
import entity.creature.Herbivore;
import entity.creature.Predator;

import java.util.List;

public class Render {
        public static String renderMapWorld(Simulation sim) {
            MapWorld mapWorld = sim.getMapWorld();
            int height = mapWorld.getHeight();
            int length = mapWorld.getLength();
            List<Cell> listPredatorTarget = mapWorld.getListCreature().stream()
                    .filter(c -> c instanceof Predator)
                    .map(h -> (Predator) h)
                    .filter(p -> p.getTarget() != null)
                    .flatMap(p -> p.getTarget().getPath().stream())
                    .toList();
            List<Cell> listHerbivoreTarget = mapWorld.getListCreature().stream()
                    .filter(c -> c instanceof Herbivore)
                    .map(h -> (Herbivore) h)
                    .filter(h -> h.getTarget() != null)
                    .flatMap(e -> e.getTarget().getPath().stream())
                    .toList();
            String[][] renderMapWorld = new String[height][length];
            for (int i = 0; i < height; i++) {
                for (int j = 0; j < length; j++) {
                    Entity entity = mapWorld.getEntity(new Cell(i, j));
                    if (entity != null) {
                        renderMapWorld[i][j] = entity.getImage();
                    } else if (listPredatorTarget.contains(new Cell(i,j))) {
                        renderMapWorld[i][j] = "\uD83D\uDD34";
                    } else if (listHerbivoreTarget.contains(new Cell(i,j))) {
                        renderMapWorld[i][j] = "\uD83D\uDFE9";
                    } else {
                        renderMapWorld[i][j] = "⬜";
                    }
                }
            }
            String resultRender = "";
            for (int i = 0; i < height; i++) {
                for (int j = 0; j < length; j++) {
                    resultRender += renderMapWorld[i][j];
                }
                resultRender += "\n";
            }
            return resultRender;
        }

}

