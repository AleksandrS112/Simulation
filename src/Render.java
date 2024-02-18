import MapWorld.Cell;
import MapWorld.MapWorld;
import entity.Entity;

public class Render {
        public static String renderMapWorld(Simulation sim) {
            MapWorld mapWorld = sim.getMapWorld();
            int height = mapWorld.getHeight();
            int length = mapWorld.getLength();
            String renderMapWorld = "";
            renderMapWorld += ("Cимуляция " +sim.getMoveCount() +"\n");
            for (int i = 0; i < height; i++) {
                for (int j = 0; j < length; j++) {
                    Entity entity = mapWorld.getEntity(new Cell(i, j));
                    if (entity != null) {
                        renderMapWorld += entity.getImage();
                    } else {
                        renderMapWorld += "⬜";
                    }
                }
                renderMapWorld += "\n";
            }
            return renderMapWorld;
        }

}

