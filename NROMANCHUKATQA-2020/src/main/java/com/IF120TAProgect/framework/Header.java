package com.IF120TAProgect.framework;

import org.openqa.selenium.remote.RemoteWebDriver;


public class Header {

    protected RemoteWebDriver driver;
    private String profileDropDownMenuButtonLocator = "//div[@class='Header-item position-relative mr-0 d-none d-md-flex']";
    private String signOutButtonLocator="//*[contains(text(),'Sign out')]";
    public Header(RemoteWebDriver driver){
        this.driver=driver;
    }

    public void clickOnProfileMenu(){
        driver.findElementByXPath(profileDropDownMenuButtonLocator).click();
    }
    public void clickOnExit() {
        driver.findElementByXPath(signOutButtonLocator).click();
    }



//    public Header setSearchTerm(String searchTerm) {
//        driver.findElement(By.xpath(searchFieldLocator)).sendKeys(searchTerm);
//        return this;
//    }
//
//    public <T extends Page> T clickOnSearchButton(Class<T> clazz) throws Exception {
//        driver.findElement(By.xpath(searchButtonLocator)).click();
//        return PageFactory.newPage(driver, clazz);
//    }

}
