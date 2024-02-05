import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("Бесконечная симуляци - [A], по 1 симуляции всего поля - [B], по ходам сущщества [C], выйди [D]");
            String input = sc.nextLine().toUpperCase();
            switch (input) {
                case "A":

                    break;
                case "B":
                    Simulation s = new Simulation();
                    s.nextTurn();
                    while (true) {
                        System.out.println("Просимулировать еще ход ? [Y] : [N]");
                        input = sc.nextLine().toUpperCase();
                        if (input.equals("Y")) {
                            s.nextTurn();
                        } else if (input.equals("N")) {
                            break;
                        } else {
                            System.out.println("Ошибка ввода.");
                        }
                    }
                    break;
                case "C":

                    break;
                case "D":
                    return;
                default:
                    System.out.println("Ошбика ввода");
            }
        }
    }
}
