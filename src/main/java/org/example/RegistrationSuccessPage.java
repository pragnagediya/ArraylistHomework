package org.example;

import org.openqa.selenium.By;
import org.testng.Assert;

import static org.example.Utils.clickOnElement;
import static org.example.Utils.getTextFromElement;

public class RegistrationSuccessPage extends Utils{
    private By _clickOnContinueButton = By.xpath("//a[@class='button-1 register-continue-button']");
    public void verifyUserRegisterSuccessfully() {
        String expectedMessage = "Your registration completed";
//        String actualMessage = "Your registration completed";
        String actualMessage = getTextFromElement(By.xpath("//div[@class='result']"));
        Assert.assertEquals(actualMessage, expectedMessage, "Registration is not successful");
    }public void clickOnContinueButton(){
        //click on continue//
        clickOnElement(_clickOnContinueButton);
    }
}