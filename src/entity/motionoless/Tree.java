
package entity.motionoless;


/**
 * Класс "Дерево" наследуется от класса неподвижных объектов
 */


public class Tree extends Motionless {

        private static final String INITIAL_IMAGE = "\uD83C\uDF34";
        private static final int QUANTITY = 10;

        public Tree() {
            super(INITIAL_IMAGE);
        }

        public static int getQuantity() {
            return QUANTITY;
        }

}
