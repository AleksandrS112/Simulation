public class Test {
    public static void main(String[] args) {
        Simulation s = new Simulation(8,20,2,2,2,2,2);
        s.startSimulation();
        System.out.println(Render.renderMapWorld(s));
    }

}
