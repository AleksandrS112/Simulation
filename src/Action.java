import entity.Entity;
import entity.creature.Herbivore;
import entity.creature.Predator;
import entity.motionoless.Grass;
import entity.motionoless.Rock;
import entity.motionoless.Tree;

/**
 *  Action - действие, совершаемое над миром. Например - сходить всеми существами.
 *  Это действие итерировало бы существ и вызывало каждому makeMove().
 *  Каждое действие описывается отдельным классом и совершает операции над картой.
 *
 *  Симуляция содержит 2 массива действий:
 *   - initActions - действия, совершаемые перед стартом симуляции. Пример - расставить объекты и существ на карте
 *   - turnActions - действия, совершаемые каждый ход. Примеры - передвижение существ, добавить травы или травоядных,
 *     если их осталось слишком мало
 */

public class Action {

    public Action(Map map) {

    }

    public void fillMap (Map map) {
        for (int i=0, x=0, y=0; i<Predator.getQuantity(); i++) {
            while (true) {
                x = (int)(Math.random() * map.getLength());
                y = (int)(Math.random() * map.getHeight());
                if (map.getEntity(x, y) == null)
                    break;
            }
            map.setEntity(x,y,new Predator());
        }
        for (int i = 0, x = 0, y = 0; i< Herbivore.getQuantity(); i++) {
            while (true) {
                x = (int)(Math.random() * map.getLength());
                y = (int)(Math.random() * map.getHeight());
                if (map.getEntity(x, y) == null)
                    break;
            }
            map.setEntity(x,y,new Herbivore());
        }
        for (int i = 0, x = 0, y = 0; i< Grass.getQuantity(); i++) {
            while (true) {
                x = (int)(Math.random() * map.getLength());
                y = (int)(Math.random() * map.getHeight());
                if (map.getEntity(x, y) == null)
                    break;
            }
            map.setEntity(x,y,new Grass());
        }
        for (int i = 0, x = 0, y = 0; i< Rock.getQuantity(); i++) {
            while (true) {
                x = (int)(Math.random() * map.getLength());
                y = (int)(Math.random() * map.getHeight());
                if (map.getEntity(x, y) == null)
                    break;
            }
            map.setEntity(x,y,new Rock());
        }
        for (int i = 0, x = 0, y = 0; i< Tree.getQuantity(); i++) {
            while (true) {
                x = (int)(Math.random() * map.getLength());
                y = (int)(Math.random() * map.getHeight());
                if (map.getEntity(x, y) == null)
                    break;
            }
            map.setEntity(x,y,new Tree());
        }

        //поставить существ
        //поставить камни
    }

}
