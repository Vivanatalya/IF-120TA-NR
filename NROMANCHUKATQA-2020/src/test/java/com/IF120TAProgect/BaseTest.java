package com.IF120TAProgect;

import com.IF120TAProgect.listeners.TestListener;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;

import java.util.Properties;

@Listeners(TestListener.class)
public abstract class BaseTest {

    protected RemoteWebDriver driver = null;
    protected WebDriverWait wait;
    //private static final String DEFAULT_ENV_PROPERTIES_FILE_PATH = "src/test/resources/test.properties";
    private static final String DEFAULT_ENV_REMOTE_PROPERTIES_FILE_PATH = "src/test/resources/remote.properties";
    private static Properties properties;

    static {
        properties = new Properties();
        // loadPropertiesFromFile(DEFAULT_ENV_PROPERTIES_FILE_PATH);
    }

    @BeforeMethod(alwaysRun = true)
    public void setup() {

        System.setProperty("webdriver.chrome.driver", "drivers//chromedriver.exe");
        driver = new ChromeDriver();
        this.wait = new WebDriverWait(driver, 10);
        driver.manage().window().maximize();
        driver.get("https://github.com/");
        //driver.get(getMainUrl());
    }

    protected String getProperty(String key) {
        String result = properties.getProperty(key);
        return (result != null) ? result.trim() : null;
    }

    protected String getMainUrl() {
        String result;
        if (getProperty("test.isLocal").equals("true")) {
            result = properties.getProperty("test.mainUrl");
        } else {
            result = properties.getProperty("test.qaUrl");
        }
        return (result != null) ? result.trim() : null;
    }

    protected boolean isElementDisplayed(By selector) {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(selector));
            return driver.findElement(selector).isDisplayed();
        } catch (Exception ex) {
            return false;
        }
    }
}
