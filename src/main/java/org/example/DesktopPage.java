package org.example;

import org.openqa.selenium.By;

import static org.example.Utils.clickOnElement;

public class DesktopPage extends Utils{
    private By _desktopButton = By.linkText("Desktops");
    private By _clickOnBuildYourOwnComputer = By.linkText("Build your own computer");
    public void userShouldBeSelectDesireProduct(){

        //click desktop
        clickOnElement(_desktopButton);
        //click build your own computer
        clickOnElement(_clickOnBuildYourOwnComputer);

}}
