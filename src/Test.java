import entity.creature.Herbivore;
import entity.creature.Predator;

public class Test {
    public static void main(String[] args) {
        Map m1 = new Map();
        Action a1 = new Action(m1);
        a1.fillMap(m1);
        System.out.println(m1.prepareMapDisplay());

    }
}
