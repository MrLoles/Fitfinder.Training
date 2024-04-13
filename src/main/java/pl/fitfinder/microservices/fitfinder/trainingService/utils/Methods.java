package pl.fitfinder.microservices.fitfinder.trainingService.utils;

public class Methods {

    public static boolean isInteger(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
