package com.automation.basics;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class RediffAlert {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\JavaSeleniumMaven_Aug25\\JavaSeleniumMaven_Aug25\\src\\test\\resources\\webdriver\\chromedriver\\chromedriver.exe");

        //dynamic dispatching - runtime plymorphism
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.get("https://www.rediff.com/");

      //  driver.findElement(By.xpath("//a[@id='continue-link']")).click();
       //print title
        String title= driver.getTitle();
        System.out.println("Print Title :->"+ title);
        //print url
        String currentUrl = driver.getCurrentUrl();
        System.out.println("Print CurrentUrl :-->"+ currentUrl);

        driver.findElement(By.xpath("//a[@class='signin']")).click();

        driver.findElement(By.id("login1")).sendKeys("Test Auto");
//        driver.findElement(By.name("passwd")).sendKeys("Testpass");
        driver.findElement(By.xpath("//button[@class='signin-btn']")).click();

        //switch to alert box
        Alert alertBox = driver.switchTo().alert();

        String alertText = alertBox.getText();
        System.out.println("Text on ALert Box - >"+alertText);
        alertBox.accept();

        Thread.sleep(5000);
        driver.close();





    }
}
