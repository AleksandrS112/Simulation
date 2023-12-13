/**
 * Главный класс приложения, включает в себя:
 *     Карту
 *     Счётчик ходов
 *     Рендерер поля
 *     Actions - список действий, исполняемых перед стартом симуляции или на каждом ходу (детали ниже)
 *
 * Методы:
 *     nextTurn() - просимулировать и отрендерить один ход
 *     startSimulation() - запустить бесконечный цикл симуляции и рендеринга
 *     pauseSimulation() - приостановить бесконечный цикл симуляции и рендеринга
*/


public class Simulation {
        private Map map;
        private int moveCount;
      //private Action action;

        public Simulation() {
                this.map = new Map();
                this.action = new Action(this.map);
        }

        void nextTurn() {
                if (this.moveCount == 0) {
                        action.prepareMap(map);
                } else {
                        // action одна симуляция (map)
                }
                System.out.println(this.displayMap);
                this.moveCount++;
        }

        void startSimulation() {

        }

        void pauseSimulation() {

        }

        void setDisplayMap(String displayMap) {
                this.displayMap = displayMap;
        }

        String getDisplayMap () {
                return displayMap;
        }
}
