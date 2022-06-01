package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;


public class HomePage extends Utils{
     private By _registrationButton = By.className("ico-register");
    private By _computerButton = By.linkText("Computers");
    private By _shoppingCartButton = By.xpath("//span[@class='cart-label']");
    private By _currencyButton = By.xpath("//select[@id=\"customerCurrency\"]");
    private By _usButton = By .xpath("//span[contains(text(),'$1,200.00')]");
    private By _euroButton = By.xpath("//select[@name=\"customerCurrency\"]");
    private By _radioButtonOfGoodOption = By.id("pollanswers-2");
    private By _clickOnVoteButton = By.id("vote-poll-1");
    public void clickOnRegisterButton(){
    // click on register button
    clickOnElement(_registrationButton);}
public void selectDesktopOptionFromComputer(){
    //click on computer
    clickOnElement(_computerButton);}
public void shoppingCart(){
    //click shopping cart//
    clickOnElement(_shoppingCartButton);
    }
    //click On Currency Button//
    public void clickOnCurrencyButton()
    {clickOnElement(_currencyButton);}
   //check Price On Display Accordingly Selected Currency
    public void checkPriceOnDisplayAccordinglySelectedCurrency(){
        //select USDollar
        Select USDollar = new Select(driver.findElement(By.xpath("//select[@name=\"customerCurrency\"]")));
        USDollar.selectByIndex(0);
        clickOnElement(_usButton);

        String expectedMessage  = "$1,200.00";
        String actualMessage = driver.findElement(By.xpath("//span[contains(text(),'$1,200.00')]")).getText();
        System.out.println("Actual message:" +actualMessage);
        Assert.assertEquals(actualMessage,expectedMessage,"price doesnt match");

        Select euro = new Select(driver.findElement(By.xpath("//select[@name=\"customerCurrency\"]")));
        euro.selectByIndex(1);
        clickOnElement(_euroButton);

        String expectedMessage1 = "€1032.00";
        String actualMessage1 = driver.findElement(By.xpath("//span[contains(text(),'€1032.00')]")).getText();
        System.out.println("Actual Message:"+actualMessage1);
        Assert.assertEquals(actualMessage1,expectedMessage1,"Price does not match");
    }
    public void verifyWithoutRegisterUserAbleToVote(){
        //click on radio button of good option//
        clickOnElement(_radioButtonOfGoodOption);
        //click on vote button//
        clickOnElement(_clickOnVoteButton);
       // String expectedMessage ="Only registered user can vote";
        //String actualMessage = getTextFromElement(By.id("block-poll-vote-error-1"));
        //Assert.assertEquals(actualMessage,expectedMessage);
    }
    public void verifyRegisteredUserIsAbleToVote(){
        //click on radio button of good option//
        clickOnElement(_radioButtonOfGoodOption);
        //click on vote button//
        clickOnElement(_clickOnVoteButton);

    }

}

