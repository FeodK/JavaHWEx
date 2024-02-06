package util;

import model.Person;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class FileManager {
    public static void writeToFile(Person person) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(person.getLastName() + ".txt", true))) {
            writer.write(person.toString() + "\n");
        } catch (IOException e) {
            System.out.println("Ошибка при записи в файл:");
            e.printStackTrace();
        }
    }
}
