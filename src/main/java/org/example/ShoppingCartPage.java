package org.example;

import org.openqa.selenium.By;
import org.testng.Assert;

import static org.example.BasePage.driver;
import static org.example.Utils.getTextFromElement;

public class ShoppingCartPage extends Utils{
    public void verifyUrlOfShoppingCart(){
        //check shoppingCart url//
        String actualUrl=driver.getCurrentUrl();
        Assert.assertTrue(actualUrl.contains("cart"),"your shopping cart url does not contain cart word");
        //check ShoppingCart title//
    }public void ShoppingCartTitle(){
        String expectedMessage = "Shopping cart";
        String actualMessage = getTextFromElement(By.className("page-title"));
        Assert.assertEquals(actualMessage,expectedMessage);

    }public void CheckCart(){
        //check Build your own computer product available in cart//
        String ExpectedMessage = "Build your own computer";
        String ActualMessage = getTextFromElement(By.className("product-name"));
        Assert.assertEquals(ActualMessage,ExpectedMessage);

    }
}
