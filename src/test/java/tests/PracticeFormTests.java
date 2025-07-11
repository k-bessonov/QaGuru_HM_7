package tests;

import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

import static data.TestData.*;

public class PracticeFormTests extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();


    @Test
    void successfulRegistrationTest() {

        registrationPage.openPage()
                .removeBanner()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(userEmail)
                .setGender(gender)
                .setUserNumber(mobilePhone)
                .setDateOfBirth(date, month, year)
                .setSubjects(subjects)
                .setHobbies(hobbies)
                .setPicture(picture)
                .setCurrentAddress(streetAddress)
                .setState(state)
                .setCity(city)
                .submitPracticeForm();

        registrationPage.verifyResultsAppears()
                .checkResult("Student Name", firstName + " " + lastName)
                .checkResult("Student Email", userEmail)
                .checkResult("Gender", gender)
                .checkResult("Mobile", mobilePhone)
                .checkResult("Date of Birth", date + " " + month + "," + year)
                .checkResult("Subjects", subjects)
                .checkResult("Hobbies", hobbies)
                .checkResult("Picture", picture)
                .checkResult("Address", streetAddress)
                .checkResult("State and City", state + " " + city);

    }

    @Test
    void successMinFormTest() {

        registrationPage.openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setGender(gender)
                .setUserNumber(mobilePhone)
                .submitPracticeForm();

        registrationPage.verifyResultsAppears()
                .checkResult("Student Name", firstName + " " + lastName)
                .checkResult("Gender", gender)
                .checkResult("Mobile", mobilePhone);
    }

    @Test
    void negativeMinFormTest() {

        registrationPage.openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setGender(gender)
                .setUserNumber("")
                .submitPracticeForm();

        registrationPage.verifyNegativeResultsAppears();
    }


}
