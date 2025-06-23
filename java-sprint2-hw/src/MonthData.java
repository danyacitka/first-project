public class MonthData {
    int[] days = new int[30];



    void printDaysAndStepsFromMonth() {
        for (int i = 0; i < days.length; i++) {
            // вывод элементов массива в нужном формате
            System.out.println((i+1) + " день: " + days[i]);
        }
    }

    int sumStepsFromMonth() {
        int sumSteps = 0;
        for (int i = 0; i < days.length; i++) {
            // подсчёт суммы элементов массива days[]
            sumSteps+=days[i];
        }
        return sumSteps;
    }

    int maxSteps() {
        int maxSteps = 0;
        for (int i = 0; i < days.length; i++) {
            // поиск максимального элемента
            if (days[i]>maxSteps){
                maxSteps=days[i];
            }
        }
        return maxSteps;
    }

    int bestSeries(int goalByStepsPerDay) {
        int currentSeries = 0;
        int finalSeries = 0;
        for (int i = 0; i < days.length; i++) {
            // поиск максимальной серии
            if (days[i] >= goalByStepsPerDay) {
                currentSeries++;
                if (currentSeries>finalSeries) {
                    finalSeries = currentSeries;
                }
            } else {
                currentSeries = 0;
            }
        }
        return finalSeries;
    }

        int mediumStepsSum() {
            int mediumSum = 0;
            int sum = 0;
            for (int i = 0; i < days.length; i++) {
                sum+=days[i];
            }

            mediumSum = sum/days.length;
            return mediumSum;
        }
    }

