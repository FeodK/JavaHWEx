package util;

import java.time.LocalDate;

import exception.InvalidDataFormatException;
import model.Person;

public class PersonParser {
    public static Person parsePerson(String input) throws InvalidDataFormatException {
        String[] data = input.split("\\s+");
        if (data.length != 6) {
            throw new InvalidDataFormatException("Ошибка: Введено неверное количество данных.");
        }

        String lastName = data[0];
        String firstName = data[1];
        String middleName = data[2];
        LocalDate dob;
        long phoneNumber;
        char gender;

        try {
            dob = LocalDate.parse(data[3], java.time.format.DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        } catch (java.time.format.DateTimeParseException e) {
            throw new InvalidDataFormatException("Ошибка: Неверный формат даты рождения.");
        }

        try {
            phoneNumber = Long.parseLong(data[4]);
            if (phoneNumber <= 0) {
                throw new InvalidDataFormatException("Ошибка: Номер телефона должен быть положительным числом.");
            }
        } catch (NumberFormatException e) {
            throw new InvalidDataFormatException("Ошибка: Номер телефона должен быть числом.");
        }

        if (!data[5].matches("[mf]")) {
            throw new InvalidDataFormatException("Ошибка: Пол должен быть 'm' или 'f'.");
        }

        gender = data[5].charAt(0);

        return new Person(lastName, firstName, middleName, dob, phoneNumber, gender);
    }
}
