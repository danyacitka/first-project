public class Converter {
    int stepInCm = 75;
    int caloriesPerStep = 50;

    int convertToKm(int steps){
        int kilometers = steps * stepInCm / 100000;
        return kilometers;
    }

    int convertStepsToKilocalories(int steps){
        int kiloCalories = steps * caloriesPerStep / 1000;
        return kiloCalories;
    }
}
