package entity;

import MapWorld.MapWorld;

public abstract class Entity {

    protected final MapWorld mapWorld;
    private final String image;

    protected Entity(MapWorld mapWorld, String image) {
        this.mapWorld = mapWorld;
        this.image = image;
    }

    public String getImage() {
        return this.image;
    }

    public int getY() {
        return mapWorld.getCellEntity(this).getY();
    }
    public int getX() {
        return mapWorld.getCellEntity(this).getX();
    }

}

