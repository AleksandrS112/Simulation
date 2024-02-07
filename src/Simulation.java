import entity.creature.Creature;

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

        public Mapa mapa;
        private int moveCount;

        public Simulation() {
                this.mapa = new Mapa();
                Action.initAndTurnActions(this.mapa);
        }

        void nextTurn() {
                for (int i = 0; i < this.mapa.getHeight(); i++) {
                        for (int j = 0; j < this.mapa.getLength(); j++) {
                                if (this.mapa.getEntity(j, i) instanceof Creature) {
                                        Creature creature = (Creature) this.mapa.getEntity(j, i);
                                        creature.makeMove(this.mapa);
                                }
                        }
                }
                System.out.println(this.mapa.prepareMapDisplay());
        }
}











