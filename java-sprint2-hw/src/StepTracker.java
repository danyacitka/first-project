import java.util.InputMismatchException;
import java.util.Scanner;

class StepTracker {
    int goalByStepsPerDay = 10000;
    Scanner scanner;
    MonthData[] monthToData = new MonthData[12];
    Converter converter = new Converter();
    StepTracker(Scanner scan) {
        scanner = scan;
        for (int i = 0; i < monthToData.length; i++) {
            monthToData[i] = new MonthData();
        }
    }

    void addNewNumberStepsPerDay() {
        System.out.println("Введите номер месяца");
        try {
            int month = scanner.nextInt();
        /* не стал менять nextint на next, так как для проверки условий ниже нужно было бы переводить строку
        в численное значение через Integer.ParseInt(); , а это в свою очередь может выдать ошибку NumberFormatExeption
        при вводе строки из букв, которую пришлось бы обработать через try catch, как и в случае с InputMismatchExeption,
        так что для удобства чтения кода я решил не усложнять его конструкцию, надеюсь на ваше понимание :3
        Также я заметил, что при вводе текста вместо чисел, в методах этого класса не возникает ошибка,
        но я на всякий случай добавлю try catch */
            if (month <= 0 || month > 12) {
                System.out.println("Введено неправильное число\n" + "-------------------------"); //пустая строка сделана с целью удобства чтения меню
                return;
            }

            System.out.println("Введите день от 1 до 30 (включительно)");
            int day = scanner.nextInt();
            if (day <= 0 || day > 30) {// обратить внимание на условие, если количество дней будет меняться
                System.out.println("Введено неправильное число\n" + "-------------------------");
                return;
            }

            System.out.println("Введите количество шагов");
            int steps = scanner.nextInt();
            if (steps < 0) {
                System.out.println("Введено неправильное число\n" + "-------------------------");
                return;
            }
            // получение соответствующего объекта MonthData из массива
            monthToData[month - 1].days[day - 1] = steps;
            // сохранение полученных данных
        } catch (InputMismatchException e) {
            System.out.println("Введено неправильное число\n" + "-------------------------");
            scanner.next();
            }
    }

    void changeStepGoal() {
        System.out.println("Введите новое значение цели шагов за день");
        int newGoalForSteps = scanner.nextInt();
        if (newGoalForSteps <= 0) {
            System.out.println("Введено неправильное число\n" + "-------------------------");
        } else {
            goalByStepsPerDay = newGoalForSteps;
        }
    }

        void printStatistic() {
            System.out.println("Введите номер месяца");
            int month = scanner.nextInt();
            if (month <= 0 || month > 12) {
                System.out.println("Введено неправильное число\n" + "-------------------------");
                return;
            }
                monthToData[month-1].printDaysAndStepsFromMonth();
                System.out.println("Общее количество шагов за месяц: " + monthToData[month-1].sumStepsFromMonth());
                System.out.println("Максимальное пройденное количество шагов в месяце: "
                        + monthToData[month-1].maxSteps());
                System.out.println("Cреднее количество шагов: " + monthToData[month-1].mediumStepsSum());
                System.out.println("Пройденная дистанция: "
                        + converter.convertToKm(monthToData[month-1].sumStepsFromMonth()) + " км");
                converter.convertStepsToKilocalories(monthToData[month-1].sumStepsFromMonth());
                System.out.println("Количество сожжённых килокалорий: "
                        + converter.convertStepsToKilocalories(monthToData[month-1].sumStepsFromMonth()));
                System.out.println("Лучшая серия: " + monthToData[month-1].bestSeries(goalByStepsPerDay));
                System.out.println("-------------------------");
            }
        }

