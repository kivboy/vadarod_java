package by.vadarod.javaee.lesson1;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Main {
    private static final String PROPERTIES_FILE_NAME = "lesson_1.properties";

    public static void main(String[] args) {
        Properties properties = new Properties();

        try (InputStream input = Main.class.getClassLoader()
                .getResourceAsStream(PROPERTIES_FILE_NAME)) {

            if (input == null) {
                System.out.println("Не удалось найти файл lesson_1.properties");
                return;
            }

            properties.load(input);

            String ownerName = properties.getProperty("OwnerName");
            String ownerEmail = properties.getProperty("OwnerEmail");

            System.out.printf("Hello, %s <%s>!", ownerName, ownerEmail);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}