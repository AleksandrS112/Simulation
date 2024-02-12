package entity.creature;

import MapWorld.MapWorld;
import entity.Entity;
import java.util.Optional;

/**
 * Абстрактный класс "Существо" наследуется от корневого абстрактного класа, имеет:
 *  - количество HP; ☑
 *  - скорость (сколько клеток может пройти за 1 ход); ☑
 *  - способность к голоду (сколько HP отнимается за 1 ход); ☑
 *
 * Абстрактный метод makeMove() - сделать ход.
 */
public abstract class Creature extends Entity {
    private int healthPoints;
    private int speed;
    protected int hunger;
    private int range;

    Creature(MapWorld mapWorld, String image, int healthPoints, int speed, int hunger,  int range) {
        super(mapWorld, image);
        this.healthPoints = healthPoints;
        this.speed = speed;
        this.hunger = hunger;
        this.range = range;
    }

    public abstract void makeMove(MapWorld map);

    public int getRange() {
        return range;
    }

    Optional<? extends Entity> searchForGoal(MapWorld map, Class <? extends Entity> classTarget ) {
        int x = getX();
        int y = getY();
            for (int i = 0; i<map.getHeight(); i++) {
                for (int j = 0; j< map.getLength(); j++) {
                    if (map.getEntity(i, j) != null) {
                        if (map.getEntity(i, j).getClass() == classTarget) {
                            Optional<Entity> target = Optional.of(map.getEntity(i, j));
                            return target;
                        }
                    }
                }
            }
            return Optional.empty();
        }

    public void move(MapWorld map, Creature creature, Entity target) {
        int difY = creature.getY() - target.getY();
        int difX = creature.getX() - target.getX();
        boolean makeAMove = false;
        int rangeMove = 0;
        if (Math.abs(difY) > creature.getRange()) {
            if (difY > 0) {
                rangeMove = -creature.getRange();
                for (; rangeMove <= -1; rangeMove++) {
                    if (map.getEntity(creature.getY() + rangeMove, creature.getX()) == null) {
                        map.setEntity(creature.getY() + rangeMove, creature.getX(), creature);
                        makeAMove = true;
                        break;
                    }
                }
            } else {
                rangeMove = creature.getRange();
                for (; rangeMove >= 1; rangeMove--) {
                    if (map.getEntity(creature.getY() + rangeMove, creature.getX()) == null) {
                        map.setEntity(creature.getY() + rangeMove, creature.getX(), creature);
                        makeAMove = true;
                        break;
                    }
                }
            }
        }
        if (makeAMove == false && Math.abs(difX) > creature.getRange()) {
            if (difX > 0) {
                rangeMove = -creature.getRange();
                for (; rangeMove <= -1; rangeMove++) {
                    if (map.getEntity(creature.getY(), creature.getX() + rangeMove) == null) {
                        map.setEntity(creature.getY(), creature.getX() + rangeMove, creature);
                        makeAMove = true;
                        break;
                    }
                }
            } else {
                rangeMove = creature.getRange();
                for (; rangeMove >= 1; rangeMove--) {
                    if (map.getEntity(creature.getY(), creature.getX() + rangeMove) == null) {
                        map.setEntity(creature.getY(), creature.getX() + rangeMove, creature);
                        makeAMove = true;
                        break;
                    }
                }
            }
        }
    }

    protected void takeDamage(int damage, MapWorld map) {
        this.healthPoints -= damage;
        System.out.println(this.getImage() +" получил урон -" +damage +"[" +this.healthPoints +" HP]");
        if (this.healthPoints <= 0) {
            System.out.println(this.getImage() +" умер.");
            map.setEntity(this.getY(), this.getX(), null);
            Creature c = this;
            c = null;
        }
    }

    protected void restoreHealth(int health) {
        this.healthPoints = Math.min(this.healthPoints + health, 100);
        System.out.println(this.getImage() +" отхилился +" +health +"[" +this.healthPoints +" HP]");
    }

    public int getHealthPoints() {
        return healthPoints;
    }
}
