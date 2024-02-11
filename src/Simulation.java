import MapWorld.MapWorld;
import entity.Entity;
import entity.creature.Creature;

import java.util.ArrayList;
import java.util.List;

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

        public MapWorld mapWorld;
        private int moveCount;

        public Simulation() {
                this.mapWorld = new MapWorld();
                Action.initAndTurnActions(this.mapWorld);
                System.out.println(this.mapWorld.prepareMapDisplay());
        }

        void nextTurn() {
                Action.initAndTurnActions(this.mapWorld);
                List<Creature> repetitive = new ArrayList<>();
                for (int i = 0; i < this.mapWorld.getHeight()-1; i++) {
                        for (int j = 0; j < this.mapWorld.getLength()-1; j++) {
                                if (this.mapWorld.getEntity(i, j) == null)
                                        continue;
                                if (this.mapWorld.getEntity(i, j) instanceof Creature && !repetitive.contains(this.mapWorld.getEntity(i, j))) {
                                        Creature creature = (Creature) this.mapWorld.getEntity(i, j);
                                        repetitive.add(creature);
                                        creature.makeMove(this.mapWorld);
                                }
                        }
                }
                System.out.println(this.mapWorld.prepareMapDisplay());
        }
}











