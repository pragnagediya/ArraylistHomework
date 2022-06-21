package org.example;

import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.Iterator;
import java.util.List;
import java.util.Set;


public class HomePage extends Utils {
    private By _registrationButton = By.className("ico-register");
    private By _computerButton = By.linkText("Computers");
    private By _shoppingCartButton = By.xpath("//span[@class='cart-label']");
    private By _currencyButton = By.xpath("//select[@id=\"customerCurrency\"]");
    private By _usButton = By.xpath("//span[contains(text(),'$1,200.00')]");
    private By _euroButton = By.xpath("//select[@name=\"customerCurrency\"]");
    private By _radioButtonOfGoodOption = By.id("pollanswers-2");
    private By _clickOnVoteButton = By.id("vote-poll-1");
    private By _getProductTitles = By.xpath("//div[contains(@class,'product-grid')]//div[@class='item-box']//h2");


    public void clickOnRegisterButton() {
        // click on register button
        clickOnElement(_registrationButton);
    }

    public void selectDesktopOptionFromComputer() {
        //click on computer
        clickOnElement(_computerButton);
    }

    public void shoppingCart() {
        //click shopping cart//
        clickOnElement(_shoppingCartButton);
    }

    //click On Currency Button//
    public void clickOnCurrencyButton() {
        clickOnElement(_currencyButton);
    }

    //check Price On Display Accordingly Selected Currency
    public void checkPriceOnDisplayAccordinglySelectedCurrency() {
        //select USDollar
        Select USDollar = new Select(driver.findElement(By.xpath("//select[@name=\"customerCurrency\"]")));
        USDollar.selectByIndex(0);
        clickOnElement(_usButton);

        String expectedMessage = "$1,200.00";
        String actualMessage = driver.findElement(By.xpath("//span[contains(text(),'$1,200.00')]")).getText();
        System.out.println("Actual message:" + actualMessage);
        Assert.assertEquals(actualMessage, expectedMessage, "price doesnt match");

        Select euro = new Select(driver.findElement(By.xpath("//select[@name=\"customerCurrency\"]")));
        euro.selectByIndex(1);
        clickOnElement(_euroButton);

        String expectedMessage1 = "€1032.00";
        String actualMessage1 = driver.findElement(By.xpath("//span[contains(text(),'€1032.00')]")).getText();
        System.out.println("Actual Message:" + actualMessage1);
        Assert.assertEquals(actualMessage1, expectedMessage1, "Price does not match");
    }

    public void verifyWithoutRegisterUserAbleToVote() {
        //click on radio button of good option//
        clickOnElement(_radioButtonOfGoodOption);
        //click on vote button//
        clickOnElement(_clickOnVoteButton);
        // String expectedMessage ="Only registered user can vote";
        //String actualMessage = getTextFromElement(By.id("block-poll-vote-error-1"));
        //Assert.assertEquals(actualMessage,expectedMessage);
    }

    public void verifyRegisteredUserIsAbleToVote() {
        //click on radio button of good option//
        clickOnElement(_radioButtonOfGoodOption);
        //click on vote button//
        clickOnElement(_clickOnVoteButton);
    }

    public void getProductTitles() {
        List<WebElement> productTitles = driver.findElements
                (_getProductTitles);
        for (WebElement e : productTitles) {
            System.out.println(e.getText());
        }
    }

    public void clickOnFacebookButton() {
        String MainWindow = driver.getWindowHandle();
        //click on facebook button//
        clickOnElement(By.className("facebook"));
        //To handle all new opened window.
        Set<String> s1 = driver.getWindowHandles();
        Iterator<String> i1 = s1.iterator();

        while (i1.hasNext()) {
            String ChildWindow = i1.next();
            if (!MainWindow.equalsIgnoreCase(ChildWindow)) {
                //Switching to child window
                driver.switchTo().window(ChildWindow);
                // verify user is on correct Facebook page
                String expectedFacebookUrl = "https://www.facebook.com/nopCommerce";
                String actualFacebookUrl = driver.getCurrentUrl();
                Assert.assertEquals(actualFacebookUrl, expectedFacebookUrl);
                driver.close();
                ;
            }
            //Switching to Parent window
            driver.switchTo().window(MainWindow);
            // verify user is on correct homepage
            String expectedHomeUrl = "https://demo.nopcommerce.com/";
            String actualHomeUrl = driver.getCurrentUrl();
            Assert.assertEquals(actualHomeUrl, expectedHomeUrl);
        }
    }

    public void clickOnVoteButton() {
        //click on vote button//
        clickOnElement(_clickOnVoteButton);
        //switch to Alert//
        Alert alert = driver.switchTo().alert();
        //get text for Alert//
        String alertMessage = driver.switchTo().alert().getText();
        String actualMessageForVote = "Please select an answer";
        Assert.assertEquals(actualMessageForVote, alertMessage);
        //Accept alert//
        driver.switchTo().alert().accept();
    }

    public void enterWordInSearchTextBox(String product) {
        // enter text in searchTextBox//
        typeText(By.id("small-searchterms"), product);
        //click on search
        clickOnElement(By.className("search-box-button"));
        //verify url//
        String expectedsearchUrl = "https://demo.nopcommerce.com/search?q=" + product;
        String actualsearchUrl = driver.getCurrentUrl();
        Assert.assertEquals(actualsearchUrl, expectedsearchUrl);

        //check all products
        List<WebElement> productTitles = driver.findElements
                (By.xpath("//div[contains(@class,'product-grid')]//div[@class='item-box']//h2"));
        for (WebElement e : productTitles) {
            System.out.println(e.getText());
        }
    }

    public void clickOnComputer() {
        //click on computer
        clickOnElement(_computerButton);
    }

    public void ClickOnDetailsButton() {
        //On Home Page click under News and nopCommerce new release!, click on Details Button
        clickOnElement(By.xpath("/html/body/div[6]/div[3]/div/div/div/div/div[5]/div[2]/div[2]/div[3]/a"));

    }
    public void clickOnCategoryLink(String categoryName){
        clickOnElement(By.linkText(categoryName));
    }

}

