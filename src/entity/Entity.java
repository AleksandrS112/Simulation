package entity;


/**
 * Корневой абстрактный класс для всех существ и объектов существующих в симуляции.
 */
public abstract class Entity {     //- сущность (объект) на доске

    private int y;
    private int x;
    private final String image;

    protected Entity(String image) {
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

