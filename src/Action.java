import entity.Entity;
import entity.creature.Herbivore;
import entity.creature.Predator;

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
                x = 1 + (int) (Math.random() * ((map.getLength()-1) - 1 + 1));
                y = 1 + (int) (Math.random() * ((map.getHeight()-1) - 1 + 1));
                System.out.println(x +" " +y);
                if (map.getEntity(x, y) == null)
                    break;
            }
            map.setEntity(x,y,new Predator());
        }
        for (int i = 0, x = 0, y = 0; i< Herbivore.getQuantity(); i++) {
            while (true) {
                x = 1 + (int) (Math.random() * ((map.getLength()-1) - 1 + 1));
                y = 1 + (int) (Math.random() * ((map.getHeight()-1) - 1 + 1));
                System.out.println(x +" " +y);
                if (map.getEntity(x, y) == null)
                    break;
            }
            map.setEntity(x,y,new Herbivore());
        }



        //поставить существ
        //поставить камни
    }

}
