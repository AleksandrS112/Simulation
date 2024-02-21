import MapWorld.Cell;
import MapWorld.MapWorld;
import entity.Entity;
import entity.creature.Herbivore;

import java.util.ArrayList;
import java.util.List;

public class Render {
        public static String renderMapWorld(Simulation sim) {
            MapWorld mapWorld = sim.getMapWorld();
            int height = mapWorld.getHeight();
            int length = mapWorld.getLength();
            List<Cell> listGreen = mapWorld.getListCreature().stream()
                    .filter(c -> c instanceof Herbivore)
                    .map(h -> (Herbivore) h)
                    .filter(h -> h.getTarget() != null)
                    .flatMap(e -> e.getTarget().getPath().stream())
                    .toList();
// двумерный массив сделать туда добавлять по методам потом выводить его
            String renderMapWorld = "";
            renderMapWorld += ("Cимуляция " +sim.getMoveCount() +"\n");
            for (int i = 0; i < height; i++) {
                for (int j = 0; j < length; j++) {
                    Entity entity = mapWorld.getEntity(new Cell(i, j));
                    if (entity != null) {
                        renderMapWorld += entity.getImage();
                    } else if (listGreen.contains(new Cell(i,j))) {
                        renderMapWorld += "\uD83D\uDFE9";
                    } else {
                        renderMapWorld += "⬜";
                    }
                }
                renderMapWorld += "\n";
            }
            return renderMapWorld;
        }

}

