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

    WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);

    @FindBy(xpath = "//input[@placeholder='email']")
    public WebElement usernameInput;

    @FindBy(xpath = " //input[@placeholder='email']")
    public WebElement passwordInput;

    @FindBy(css = "button[type='submit']")
    public WebElement loginButton;


    public void loginViaUserEntry(String username, String password){
        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        loginButton.click();
    }

    public void loginViaConfig(){
        usernameInput.sendKeys(ConfigurationReader.getProperty("group.username"));
        passwordInput.sendKeys(ConfigurationReader.getProperty("group.password"));
        loginButton.click();
    }

    /**
     * TODO :Duplicate code. Improve this. Add ConfigurationReader to read URL
     * @return
     */
    public LoginPage openLoginPage() {

        String url = ConfigurationReader.getProperty("base.url");
        this.driver.get(url);
        BrowserUtils.waitForVisibility(usernameInput,5);
        return this;
    }



}
