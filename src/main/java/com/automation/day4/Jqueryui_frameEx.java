package com.automation.day4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Jqueryui_frameEx {

    public static void main(String[] args) {


        System.setProperty("Webdriver.chrome.driver","C:\\Selenium\\JavaSeleniumMaven_Aug25\\JavaSeleniumMaven_Aug25\\src\\test\\resources\\webdriver\\chromedriver\\chromedriver.exe");

        //dynamic dispatching - runtime polymorphism
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.get("https://jqueryui.com/");

        //click on draggale
        driver.findElement(By.xpath("//a[text()='Draggable']")).click();


        //move to frame
        WebElement draggableFrame = driver.findElement(By.xpath("//iframe[@class='demo-frame']"));
        driver.switchTo().frame(draggableFrame);

        //GET TEXT
        String draggableFrameText = driver.findElement(By.xpath("//div[@id='draggable']/p")).getText();
        System.out.println("draggableFrameText ->"+draggableFrameText);

        //get the control out of frame
        driver.switchTo().defaultContent();

        //click on Droppable link
        driver.findElement(By.xpath("//a[text()='Droppable']")).click();


        driver.quit();

    }
}
