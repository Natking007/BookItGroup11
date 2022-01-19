package com.bookit.pages;


import com.bookit.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


/**
 * this class is parent class for all page object classes
 */
public abstract class BasePage {

    public BasePage (){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    public String getTitle() {;
        return Driver.getDriver().getTitle();
    }

}
