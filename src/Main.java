//import java.util.Scanner;
//
//public class Main {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        while (true) {
//            System.out.println("Бесконечная симуляци c базовыми значениями - [A].\n"+
//                               "По 1 симуляции всего поля - [B]. Выйди - [D]");
//            String input = sc.nextLine().toUpperCase();
//            switch (input) {
//
////                case "A":
////                    Simulation sA = new Simulation(8, 20,
////                                                   2, 1,
////                                                   1, 3, 3);
////                    while (true) sA.nextTurn();
//
//                case "B":
//                    Simulation sB = new Simulation(8, 20,
//                                                   2, 1,
//                                                   3, 3, 3);
//                    Action.initActions(sB);
//                    sB.nextTurn();
//                    while (true) {
//                        System.out.println("Просимулировать еще ход ? [Y] : [N]");
//                        input = sc.nextLine().toUpperCase();
//                        if (input.equals("Y")) {
//                            sB.nextTurn();
//                        } else if (input.equals("N")) {
//                            break;
//                        } else {
//                            System.out.println("Ошибка ввода.");
//                        }
//                    }
//                    break;
//                case "C":
//
//                    break;
//                case "D":
//                    return;
//                default:
//                    System.out.println("Ошбика ввода");
//            }
//        }
//    }
//}
