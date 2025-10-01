package day5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class Jquery_Slider {

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\JavaSelenium_Aug25\\src\\test\\resources\\webdriver\\chromedriver-win64\\chromedriver.exe");

        //dynamic dispatching - runtime polymorphism
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.get("https://jqueryui.com/slider/");

        driver.findElement(By.xpath("//a[text()='Slider']")).click();

        WebElement sliderFrame = driver.findElement(By.xpath("//iframe[@class='demo-frame']"));
        driver.switchTo().frame(sliderFrame);

        WebElement slider = driver.findElement(By.xpath("//div[@id='slider']"));

        Actions actions = new Actions(driver);
        //actions.moveToElement(slider, 50 , 0).build().perform();
        actions.dragAndDropBy(slider , 50 , 0).build().perform();
        System.out.println("END");


    }
}

