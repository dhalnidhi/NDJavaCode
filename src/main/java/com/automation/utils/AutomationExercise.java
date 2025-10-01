package com.automation.utils;


import org.openqa.selenium.By;

import static com.automation.utils.SeleniumUtils.launchApp;

public class AutomationExercise extends BaseAutomationExercise {

    public static void loginToAutomationExercise(){
        driver =launchApp("https://automationexercise.com/login", "chrome");
        driver.findElement(By.name("email")).sendKeys("dhalnidhi12@gmail.com");
        driver.findElement(By.name("password")).sendKeys("Luck2025");
        driver.findElement(By.xpath("//button[@type='submit' and text()='Login']")).click();
    }


    public static void addToCartFirstProduct(){

            //go to cart and get the existing no of items added in cart
            driver.findElement(By.xpath("//*[@id='header']/div/div/div/div[2]/div/ul/li[3]/a")).click();
            existingNoOfItemsInCart = Integer.parseInt(driver.findElement(By.xpath("//td[@class='cart_quantity']/button")).getText());
            driver.findElement(By.xpath("//*[@id='header']/div/div/div/div[2]/div/ul/li[1]/a")).click();

            driver.findElement(By.xpath("//div[@class='features_items']/child::div[2]//a[text()='View Product']")).click();
            driver.findElement(By.xpath("//button[@class='btn btn-default cart']")).click();
            driver.findElement(By.xpath("//*[@id='cartModal']/div/div/div[2]/p[2]/a/u")).click();
            driver.findElement(By.xpath("//a[text()='Proceed To Checkout']")).click();
        }

    public static Boolean checkProductAddedSuccessfullyToCart(){
        int productQuantityAfterAddingAnewItemInCart= Integer.parseInt(driver.findElement(By.xpath("//td[@class='cart_quantity']/button")).getText());
        return productQuantityAfterAddingAnewItemInCart > existingNoOfItemsInCart;
    }


    public static void logout(){
        driver.findElement(By.xpath("//a[text()=' Logout']")).click();

    }
    public static void closeApp(){
        driver.quit();
    }

//    public static void main(String[] args) {
//        loginToAutomationExercise(driver);
//    }



}
