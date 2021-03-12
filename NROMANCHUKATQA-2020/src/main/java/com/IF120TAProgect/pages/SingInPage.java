package com.IF120TAProgect.pages;

import com.IF120TAProgect.framework.PageFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SingInPage extends Page {
    public SingInPage(RemoteWebDriver driver) {
        super(driver);
    }

    private UserPage userPage;
    private String userNameFieldLocator = "//input[@id=\'login_field\']";
    private String userName = "***************************************";
    private String userPasswordFieldLocator = "//input[@id='password']";
    private String passwodr = "***************************************";
    private String signInButtonLocator = "//input[@value='Sign in']";

    public UserPage navigateToUserPage() throws Exception {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(userNameFieldLocator)));
        driver.findElementByXPath(userNameFieldLocator).sendKeys(userName);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(userPasswordFieldLocator)));
        driver.findElementByXPath(userPasswordFieldLocator).sendKeys(passwodr);
        driver.findElementByXPath(signInButtonLocator).click();
        return PageFactory.newPage(driver, UserPage.class);
    }
}
