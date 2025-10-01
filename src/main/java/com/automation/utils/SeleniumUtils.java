package com.automation.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.time.Duration;

public class SeleniumUtils {

    static WebDriver driver;

    public static WebDriver launchApp(String appUrl){
        System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\JavaSelenium_Aug25\\src\\test\\resources\\webdriver\\chromedriver-win64\\chromedriver.exe");
        //dynamic dispatching - runtime polymorphism
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.get(appUrl);
        return driver;
    }


    public static WebDriver launchApp(String appUrl, String browserType){
        if(browserType.equals("chrome")){
            System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\JavaSeleniumMaven_Aug25\\JavaSeleniumMaven_Aug25\\src\\test\\resources\\webdriver\\chromedriver\\chromedriver.exe");
            //dynamic dispatching - runtime polymorphism
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
            driver.get(appUrl);
        }else if(browserType.equals("edge")){
            System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\JavaSelenium_Aug25\\src\\test\\resources\\webdriver\\edgedriver-win64\\edgedriver.exe");
            //dynamic dispatching - runtime polymorphism
            driver = new EdgeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
            driver.get(appUrl);
        }

        return driver;
    }


}
