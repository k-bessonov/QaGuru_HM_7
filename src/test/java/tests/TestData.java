package tests;

import com.github.javafaker.Faker;

import java.util.Locale;

public class TestData {

    public static Faker faker = new Faker(new Locale("en-GB"));

    static String firstName = faker.name().firstName(),
            lastName = faker.name().lastName(),
            userEmail = faker.internet().emailAddress(),
            streetAddress = faker.address().streetAddress(),
            mobilePhone = faker.numerify("##########");

    private static final String[] genders = {"Male", "Female", "Other"};
    static String gender = faker.options().option(genders);

    //int day = faker.number().numberBetween(1, 31);
    //String month = faker.date().month();
    //int year = faker.number().numberBetween(1900, 2025);


}
