package utils;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;

import java.util.Locale;

public class RandomUtils {
    private static final Faker FAKER = new Faker(new Locale("en-gb"));

    @Test
    void randomDatesFaker() {
        Faker faker = new Faker(new Locale("en-gb"));
        String ima = faker.name().fullName();
        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();
        String streetAddress = faker.address().streetAddress();
    }

    public static String generateRandomFirstName() {
        Faker faker = new Faker(new Locale("en-gb"));
        return faker.name().firstName();
    }

    public static String generateRandomLastName() {
        Faker faker = new Faker(new Locale("en-gb"));
        return faker.name().lastName();
    }

    public static String generateRandomEmail() {
        Faker faker = new Faker(new Locale("en-gb"));
        return faker.internet().emailAddress();
    }

    public static String generateRandomNumber() {
        Faker faker = new Faker(new Locale("ru-ru"));
        return faker.phoneNumber().phoneNumber();
    }

    public static String generateRandomGender() {
        return FAKER.options().option("Male", "Female", "Other");
    }

    public static String generateRandomDayAsString() {
        int randomDay = FAKER.number().numberBetween(1, 31);
        return String.valueOf(randomDay);
    }
    public static String generateRandomAdress(int length) {
        return FAKER.lorem().fixedString(length);  // Генерация случайной строки фиксированной длины
    }

    public static String generateRandomSubject() {
        return FAKER.options().option("Arts", "English", "Hindi");
    }
    public static String generateRandomHobbies() {
        return FAKER.options().option("Sports", "Reading", "Music");
    }
}
