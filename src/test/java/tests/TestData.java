package tests;

import com.github.javafaker.Faker;
import utils.RandomUtils;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class TestData {

    private static final Faker faker = new Faker();
    public static String
            randomEmail = RandomUtils.generateRandomEmail(),
            randomFirstName = RandomUtils.generateRandomFirstName(),
            randomLastName = RandomUtils.generateRandomLastName(),
            randomNumber = RandomUtils.getRandomNumber(),
            randomGender = RandomUtils.generateRandomGender(),
            randomDay = RandomUtils.generateRandomDayAsString(),
randomSubjects = RandomUtils.generateRandomSubject(),
    randomHobbie = RandomUtils.generateRandomHobbies(),
    randomAdress = RandomUtils.generateRandomAdress(10),
            randomState = RandomUtils.getRandomState(),
      randomCity = RandomUtils.getRandomCity(randomState);

    private static final List<String> months = List.of(
            "January", "February", "March", "April", "May", "June",
            "July", "August", "September", "October", "November", "December");

    public static String getRandomMonth() {
        return months.get(faker.random().nextInt(months.size()));
    }
    public static int getRandomDay() {
        return ThreadLocalRandom.current().nextInt(1, 32);
    }
    public static int getRandomYear() {
        return ThreadLocalRandom.current().nextInt(1980, 2024);
    }
}
