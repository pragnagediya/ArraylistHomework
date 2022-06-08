package org.example;

import org.openqa.selenium.By;
import org.testng.Assert;

import static org.example.BasePage.driver;
import static org.example.Utils.clickOnElement;
import static org.example.Utils.typeText;

public class EmailAFriendPage extends Utils {
    private By _email = By.id("FriendEmail");
    private By _message = By.id("PersonalMessage");
    private By _emailButton = By.xpath("//button[@class='button-1 send-email-a-friend-button']");

    public void userEnterEmailDetails() {

        //enter email//
        typeText(_email, "pgiya@gmail.com");
        //enter message//
        typeText(_message, "This is good computer");
        //click send email button//
        clickOnElement(_emailButton);
        //assert  result verification //
        String ExpectedMessage = "Your message has been sent.";
        String ActualMessage = driver.findElement(By.className("result")).getText();
        Assert.assertEquals(ActualMessage, ExpectedMessage, "Message has not been sent successfully");
    }
}
