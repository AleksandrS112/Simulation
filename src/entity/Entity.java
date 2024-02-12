package entity;

import MapWorld.MapWorld;

public abstract class Entity {

    private int y;
    private int x;
    private final MapWorld mapWorld;
    private final String image;

    protected Entity(MapWorld mapWorld, String image) {
        this.mapWorld = mapWorld;
        this.image = image;
    }

    public String getImage() {
        return this.image;
    }

    public void setYX (int y, int x) {
        this.y = y;
        this.x = x;
    }

    public int getY() {
        return this.y;
    }

    public int getX() {
        return this.x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setX(int x) {
        this.x = x;
    }
}

