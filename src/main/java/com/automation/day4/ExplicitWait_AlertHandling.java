package com.automation.day4;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ExplicitWait_AlertHandling {
    public static void main(String[] args) {
        System.setProperty("Webdriver.chrome.driver","C:\\Selenium\\JavaSeleniumMaven_Aug25\\JavaSeleniumMaven_Aug25\\src\\test\\resources\\webdriver\\chromedriver\\chromedriver.exe");

        //dynamic dispatching - runtime polymorphism
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.get("https://mail.rediff.com/cgi-bin/login.cgi");

        driver.findElement(By.xpath("//button[@class='signin-btn']")).click();

        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(60));
        Alert alert =wait.until(ExpectedConditions.alertIsPresent());
        String alert1 = alert.getText();
        System.out.println(alert1);
        if(alert1.equals("Please enter a valid user name"))
            System.out.println("Test passed for user name check.");
        alert.accept();

        //check password alert
        driver.findElement(By.xpath("//input[@id='login1']")).sendKeys("TESTID123456");
        driver.findElement(By.xpath("//button[@class='signin-btn']")).click();


        alert= wait.until(ExpectedConditions.alertIsPresent());
        String alert2 = alert.getText();
        if (alert2.equals("Please enter your password"))
            System.out.println("Test passed for password check");
        System.out.println(alert2);
        alert.accept();

        driver.quit();
    }

}
