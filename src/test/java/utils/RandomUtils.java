package utils;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class RandomUtils {
    private static final Faker FAKER = new Faker(new Locale("en-gb"));

    private static final String[] imageFiles = {"test.png", "test1.png"};
    public static int getRandomInt(int min, int max) {
        return FAKER.number().numberBetween(min, max);
    }



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

    public static String getRandomNumber() {
        return String.format("+%s (%s) %s - %s - %s",
                String.valueOf(getRandomInt(1, 9)),
                String.valueOf(getRandomInt(111, 999)),
                String.valueOf(getRandomInt(111, 999)),
                String.valueOf(getRandomInt(11, 99)),
                String.valueOf(getRandomInt(11, 99))
        );
    }


    public static String generateRandomGender() {
        return FAKER.options().option("Male", "Female", "Other");
    }

    public static String generateRandomDayAsString() {
        int randomDay = FAKER.number().numberBetween(1, 31);
        return String.valueOf(randomDay);
    }

    public static String generateRandomMonth() {
        String[] months = {"January", "February", "March", "April", "May", "June",
                "July", "August", "September", "October", "November", "December"};
        return months[FAKER.number().numberBetween(0, months.length)];
    }

    public static int generateRandomYear(int startYear, int endYear) {
        return FAKER.number().numberBetween(startYear, endYear);
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
    public static final Faker faker = new Faker();

    private static final Map<String, List<String>> options = new HashMap<>() {{
        put("NCR", Arrays.asList("Delhi", "Gurgaon", "Noida"));
        put("Rajasthan", Arrays.asList("Jaipur", "Jaiselmer"));
        put("Haryana", Arrays.asList("Karnal", "Panipat"));
        put("Uttar Pradesh", Arrays.asList("Lucknow", "Merrut", "Agra"));
    }};
    public static String getRandomState() {
        List<String> leftOptions = new ArrayList<>(options.keySet());
        return leftOptions.get(faker.random().nextInt(leftOptions.size()));
    }

    public static String getRandomCity(String state) {
        List<String> cities = options.get(state);
        return cities.get(faker.random().nextInt(cities.size()));
    }
    public static Path getRandomImagePath() {
        Random random = new Random();
        String randomImage = imageFiles[random.nextInt(imageFiles.length)];
        return Paths.get("src/test/resources/images/" + randomImage);
    }

}
