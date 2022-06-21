package org.example;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

import static org.example.BasePage.driver;

public class StepDefs
{ HomePage homePage = new HomePage();
    RegistrationPage registrationPage = new RegistrationPage();
    RegistrationSuccessPage registrationSuccessPage = new RegistrationSuccessPage();

    @Given("I am on registration page")
public void i_am_on_registration_page() {
        homePage.clickOnRegisterButton();

    // Write code here that turns the phrase above into concrete actions
    //throw new io.cucumber.java.PendingException();
}
    @When("I enter required registration details")
    public void i_enter_required_registration_details() {
        registrationPage.userEnterRegistrationDetails();
        // Write code here that turns the phrase above into concrete actions
       // throw new io.cucumber.java.PendingException();
    }
    @When("I click on register submit button")
    public void i_click_on_register_submit_button() {
        // Write code here that turns the phrase above into concrete actions
        //throw new io.cucumber.java.PendingException();
    }
    @Then("I should able to registered successfully")
    public void i_should_able_to_registered_successfully() {
        registrationSuccessPage.verifyUserRegisterSuccessfully();
        // Write code here that turns the phrase above into concrete actions
        //throw new io.cucumber.java.PendingException();
    }
    @Then("I should be logged in")
    public void i_should_be_logged_in() {
        // Write code here that turns the phrase above into concrete actions
        //throw new io.cucumber.java.PendingException();
    }
    @Given("I am on homepage")
    public void i_am_on_homepage() {
        // Write code here that turns the phrase above into concrete actions
        //throw new io.cucumber.java.PendingException();
    }
     @When("I click on {string} link from top menu header")
public void i_click_on_link_from_top_menu_header(String category_name) {
    // Write code here that turns the phrase above into concrete actions
    //throw new io.cucumber.java.PendingException();
    homePage.clickOnCategoryLink(category_name);
}
    @Then("I should be able to successfully navigate to related {string} with same category name")
    public void i_should_be_able_to_successfully_navigate_to_related_with_same_category_name(String category_url) {
        // Write code here that turns the phrase above into concrete actions
        Utils.verifyCurrentURL(category_url);

    }}
