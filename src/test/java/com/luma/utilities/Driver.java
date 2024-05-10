package com.luma.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class Driver {
    private Driver(){}

    private static WebDriver driver; // value is null by default
    public static WebDriver getDriver(){

        if (driver == null){
            String browserType = ConfigurationReader.getProperty("browser");
            switch (browserType){
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    driver.manage().window().maximize();
                    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    driver.manage().window().maximize();
                    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
                    break;
            }

        }

        return driver;

    }
    public static void closeDriver(){
        if (driver != null){
            driver.quit();
        }
    }

}
