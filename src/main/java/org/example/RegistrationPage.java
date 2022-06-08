package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class RegistrationPage extends Utils {
    LoadProp loadProp = new LoadProp();
    private By _genderButton = By.xpath("//input[@id=\"gender-male\"]");
    private By _firstName = By.xpath("//input[@name='FirstName']");
    private By _lastName = By.id("LastName");
    private By _birthdate = By.name("DateOfBirthDay");
    private By _month = By.name("DateOfBirthMonth");
    private By _year = By.name("DateOfBirthYear");
    private By _email = By.id("Email");
    private By _password = By.id("Password");
    private By _confirmPassword = By.id("ConfirmPassword");
    private By _registerButton = By.name("register-button");

    public void verifyUserIsOnRegistrationPage() {
        // verify user is on correct registration page

        String actualRegistrationUrl = driver.getCurrentUrl();
        Assert.assertTrue(actualRegistrationUrl.contains("register"), "your register url does not contain register word");
    }

    public void userEnterRegistrationDetails() {
        //select male or female
        clickOnElement(_genderButton);

        //enter first name
        //driver.findElement(By.className("ico-register")).click();
        typeText(_firstName, loadProp.getProperty("firstname"));

        //enter lastname
        //driver.findElement(By.xpath("//input[@name='FirstName']")).sendKeys("Automation");
        typeText(_lastName, loadProp.getProperty("lastname"));
        //driver.findElement(By.id("LastName")).sendKeys("patel");


        //select date of birthday
        Select birthDay = new Select(driver.findElement(_birthdate));
        birthDay.selectByVisibleText("10");

        //select month
        Select birthMonth = new Select(driver.findElement(_month));
        birthMonth.selectByValue("5");

        //select year
        Select birthYear = new Select(driver.findElement(_year));
        birthYear.selectByVisibleText("1990");

        //email
        typeText(_email, "pragnagediya" + randomDate() + "@gmail.com");
        //driver.findElement(By.id("Email")).sendKeys("pragnagediyad@gmail.com");
        //password
        typeText(_password, "Sit@1117");
        //driver.findElement(By.id("Password")).sendKeys ( "Sit@1117");
        //confirm password
        typeText(_confirmPassword, "Sit@1117");
        //driver.findElement(By.id("ConfirmPassword")).sendKeys( "Sit@1117");
        //click register
        //clickOnElement register button
        driverWaitForElementTobeClickable(_registerButton, 10);


    }
}


