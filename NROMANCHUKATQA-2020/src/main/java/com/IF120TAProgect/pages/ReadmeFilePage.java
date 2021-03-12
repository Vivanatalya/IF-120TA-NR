package com.IF120TAProgect.pages;

import com.IF120TAProgect.framework.PageFactory;
import org.openqa.selenium.remote.RemoteWebDriver;

public class ReadmeFilePage extends Page {

    private String readmeTextFieldLocator = "//pre[@class=' CodeMirror-line ']";
    private String readmeText = "My Test Repository";
    private String commitTextFieldLocator = "//input[@id='commit-summary-input']";
    private String commitText = "add README file";
    private String commitNewFileButtonLocator = "//button[@id='submit-file']";

    public ReadmeFilePage(RemoteWebDriver driver) {
        super(driver);
    }

    public ReadmeFilePage clearField() {
        driver.findElementByXPath(readmeTextFieldLocator).clear();
        return this;

    }

    public ReadmeFilePage addText() {
        driver.findElementByXPath(readmeTextFieldLocator).sendKeys(readmeText);
        return this;
    }

    public ReadmeFilePage addCommitMessage() {
        driver.findElementByXPath(commitTextFieldLocator).sendKeys(commitText);
        return this;
    }

    public NewRepositoryPage navigateToNewRepoPage() throws Exception {
        driver.findElementByXPath(commitNewFileButtonLocator).click();
        return PageFactory.newPage(driver, NewRepositoryPage.class);
    }
}
