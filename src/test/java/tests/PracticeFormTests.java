package tests;

import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

import static tests.TestData.*;

public class PracticeFormTests extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();


    @Test
    void successfulRegistrationTest() {

        registrationPage.openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(userEmail)
                .setGender(gender)
                .setUserNumber(mobilePhone)
                .setDateOfBirth("30", "March", "2000")


                .setSubjects("Maths")
                .setSubjects("Physics")
                .setSubjects("Computer Science")
                .setHobbies("Sports")
                .setPicture("picture.png")
                .setCurrentAddress(streetAddress)
                .setStateAndCity("NCR", "Delhi")
                .submitPracticeForm();

        registrationPage.verifyResultsAppears()
                .checkResult("Student Name", firstName + " " + lastName)
                .checkResult("Student Email", userEmail)
                .checkResult("Gender", gender)
                .checkResult("Mobile", mobilePhone)
                .checkResult("Date of Birth", "30 March,2000")
                .checkResult("Subjects", "Maths, Physics, Computer Science")
                .checkResult("Hobbies", "Sports")
                .checkResult("Picture", "picture.png")
                .checkResult("Address", streetAddress)
                .checkResult("State and City", "NCR Delhi");

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
                .setFirstName("Имя")
                .setLastName("Фамилия")
                .setGender("Male")
                .setUserNumber("")
                .submitPracticeForm();

        registrationPage.verifyNegativeResultsAppears();
    }


}