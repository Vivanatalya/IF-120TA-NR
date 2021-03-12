package com.IF120TAProgect.pages;

import com.IF120TAProgect.framework.Header;
import com.IF120TAProgect.framework.PageFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;

public class UserPage extends Page {
    private Header header;

    public UserPage(RemoteWebDriver driver) {
        super(driver);
        this.header = header;

    }

    public CreateNewRepositoryPage navigateToCreateNewRepoPage() throws Exception {
        driver.findElement(By.linkText("New")).click();
        return PageFactory.newPage(driver, CreateNewRepositoryPage.class);
    }

    public UserPage clickOnProfileMenu() {
        header.clickOnProfileMenu();
        return this;
    }

    public StartPage logout() throws Exception {
        header.clickOnExit();
        return PageFactory.newPage(driver, StartPage.class);
    }
}
