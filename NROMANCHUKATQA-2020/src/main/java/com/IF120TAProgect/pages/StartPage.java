package com.IF120TAProgect.pages;

import com.IF120TAProgect.framework.PageFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class StartPage extends Page {

    private String singInButtonLocator = "//a[@href='/login']";

    public StartPage(RemoteWebDriver driver) {
        super(driver);
    }

    public SingInPage navigateToSingInPage() throws Exception {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(singInButtonLocator)));
        driver.findElementByXPath(singInButtonLocator).click();
        return PageFactory.newPage(driver,SingInPage.class);
    }

}
