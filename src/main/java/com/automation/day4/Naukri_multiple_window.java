package com.automation.day4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

public class Naukri_multiple_window {
    public static void main(String[] args) {
        System.setProperty("Webdriver.chrome.driver","C:\\Selenium\\JavaSeleniumMaven_Aug25\\JavaSeleniumMaven_Aug25\\src\\test\\resources\\webdriver\\chromedriver\\chromedriver.exe");

        //dynamic dispatching - runtime polymorphism
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.get("https://www.naukri.com/");

        Actions actions = new Actions(driver);
        WebElement servicesMenu = driver.findElement(By.xpath("//a[@title='Naukri FastForward- Resume Services']/div"));
        actions.moveToElement(servicesMenu).build().perform();

        //click on resume display link which will open another tab
        driver.findElement(By.xpath("//a[@title='Resume display']/div")).click();

        //get all the window handles or IDs
        Set<String> allWinIds = driver.getWindowHandles();
//        for (String id :allWinIds)
//            System.out.println(id);

        Iterator<String> itr = allWinIds.iterator();
        String mainWinId = itr.next();
        System.out.println("Main window id- " +mainWinId);
        String tabWinId1 = itr.next();
        System.out.println("Tab window id- " +tabWinId1);

        //swith to tab window
        driver.switchTo().window(tabWinId1);

        //click on 1 month radio button and click on Buy now
        driver.findElement(By.xpath("//div[@class='label' and text()='1 Month']")).click();
        driver.findElement(By.xpath("//div[@class='buyNowBtn']")).click();

        //print my cart in next page
        String myCartLabel = driver.findElement(By.xpath("//div[@class='cartTabTitle']")).getText();
        if(myCartLabel.equals("My Cart"))
            System.out.println("Test passed..");
        else
            System.out.println("Test failed ..");

        System.out.println(myCartLabel);


        //return to main window
        driver.switchTo().window(mainWinId);

        actions.moveToElement(servicesMenu).build().perform();
        driver.findElement(By.xpath("//a[@title='Basic & premium plans']/div")).click(); //it will open another window

        allWinIds = driver.getWindowHandles();
        itr = allWinIds.iterator();
        System.out.println("No of windows ->"+allWinIds.size());
        mainWinId = itr.next();
        System.out.println("Main window id- " +mainWinId);
        tabWinId1 = itr.next();
        System.out.println("Tab window id1- " +tabWinId1);
        String tabWinId2 = itr.next();
        System.out.println("Tab window id2- " +tabWinId2);


        //switch to second tab window
        driver.switchTo().window(tabWinId2);

        //click on buy now button
        driver.findElement(By.xpath("//button[@id='addToCartBtn']")).click();

        //test the text
        String expectedText = driver.findElement(By.xpath("//span[text()='Premium Monthly Plan']")).getText();

        if(expectedText.equals("Premium Monthly Plan"))
            System.out.println("Test is passed.");
        else System.out.println("Test is failed.");




        driver.close();


        driver.quit();









    }
}
