import entity.Entity;
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
        for (int i=0; i<map.MAX_HEIGHT; i++) {
            for (int j=0; j<map.MAX_LENGTH; j++) {
                Predator en1 = new Predator();
                map.matrix[i][j] = en1;
            }
        }
    }

    public void fillMap (Map map) {
        for (int i=0; i<2 ; i++) {
            boolean is
        }
        //поставить существ
        //поставить камни
    }

}
