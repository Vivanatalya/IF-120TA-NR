package com.IF120TAProgect.pages;

import com.IF120TAProgect.framework.PageFactory;
import org.openqa.selenium.remote.RemoteWebDriver;

public class NewRepositoryPage extends Page{

    private String addReadmeButtonLocator="//a[contains(text(),'Add a README')]";
    private String settingsButtonLocator="//span[contains(text(),'Settings')]";

    public NewRepositoryPage(RemoteWebDriver driver) {
        super(driver);
    }

    public ReadmeFilePage createReadme() throws Exception {
        driver.findElementByXPath(addReadmeButtonLocator).click();
        return PageFactory.newPage(driver,ReadmeFilePage.class);
    }

    public SettingsPage navigateToSettingsPage() throws Exception {
        driver.findElementByXPath(settingsButtonLocator).click();
        return PageFactory.newPage(driver,SettingsPage.class);
    }
}


