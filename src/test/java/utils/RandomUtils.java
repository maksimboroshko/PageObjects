package utils;
import com.github.javafaker.Faker;
import java.util.Locale;
public class RandomUtils {

    Faker faker = new Faker(new Locale("en-gb"));

    public String generateRandomFirstName() {
        return faker.name().firstName();
    }

    public String generateRandomLastName() {
        return faker.name().lastName();
    }

    public String generateRandomEmail() {
        return faker.internet().emailAddress();
    }

    public String getRandomNumber() {
        return faker.phoneNumber().subscriberNumber(10);
    }

    public String generateRandomGender() {
        return faker.options().option("Male", "Female", "Other");
    }

    public String generateRandomPicture() {
        String picturePath = faker.options().option("images/test.png", "images/test1.png");
        return picturePath.split("/")[1];
    }

    public String generateRandomDay() {
        return String.valueOf(faker.number().numberBetween(1, 28));
    }

    public String generateRandomMonth() {
        return faker.options().option("January", "February", "March", "April", "May", "June",
                "July", "August", "September", "October", "November", "December");
    }

    public String generateRandomYear() {
        return String.valueOf(faker.number().numberBetween(1990, 2024));

    }

    public String generateRandomAdress() {
        return faker.address().streetAddress();
    }

    public String generateRandomSubject() {
        return faker.options().option("Arts", "English", "Hindi");
    }

    public String generateRandomHobbies() {
        return faker.options().option("Sports", "Reading", "Music");
    }

    public String generateRandomState() {
        return faker.options().option("NCR", "Rajasthan", "Haryana", "Uttar Pradesh");
    }

    public String generateRandomCity(String state) {
        switch (state) {
            case "NCR":
                return faker.options().option("Delhi", "Gurgaon", "Noida");
            case "Uttar Pradesh":
                return faker.options().option("Lucknow", "Merrut", "Agra");
            case "Haryana":
                return faker.options().option("Panipat", "Karnal");
            case "Rajasthan":
                return faker.options().option("Jaipur", "Jaiselmer");
            default:
                return "";
        }
    }
}
