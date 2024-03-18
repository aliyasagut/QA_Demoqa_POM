package com.demoqa.tests;

import com.demoqa.pages.HomePage;
import com.demoqa.pages.PracticeFormPage;
import com.demoqa.pages.SidePanel;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PracticeFormTests extends TestBase {

    @BeforeMethod
    public void precondition() {
        new HomePage(driver)
//                .confirmCookie()
                .getForms();
        new SidePanel(driver).selectPracticeForm();
    }

    @Test
    public void createStudentAccountPositiveTest() {
        new PracticeFormPage(driver).hideIframes();
        new PracticeFormPage(driver).enterPersonalData("Jack", "Sparrow", "jack@jack.com", "1234567890")
                .selectGender("Male")
                .typeOfDate("16 August 1987")
                .addSubjects(new String[]{"Maths", "Chemistry", "English"})
                .selectHobby(new String[]{"Sport", "Music"})
                .uploadFile("C:/QA/logo.jpg")
                .selectState("NCR")
                .selectCity("Delhi")
                .submit()
                .verifyStudentFormTitle("Thanks for submitting the form");
    }
}
