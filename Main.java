import model.Person;
import util.PersonInputValidator;
import util.PersonParser;
import util.FileManager;
import exception.InvalidDataFormatException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Введите данные в формате: Фамилия Имя Отчество дата_рождения номер_телефона пол");
            String input = scanner.nextLine().trim();

            if (!PersonInputValidator.validateInput(input)) {
                System.out.println("Ошибка: Введено неверное количество данных.");
                return;
            }

            try {
                Person person = PersonParser.parsePerson(input);
                FileManager.writeToFile(person);
                System.out.println("Данные успешно записаны в файл.");
            } catch (InvalidDataFormatException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}