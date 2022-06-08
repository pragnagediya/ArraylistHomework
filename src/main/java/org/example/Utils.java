package org.example;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

public class Utils extends BasePage {
    //Take a screenshot methods
    public static void takeSnapShop(String a) {
        //Convert web driver object to Take screenshot
        TakesScreenshot scrShot = ((TakesScreenshot) driver);
        //Call getScreenshotAs method to create image file
        File srcFile = scrShot.getScreenshotAs(OutputType.FILE);
        //Copy file at destination
        try {
            FileUtils.copyFile(srcFile, new File("Screenshot\\" + a + randomDate() + "png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //user defined method for send keys
    public static void typeText(By by, String text) {
        driver.findElement(by).sendKeys(text);
    }

    //user defined method for click element
    public static void clickOnElement(By by) {
        driver.findElement(by).click();
    }

    //user defined method for getTextElement
    public static String getTextFromElement(By by) {
        return driver.findElement(by).getText();
    }

    //get randomDate method
    public static String randomDate() {
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("ddMMyyyyHHmmss");
        return formatter.format(date);
    }

    //web driver WebDriverWait methods//
    public static void driverWaitForElementTobeClickable(By by, int time) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
        wait.until(ExpectedConditions.elementToBeClickable(by)).click();
    }


    //user defined method for driverWaitElementToBESelected//
    public static void driverWaitElementToBESelected(int time, By by) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
        wait.until(ExpectedConditions.elementToBeSelected(by));
    }

    //user defined method for driverWaitUrlContains//
    public static void driverWaitUrlContains(int time, By by, String urlName) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
        wait.until(ExpectedConditions.urlContains(urlName));
    }

    //user defined method for driverWaitAttributeContains//
    public static void driverWaitAttributeContains(int time, String Attribute, String value, By by) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
        wait.until(ExpectedConditions.attributeContains(by, Attribute, value));
    }

    //user defined method for driverWaitAttributeToBeNotEmpty//
    public static void driverWaitAttributeToBeNotEmpty(int time, WebElement element, String text) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
        wait.until(ExpectedConditions.attributeToBeNotEmpty(element, text));
    }

    //user defined method for driverWaitTextToBe//
    public static void driverWaitTextToBe(By by, String value, int time) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
        wait.until(ExpectedConditions.textToBe(by, value));
    }

    //user defined method for driverWaitAlertsPresent//
    public static void driverWaitAlertsPresent(int time) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
        wait.until(ExpectedConditions.alertIsPresent());
    }

    //user defined method for driverWaitInvisibilityOfWebElement//
    public static void driverWaitInvisibilityOfWebElement(int time, WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
        wait.until(ExpectedConditions.invisibilityOfAllElements(element));
    }

    //user defined method for driverWaitPresenceOfWebElement//
    public static void driverWaitPresenceOfWebElement(int time, By by) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
        wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }

    //user defined method for driverWaitTitleContains//
    public static void driverWaitTitleContains(int time, String name) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
        wait.until(ExpectedConditions.titleContains(name));
    }

    //user defined method for driverWaitUrlContains//
    public static void driverWaitUrlContains(int time, String fraction) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
        wait.until(ExpectedConditions.urlContains(fraction));
    }


}
