package com.IF120TAProgect.journeys;

import com.IF120TAProgect.BaseTest;
import com.IF120TAProgect.listeners.TestListener;
import com.IF120TAProgect.pages.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(TestListener.class)
public class FirstTestIF120TA extends BaseTest {

    private StartPage startPage;
    private SingInPage singInPage;
    private UserPage userPage;
    private CreateNewRepositoryPage createNewRepositoryPage;
    private NewRepositoryPage newRepositoryPage;
    private ReadmeFilePage readmeFilePage;
    private SettingsPage settingsPage;
    private String singInButtonLocator = "//a[@href='/login']";
    private String profileDropDownMenuButtonLocator = "//div[@class='Header-item position-relative mr-0 d-none d-md-flex']";
    private String signedInAsLocator = "//div[@class='header-nav-current-user css-truncate']/a";


    @BeforeMethod
    public void setupTest() {
        startPage = new StartPage(driver);
    }

    @Test
    public void loginOnGitHubTest1() throws Exception {
        //Given user opens a browser and provides a valid url (navigate to github.com).

        //When from the first page click on button “Sign in” on the header to navigate to authentication form.
        singInPage = startPage.navigateToSingInPage();

        //And fills in a fields with user name and password to navigate to user page;
        userPage = singInPage.navigateToUserPage();

        //And by clicking on "New" button navigated to "create a new repository" page
        createNewRepositoryPage = userPage.navigateToCreateNewRepoPage();
        createNewRepositoryPage.setNameOfNewRepo().clickOnGitIgnoreCheckBoxButton().clickOnGitignoreTemplateButton().chooseJavaTemplate();
        newRepositoryPage = createNewRepositoryPage.clickOnCreateRepoButton();

        //And adds text to readme file, and adds commit message
        readmeFilePage = newRepositoryPage.createReadme().clearField().addText().addCommitMessage();
        newRepositoryPage = readmeFilePage.navigateToNewRepoPage();

        //And delete repository from Settings page by clicking button "Delete this repository"
        settingsPage = newRepositoryPage.navigateToSettingsPage().clickOnDeleteButton();
        userPage = settingsPage.fillInFormForDelete();

        //Then logout from profile
        // TODO: 12.03.2021  something went wrong:NullPointerException. Don't know why :(
        userPage.clickOnProfileMenu();
        startPage = userPage.logout();
    }
}


