import MapWorld.MapWorld;

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

        private final int quantityHerbivore;
        private final int quantityPredator;
        private final int quantityGrass;
        private final int quantityRock;
        private final int quantityTree;
        private MapWorld mapWorld;
        private int moveCount;


        public Simulation(int heightMapWorld, int lengthMapWorld,
                          int quantityHerbivore, int quantityPredator,
                          int quantityGrass,
                          int quantityRock, int quantityTree)
        {
                        this.mapWorld = new MapWorld(heightMapWorld, lengthMapWorld);
                        this.quantityHerbivore = quantityHerbivore;
                        this.quantityPredator = quantityPredator;
                        this.quantityGrass = quantityGrass;
                        this.quantityRock = quantityRock;
                        this.quantityTree = quantityTree;
        }

        public void nextTurn() {
                System.out.println(Render.renderMapWorld(this));
                Action.initAndSpawnActions(this);
                Action.turnActions(this);
                moveCount++;
        }

        public void startSimulation() {
                Action.initAndSpawnActions(this);
                Render.renderMapWorld(this);
                while (true) {
                        this.nextTurn();
                }
        }

        public MapWorld getMapWorld() {
                return mapWorld;
        }

        public int getQuantityHerbivore() {
                return quantityHerbivore;
        }

        public int getQuantityPredator() {
                return quantityPredator;
        }

        public int getQuantityGrass() {
                return quantityGrass;
        }

        public int getQuantityRock() {
                return quantityRock;
        }

        public int getQuantityTree() {
                return quantityTree;
        }

        public int getMoveCount() {
                return moveCount;
        }
}











