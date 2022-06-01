package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import static org.example.BasePage.driver;
import static org.example.Utils.*;

public class BuildYourOwnComputerPage extends Utils{
    private By _addToCartButton = By.id("add-to-cart-button-1");
    private By _clickOnEmailAFriendButton = By.xpath("//button[@class='button-2 email-a-friend-button']");
    private By _selectProcessor = By.id("product_attribute_1");
    private By _selectRam = By.id("product_attribute_2");
    private By _selectHDD = By.id("product_attribute_3_6");
    private By _selectOS = By.id("product_attribute_4_9");
    private By _selectSoftware1 = By.id("product_attribute_5_11");
    private By _selectSoftware2 = By.id("product_attribute_5_12");

    public void userAbleToBuildYourComputerToPutInCart() {

        //click Add to cart button to put product in cart
        clickOnElement(_addToCartButton);
    }
    public void clickOnEmailAFriendButton(){
        //click email a friend button//
         clickOnElement(_clickOnEmailAFriendButton);

    }
public void selectOptionAccordinglyRequirement(){ //select processor
    Select Processor = new Select(driver.findElement(_selectProcessor));
    Processor.selectByValue("1");
    //select ram
    Select Ram = new Select(driver.findElement(_selectRam));
    Ram.selectByValue("3");
    //select HDD//
    driverWaitForElementTobeClickable(_selectHDD,10);
    //select OS//
    clickOnElement(By.id("product_attribute_4_9"));
    //select software//

    clickOnElement(_selectSoftware1);
    clickOnElement(_selectSoftware2);

}}

