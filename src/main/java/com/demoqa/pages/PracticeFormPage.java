package com.demoqa.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PracticeFormPage extends BasePage {

    public PracticeFormPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "firstName")
    WebElement firstName;

    @FindBy(id = "lastName")
    WebElement lastName;

    @FindBy(id = "userEmail")
    WebElement userEmail;

    @FindBy(id = "userNumber")
    WebElement userNumber;


    public PracticeFormPage enterPersonalData(String name, String surname, String email, String phone) {
        type(firstName, name);
        type(lastName, surname);
        type(userEmail, email);
        type(userNumber, phone);
        return this;
    }

    @FindBy(css = "[for='gender-radio-1']")
    WebElement male;

    @FindBy(css = "[for='gender-radio-2']")
    WebElement female;

    @FindBy(css = "[for='gender-radio-3']")
    WebElement other;

    public PracticeFormPage selectGender(String gender) {
        if (gender.equals("Male")) {
            click(male);
        } else if (gender.equals("Female")) {
            click(female);
        } else {
            click(other);
        }
        return this;
    }

    @FindBy(id = "dateOfBirthInput")
    WebElement dateOfBirthInput;

    public PracticeFormPage typeOfDate(String date) {
        click(dateOfBirthInput);

        String os = System.getProperty("os.name");

        if (os.startsWith("Mac")) {
            dateOfBirthInput.sendKeys(Keys.COMMAND, "a");
        } else {
            dateOfBirthInput.sendKeys(Keys.CONTROL, "a");
        }
        dateOfBirthInput.sendKeys(date);
        dateOfBirthInput.sendKeys(Keys.ENTER);
        return this;
    }

    @FindBy(id = "subjectsInput")
    WebElement subjectsInput;

    public PracticeFormPage addSubjects(String[] subjects) {
        for (int i = 0; i < subjects.length; i++) {
            if (subjects[i] != null) {
                type(subjectsInput, subjects[i]);
                subjectsInput.sendKeys(Keys.ENTER);
            }
        }
        return this;
    }

    @FindBy(css = "[for='hobbies-checkbox-1']")
    WebElement sports;

    @FindBy(css = "[for='hobbies-checkbox-2']")
    WebElement reading;

    @FindBy(css = "[for='hobbies-checkbox-3']")
    WebElement music;

    public PracticeFormPage selectHobby(String[] hobby) {
        for (int i = 0; i < hobby.length; i++) {
            if(hobby[i].equals("Sports")) {
                clickWithJS(sports, 0, 200);
            } if (hobby[i].equals("Reading")) {
                clickWithJS(reading, 0, 200);
            } if (hobby[i].equals("Music")) {
                clickWithJS(sports, 0, 200);
            }
        }
        return this;
    }

    @FindBy(id = "uploadPicture")
    WebElement chooseFileButton;

    public PracticeFormPage uploadFile(String path) {
        chooseFileButton.sendKeys(path);
        return this;
    }
}
