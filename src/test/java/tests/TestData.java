package tests;

import utils.RandomUtils;

public class TestData {
    public static String
            RandomEmail = RandomUtils.generateRandomEmail(),
            randomFirstName = RandomUtils.generateRandomFirstName(),
            randomLastName = RandomUtils.generateRandomLastName(),
            randomNumber = RandomUtils.generateRandomNumber(),

            randomGender = RandomUtils.generateRandomGender(),
            randomDay = RandomUtils.generateRandomDayAsString(),
randomSubjects = RandomUtils.generateRandomSubject(),
    randomHobbie = RandomUtils.generateRandomHobbies(),

                    randomAdress = RandomUtils.generateRandomAdress(10),

    letter = "English",
    hobbies = "Music",
    picture = "test.png",
    adress = "gde-to",
    city = "ncr",
    state = "noida",
            month = "February",
            year = "2000";
}
