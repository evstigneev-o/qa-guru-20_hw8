package demoqa.utils;

import com.github.javafaker.Faker;

public class RandomGenerator {
    static Faker faker = new Faker();

    public static String getRandomGender() {
        String[] genders = {"Male", "Female", "Other"};
        return faker.options().option(genders);
    }

    public static String getRandomMonth() {
        String[] month = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
        return faker.options().option(month);
    }

    public static String getRandomSubject() {
        String[] subjects = {"Math", "English", "Chemistry", "Civics", "Computer Science", "Arts", "Physics", "Economics"};
        return faker.options().option(subjects);
    }

    public static String getRandomHobbies() {
        String[] hobby = {"Sports", "Reading", "Music"};
        return faker.options().option(hobby);
    }

    public static String getRandomState() {
        String[] state = {"NCR", "Uttar Pradesh", "Haryana", "Rajasthan"};
        return faker.options().option(state);
    }

    public static String getRandomCity(String state) {
        String[] NCRCities = {"Delhi", "Gurgaon", "Noida"};
        String[] UttarPradeshCities = {"Agra", "Lucknow", "Merrut"};
        String[] HaryanaCities = {"Karnal", "Panipat"};
        String[] RajasthanCities = {"Jaipur", "Jaiselmer"};
//        return switch (state) {
//            case "NCR" -> faker.options().option(NCRCities);
//            case "Uttar Pradesh" ->  faker.options().option(UttarPradeshCities);
//            case "Haryana" ->  faker.options().option(HaryanaCities);
//            case "Rajasthan" -> faker.options().option(RajasthanCities);
//            default -> throw new IllegalStateException("Unexpected value: " + state);
//        };
        switch (state){
            case "NCR":
                return faker.options().option(NCRCities);
            case "Uttar Pradesh":
                return faker.options().option(UttarPradeshCities);
            case "Haryana":
                return faker.options().option(HaryanaCities);
            case "Rajasthan":
                return faker.options().option(RajasthanCities);
            default:
                throw new IllegalStateException("Unexpected value: " + state);
        }
    }

}
