import mapWorld.MapWorld;

public class Simulation {

        private final int quantityHerbivore;
        private final int quantityPredator;
        private final int quantityGrass;
        private final int quantityRock;
        private final int quantityTree;
        private MapWorld mapWorld;
        private int moveCount;

        {
                moveCount = 1;
        }


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
                System.out.println("___Симуляция №" +this.moveCount +"___");
                Action.initAndSpawnActions(this);
                Action.turnActions(this);
                moveCount++;
                System.out.println(Render.renderMapWorld(this));
        }

        public void startSimulation() {
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











