import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StepTracker stepTracker = new StepTracker(scanner);
        while (true){
            printMenu();
            try {
                int command  = scanner.nextInt();
                /* Решил оставить nextInt, так как я оставил его в StepTracker (причину указал там в комментарии), а
                если чередовать между собой nextInt и next, то может появиться InputMismatchException, который все равно
                бы пришлось обработать через try catch */
                if (command == 1) {
                stepTracker.addNewNumberStepsPerDay();
            } else if (command == 2) {
                stepTracker.changeStepGoal();
            } else if (command == 3) {
                stepTracker.printStatistic();
            } else if (command == 4) {
                System.out.println("До свидания ♥");
                break;
            } else {
                System.out.println("Введена неправильная команда\n" + "-------------------------");
                }
            } catch (InputMismatchException e){
               System.out.println("Введена неправильная команда\n" + "-------------------------");
               scanner.next();
               }
            }
        }




    public static void printMenu() {
        System.out.println("Введите действие:");
        System.out.println("1 - Ввести количество шагов за определннный день");
        System.out.println("2 - Изменить цель по количеству шагов в день");
        System.out.println("3 - Напечатать статистику за определённый месяц");
        System.out.println("4 - Выйти из приложения.\n" + "-------------------------"); //пустая строка сделана с целью удобства чтения меню

    }
}

