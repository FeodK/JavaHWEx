package util;

public class PersonInputValidator {
    public static boolean validateInput(String input) {
        String[] data = input.split("\\s+");
        return data.length == 6;
    }
}
