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
        Map map;
        private int moveCount;
        private String displayMap;
        private Action action;

        public Simulation() {
                this.map = new Map();
                this.action = new Action(this.map);
        }

        void nextTurn() {

        }

        void startSimulation() {

        }

        void pauseSimulation() {

        }

}
