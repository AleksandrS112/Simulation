package entity;

/**
 * Корневой абстрактный класс для всех существ и объектов существующих в симуляции.
 */
public abstract class Entity {     //- сущность (объект) на доске

    private int x;
    private int y;
    protected String image;

    protected Entity(String image) {
        this.image = image;
    }






    public String getImage() {
        return this.image;
    }



}

