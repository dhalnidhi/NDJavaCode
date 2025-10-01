package com.automation.day4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static com.automation.day3.RediffMail_NewId.rediffRegisterUser;

public class ExplicitWait {
    public static void main(String[] args) throws InterruptedException {
        WebDriver myDriver = rediffRegisterUser();

        //implement explicit wait
        WebDriverWait webDriverWait = new WebDriverWait(myDriver, Duration.ofSeconds(60));

        //condition , element
        WebElement registerBtn = myDriver.findElement(By.xpath("//input[@id='Register']"));

        System.out.println("START");
        webDriverWait.until(ExpectedConditions.elementToBeClickable(registerBtn)).click();
        System.out.println("END");







    }


}
