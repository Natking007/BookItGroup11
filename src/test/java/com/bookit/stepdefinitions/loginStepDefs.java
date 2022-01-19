package com.bookit.stepdefinitions;

import com.bookit.pages.BasePage;
import com.bookit.pages.LoginPage;
import com.bookit.utilities.ConfigurationReader;
import com.bookit.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;

public class loginStepDefs {

    LoginPage loginPage = new LoginPage();

    @Given("the user is on the login page")
    public void the_user_is_on_the_login_page() {
        loginPage.openLoginPage();
    }
    @When("User logins with valid username")
    public void user_logins_with_valid_username() {
       loginPage.loginViaConfig();
    }
    @Then("the {string} title page should be displayed")
    public void the_title_page_should_be_displayed(String expectedTitle) {
        String ActualTitle = loginPage.getTitle();
        Assert.assertEquals("Title Mismatch",expectedTitle,ActualTitle);
    }
}
