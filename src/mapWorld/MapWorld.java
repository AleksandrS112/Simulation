package mapWorld;

import entity.Entity;
import entity.creature.Creature;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

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

    public void deleteEntity(Cell cell) {
        this.map.remove(cell);
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

    public int countEntityClass (Class requiredClass) {
        return (int) this.getListEntity().stream().filter(e -> e.getClass() == requiredClass).count();
    }

    public boolean isTheEntityOnTheMap (Entity entity) {
        return map.containsValue(entity);
    }

    public void addEntity(Cell cell, Entity entity) {
        map.put(cell, entity);
    }

    public void moveEntity(Cell targetСell, Creature creature) {
        this.addEntity(targetСell, this.map.remove(this.getCellEntity(creature)));
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







