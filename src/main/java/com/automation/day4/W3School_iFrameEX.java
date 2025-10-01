package com.automation.day4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class W3School_iFrameEX {
    public static void main(String[] args) {
        System.setProperty("Webdriver.chrome.driver","C:\\Selenium\\JavaSeleniumMaven_Aug25\\JavaSeleniumMaven_Aug25\\src\\test\\resources\\webdriver\\chromedriver\\chromedriver.exe");

        //dynamic dispatching - runtime polymorphism
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.get("https://www.w3schools.com/html/tryit.asp?filename=tryhtml_iframe_height_width");


        //move to outer frame
        WebElement outerFrame = driver.findElement(By.xpath("//iframe[@id='iframeResult']"));
        driver.switchTo().frame(outerFrame);
        String outerFrameText = driver.findElement(By.xpath("/html/body/p")).getText();
        System.out.println("Outer Frame Txt ->"+outerFrameText);


        //move to inner frame
        WebElement innerFrame = driver.findElement(By.xpath("//iframe[@title='Iframe Example']"));
        driver.switchTo().frame(innerFrame);
        //print inner frame text
        String innerFrameText = driver.findElement(By.xpath("/html/body/h1")).getText();
        System.out.println("Inner Frame Txt ->"+innerFrameText);


        driver.quit();


    }
}
