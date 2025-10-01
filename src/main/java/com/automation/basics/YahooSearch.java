package com.automation.basics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class YahooSearch {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\JavaSeleniumMaven_Aug25\\JavaSeleniumMaven_Aug25\\src\\test\\resources\\webdriver\\chromedriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.get("https://duckduckgo.com/");

        WebElement searchTextBox = driver.findElement(By.xpath("//input[@name='q']"));
                searchTextBox.sendKeys("Selenium Automation");

                WebElement submitBtn = driver.findElement(By.xpath("//button[@type='submit']"));
                submitBtn.click();

                WebElement seleniumLink = driver.findElement(By.xpath("span[text()='Selenium']"));
                seleniumLink.click();
        System.out.println("Url of the page-->"+driver.getCurrentUrl());
        Thread.sleep(6000);
        driver.close();
    }

    }

