package com.IF120TAProgect.pages;

import com.IF120TAProgect.framework.PageFactory;
import org.openqa.selenium.remote.RemoteWebDriver;

public class CreateNewRepositoryPage extends Page {
    public CreateNewRepositoryPage(RemoteWebDriver driver) {
        super(driver);
    }

    private String newRepoNameFieldLocator = "//input[@id='repository_name']";
    private String nameOfNewRepo = "TestRepository";
    private String addGitIgnoreChechBoxLocator="//input[@id='repository_gitignore_template_toggle']";
    private String gitignoreTemplateButtonLocator="//i[contains(text(),'gitignore')]";
    private String templateChooseFieldLocator="//input[@id='context-ignore-filter-field']";
    private String javaTemplKey="Java";
    private String javaTemplateField="//span[contains(text(),'Java')]";
    private String createNewRepoButton="//button[contains(text(),'Create repository')]";

    public CreateNewRepositoryPage setNameOfNewRepo() {
        driver.findElementByXPath(newRepoNameFieldLocator).sendKeys(nameOfNewRepo);
        return this;
    }

    public CreateNewRepositoryPage clickOnGitIgnoreCheckBoxButton(){
        driver.findElementByXPath(addGitIgnoreChechBoxLocator).click();
        return this;
    }

    public CreateNewRepositoryPage clickOnGitignoreTemplateButton(){
        driver.findElementByXPath(gitignoreTemplateButtonLocator).click();
        return this;
    }

    public CreateNewRepositoryPage chooseJavaTemplate(){
        driver.findElementByXPath(templateChooseFieldLocator).sendKeys(javaTemplKey);
        driver.findElementByXPath(javaTemplateField).click();
    return this;
    }

    public NewRepositoryPage clickOnCreateRepoButton() throws Exception {
        driver.findElementByXPath(createNewRepoButton).click();
        return PageFactory.newPage(driver,NewRepositoryPage.class);
    }

}
