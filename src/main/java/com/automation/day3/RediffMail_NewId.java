package com.automation.day3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class RediffMail_NewId {
    public static void main(String[] args) throws InterruptedException {
        rediffRegisterUser();
    }
public static WebDriver rediffRegisterUser() throws InterruptedException {
    System.setProperty("Webdriver.chrome.driver","C:\\Selenium\\JavaSeleniumMaven_Aug25\\JavaSeleniumMaven_Aug25\\src\\test\\resources\\webdriver\\chromedriver\\chromedriver.exe");
    WebDriver driver = new ChromeDriver();
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    driver.get("https://mail.rediff.com/cgi-bin/login.cgi");
    System.out.println("everything works ...");
    driver.findElement(By.xpath("//a[text()='Get a new Rediffmail ID']")).click();

    driver.findElement(By.xpath("//input[starts-with(@name,'name')]")).sendKeys("Nidhi");
    driver.findElement(By.xpath("//input[starts-with(@name,'login')]")).sendKeys("dhalnidhi12");
    driver.findElement(By.xpath("//input[starts-with(@name,'passwd')]")).sendKeys("nidhi135");
    driver.findElement(By.xpath("//input[starts-with(@name,'confirm_passwd')]")).sendKeys("nidhi135");

    //find drop-down
    WebElement day_dropdown = driver.findElement(By.xpath("//select[starts-with(@name,'DOB_Day')]"));
    WebElement month_dropdown=driver.findElement(By.xpath("//select[starts-with(@name,'DOB_Month')]"));
    WebElement year_dropdown=driver.findElement(By.xpath("//select[starts-with(@name,'DOB_Year')]"));

    //Select Day

    Select select_day = new Select(day_dropdown);
    select_day.getOptions().get(10).click();
    Thread.sleep(3000);
    select_day.selectByIndex(20);

    //Select Month

    Select select_month = new Select(month_dropdown);
    select_month.selectByVisibleText("FEB");
    Thread.sleep(2000);
    select_month.selectByValue("02");
    Thread.sleep(2000);
    System.out.println("print the month"+ select_month.getFirstSelectedOption().getText());

    //select year
    Select select_year = new Select(year_dropdown);
    select_year.selectByContainsVisibleText("1981");
    Thread.sleep(2000);
    select_year.getOptions().get(8).click();
    List<WebElement> all_year = select_year.getAllSelectedOptions();
    for (WebElement we : all_year) { System.out.println(we.getText()); }

    //radio buttons
    WebElement male_radio = driver.findElement(By.xpath("//input[@value='m' and @type='radio']"));
    WebElement female_radio = driver.findElement(By.xpath("//input[@value='f' and @type='radio']"));

    if(male_radio.isSelected())
        female_radio.click();

    Thread.sleep(2000);

    if(female_radio.isSelected())
        male_radio.click();

    //country select
    Select select_country = new Select(driver.findElement(By.xpath("//select[@id='country']")));

    //check if India is selected or not
    if(select_country.getFirstSelectedOption().getText().equals("India"))
        System.out.println("Country -India selected. Assertion passed.");
    else{
        System.out.println("Country -India not selected. Assertion failed."+select_country.getFirstSelectedOption().getText());
        select_country.selectByVisibleText("India");
    }


    //city select
    Select select_city = new Select(driver.findElement(By.xpath("//select[starts-with(@name,'city')]")));
    select_city.selectByValue("Pune");

    //alternate email and check box
    WebElement alternate_email_checkbox = driver.findElement(By.xpath("//input[starts-with(@name,'chk_altemail')]"));

    if(alternate_email_checkbox.isSelected())
        System.out.println("Assertion is failed.");
    else
        driver.findElement(By.xpath("//input[starts-with(@name,'altemail')]")).sendKeys("nidhi123@gmail.com");


    //mobile no
    driver.findElement(By.xpath("//input[starts-with(@name,'mob')]")).sendKeys("4665476402");

    //captcha
    driver.findElement(By.xpath("//input[@class='captcha']")).sendKeys("TEST");

    //click on register
    System.out.println();
    WebElement register_btn = driver.findElement(By.xpath("//input[@id='Register']"));
    System.out.println(register_btn.isDisplayed());
    if (register_btn.isEnabled())
        register_btn.click();

    //VALIDATE - Captcha code doesn't match the image code

    return driver;
}
}

