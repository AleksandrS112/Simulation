
import java.util.Scanner;

public class Main {
   public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("Бесконечная симуляции - [A].\n"+
                               "По 1 симуляции всего поля - [B]. Выйди - [D]");
            String input = sc.nextLine().toUpperCase();
            Simulation simulation = new Simulation(8, 30,
                                                   2, 1,
                                                   3, 20, 15);
            switch (input) {
                case "A":
                    while (true) simulation.startSimulation();
                case "B":
                    while (true) {
                        System.out.println("Просимулировать ход - [Y] : Выйти - [N]");
                        input = sc.nextLine().toUpperCase();
                        if (input.equals("Y")) {
                            simulation.nextTurn();
                        } else if (input.equals("N")) {
                            break;
                        } else {
                            System.out.println("Ошибка ввода.");
                        }
                    }
                    break;
                case "D":
                    return;
                default:
                    System.out.println("Ошибка ввода");
           }
        }
    }
}

