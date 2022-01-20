package com.bookit.pages;

import com.bookit.utilities.BrowserUtils;
import com.bookit.utilities.ConfigurationReader;
import com.bookit.utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasePage{
    private final WebDriver driver;

    /**
     * Constructor to call driver
     */
    public LoginPage() {
        this.driver = Driver.getDriver();
    }

    /**
     * Instantiated wait method, incase if we need it in page object
     */
    WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);

    @FindBy(xpath = "//input[@placeholder='email']")
    public WebElement usernameInput;

    @FindBy(xpath = " //input[@placeholder='email']")
    public WebElement passwordInput;

    @FindBy(css = "button[type='submit']")
    public WebElement loginButton;


    /**
     * Login with provided parameters
     * When called the method, you have to provide:
     * @param : @Username & @Email
     */
    public void loginViaUserEntry(String username, String password){
        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        loginButton.click();
    }

    /**
     * Login with password from config file
     */
    public void loginViaConfig(){
        usernameInput.sendKeys(ConfigurationReader.getProperty("group.username"));
        passwordInput.sendKeys(ConfigurationReader.getProperty("group.password"));
        loginButton.click();
    }

    /**
     * Go to Login page
     * Wait for UserNameInput to be visible
     * Return the Login Page itself, so that we can use fluid syntax
     */
    public LoginPage openLoginPage() {

        String url = ConfigurationReader.getProperty("base.url");
        this.driver.get(url);
        BrowserUtils.waitForVisibility(usernameInput,5);
        return this;
    }



}
