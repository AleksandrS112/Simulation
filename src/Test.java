import entity.creature.Herbivore;
import entity.creature.Predator;

public class Test {
    public static void main(String[] args) {
        Predator p1 = new Predator();
        Herbivore h1 = new Herbivore();
        System.out.println(p1.getImage());
        System.out.println(h1.getImage());



    }
}
