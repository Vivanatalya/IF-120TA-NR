package com.IF120TAProgect.pages;

import com.IF120TAProgect.framework.PageFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SettingsPage extends Page {


   // private String deleteButtonLocator = "//*[@id='options_bucket']/div[10]/ul/li[4]/details/summary";
    private String deleteButtonLocator = "//div[@class='Box Box--danger']/ul[1]/li[4]//summary[contains(text(),'Delete this repository')]";
    private String deleteField = "//div[@class='Box-body overflow-auto']/form/p/input[@class='form-control input-block']";
    private String repoSourceText = "****************/TestRepository";

    public SettingsPage(RemoteWebDriver driver) {
        super(driver);
    }

    public SettingsPage clickOnDeleteButton() {
       wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//summary[contains(text(),'Delete this repository')]")));
        driver.findElementByXPath(deleteButtonLocator).click();
        return this;
    }

    public UserPage fillInFormForDelete() throws Exception {
        driver.findElementByXPath(deleteField).sendKeys(repoSourceText);
        driver.findElement(By.xpath("//span[contains(text(),'I understand the consequences, delete this repository')]")).click();
        return PageFactory.newPage(driver,UserPage.class);
    }


}

