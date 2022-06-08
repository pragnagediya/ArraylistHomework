package org.example;

import org.testng.annotations.Test;

public class TestSuit extends BaseTest {
    HomePage homepage = new HomePage();
    RegistrationPage registrationPage = new RegistrationPage();
    RegistrationSuccessPage registrationSuccessPage = new RegistrationSuccessPage();
    BuildYourOwnComputerPage buildYourOwnComputerPage = new BuildYourOwnComputerPage();
    DesktopPage desktopPage = new DesktopPage();
    EmailAFriendPage emailAFriendPage = new EmailAFriendPage();
    ShoppingCartPage shoppingCartPage = new ShoppingCartPage();
    NopCommerceNewRelease nopCommerceNewRelease = new NopCommerceNewRelease();


    @Test
    public void userShouldBeAbleToRegisterSuccessFully() {
        //click on Register button
        homepage.clickOnRegisterButton();
        //enter registration details
        registrationPage.userEnterRegistrationDetails();
        //verify register
        registrationSuccessPage.verifyUserRegisterSuccessfully();
    }

    @Test
    public void userShouldBeAbleToSelectProductAndPutAddToCart() {
        //SelectDesktopOptionFromComputer
        homepage.selectDesktopOptionFromComputer();
        //navigate to desired product page
        desktopPage.userShouldBeSelectDesireProduct();
        //selectOptionAccordinglyRequirement
        buildYourOwnComputerPage.selectOptionAccordinglyRequirement();
        //click AddToCartButton//
        buildYourOwnComputerPage.userAbleToBuildYourComputerToPutInCart();
        //click on shopping cart button
        homepage.shoppingCart();
        //check shoppingCart url//
        shoppingCartPage.verifyUrlOfShoppingCart();
        //check ShoppingCart title//
        shoppingCartPage.ShoppingCartTitle();
        //check Build your own computer product available in cart//
        shoppingCartPage.CheckCart();
    }

    @Test
    public void RegisterUserShouldBeAbleToSendEmailToFriendForReferProduct() {
        //  userShouldBeAbleToRegisterPage
        homepage.clickOnRegisterButton();
        registrationPage.userEnterRegistrationDetails();
        registrationSuccessPage.verifyUserRegisterSuccessfully();
        //click on continue button
        registrationSuccessPage.clickOnContinueButton();
        //SelectDesktopOptionFromCompute
        homepage.selectDesktopOptionFromComputer();
        //navigate to desired product page
        desktopPage.userShouldBeSelectDesireProduct();
        //click on add to cart button
        buildYourOwnComputerPage.userAbleToBuildYourComputerToPutInCart();
        //click on email a friend button
        buildYourOwnComputerPage.clickOnEmailAFriendButton();
        //Enter detail of friend email
        emailAFriendPage.userEnterEmailDetails();
    }

    @Test
    public void userShouldBeAbleToSeePriceAccordingByTheirSelectedCurrency() {
        //click On Currency Button//
        // homepage.clickOnCurrencyButton();
        //check Price On Display Accordingly Selected Currency
        homepage.checkPriceOnDisplayAccordinglySelectedCurrency();
    }

    @Test
    public void registerUserShouldBeAbleToVote() {
        //Verify that user is not able to vote without being registered
        homepage.verifyWithoutRegisterUserAbleToVote();
        //user need to be register
        //click on register button
        homepage.clickOnRegisterButton();
        //enter registration details
        registrationPage.userEnterRegistrationDetails();
        //verify register
        registrationSuccessPage.verifyUserRegisterSuccessfully();
        //click on continue button
        registrationSuccessPage.clickOnContinueButton();
        //verify registered user is able to vote
        homepage.verifyRegisteredUserIsAbleToVote();
    }



    @Test
    public void userShouldBeAbleToSeeAPopUpAlertPleaseSelectAnAnswer() {
        homepage.clickOnVoteButton();
    }

    @Test
    public void userShouldBeNavigateSuccessfullyAfterClickingFacebookLinkFromHomePage() {
        homepage.clickOnFacebookButton();

    }

    @Test
    public void userShouldAbleToSearchProductByWord() {
        homepage.enterWordInSearchTextBox("nike");

    }

    @Test
    public void userAbleToSeeProductAccordingSelectedOption() {
        homepage.clickOnComputer();
        desktopPage.clickOnDesktop();
        desktopPage.clickOnSortByZToAOption();
        desktopPage.verifyProductListedInZToAFormat();


    }

    @Test
    public void verifyThatUserCommentHasSuccessfullyBeenAddedToCommentsList() {
        //on Home Page click under News and nopCommerce new release!, click on Details button
        homepage.ClickOnDetailsButton();

        nopCommerceNewRelease.checkURLOfThePage();


        nopCommerceNewRelease.checkTitleOfThePage();

        nopCommerceNewRelease.enterTitle();


        nopCommerceNewRelease.enterComment();

        nopCommerceNewRelease.clickOnCommentButton();


        nopCommerceNewRelease.verifyMessageAfterClickingCommentButton();

        nopCommerceNewRelease.verifyCommentHasBeenAddedToTheCommentList();

    }


}