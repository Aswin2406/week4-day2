package week4.day1class_section;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Frameshandling {
	
	  public static void main(String[] args) throws InterruptedException {
		
		  WebDriverManager.chromedriver().setup();
		  ChromeDriver driver = new ChromeDriver();
		  driver.manage().window().maximize();
		  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		  driver.get("https://chercher.tech/practice/frames-example-selenium-webdriver");
		  
		  WebElement frame = driver.findElement(By.id("frame1"));
		  driver.switchTo().frame(frame);
		  driver.findElement(By.xpath( "//input[@type='text']")).sendKeys("testleaf");
		  WebElement frame1 = driver.findElement(By.id("frame3"));
		  driver.switchTo().frame(frame1);
		 
		  driver.findElement(By.id("a")).click();
		  driver.switchTo().defaultContent();
		  Thread.sleep(3000);
		  
		  WebElement frame3 = driver.findElement(By.xpath( "//iframe[@id='frame2']"));
		  driver.switchTo().frame(frame3);
		  WebElement drop = driver.findElement(By.id("animals"));
          Select dropdown = new Select(drop);
          dropdown.selectByVisibleText("Avatar");
		  
		  
	}

}
