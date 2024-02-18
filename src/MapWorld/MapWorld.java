package MapWorld;

import entity.*;
import entity.creature.Creature;
import MapWorld.Cell;

import java.util.*;

public class MapWorld {

    private final int height;
    private final int length;
    private HashMap<Cell, Entity> map;

    public MapWorld(int height, int length) {
        this.map = new HashMap<Cell, Entity>();
        this.height = height;
        this.length = length;
    }

    public boolean cellIsEmpty(Cell cell) {
        return !map.containsKey(cell);
    }

    public Entity getEntity(Cell cell) {
        return map.get(cell);
    }

    public List<Entity> getListEntity() {
       return new ArrayList<Entity>(map.values());
    }

    public List<Creature> getListCreature() {
        return this.map.values().stream()
                .filter(entity -> entity instanceof Creature)
                .map(e -> (Creature) e)
                .toList();
    }

    public boolean isTheEntityOnTheMap (Entity entity) {
        return map.containsValue(entity);
    }

    public void setEntity(Cell cell, Entity entity) {
        map.put(cell, entity);
    }

    public Cell getCellEntity(Entity entity) {
        return this.map.entrySet().stream()
                .filter(e -> e.getValue() == entity)
                .map(e -> e.getKey())
                .findFirst()
                .get();
    }

    public int getHeight() {
        return height;
    }

    public int getLength() {
        return length;
    }

}







