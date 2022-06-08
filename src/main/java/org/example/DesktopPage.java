package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.example.Utils.clickOnElement;

public class DesktopPage extends Utils {
    private By _desktopButton = By.linkText("Desktops");
    private By _clickOnBuildYourOwnComputer = By.linkText("Build your own computer");

    public void userShouldBeSelectDesireProduct() {

        //click desktop
        clickOnElement(_desktopButton);
        //click build your own computer
        clickOnElement(_clickOnBuildYourOwnComputer);

    }

    public void clickOnDesktop() {
        //click desktop
        clickOnElement(_desktopButton);

    }

    public void clickOnSortByZToAOption() {
        //Under sort by functionality, select "Name Z-A" option
        clickOnElement(By.xpath("//select[@id=\"products-orderby\"]/option[3]"));
    }

    public void verifyProductListedInZToAFormat() {
        //Verify that all the products are listed in Z-A format (Assert Point)
        ArrayList<String> beforeList = new ArrayList<String>();
        List<WebElement> elementList = driver.findElements(By.xpath("//div[contains(@class,'product-grid')]//div[@class='item-box']//h2"));
        for (WebElement we : elementList) {
            beforeList.add(we.getText().substring(0, 1));
        }
        Collections.sort(beforeList, Collections.reverseOrder());
        System.out.println(beforeList);

        List<String> afterList = new ArrayList<String>();
        for (WebElement we : elementList) {
            afterList.add(we.getText().substring(0, 1));
        }
        System.out.println(afterList);
        Assert.assertTrue(afterList.equals(beforeList));

    }
}
