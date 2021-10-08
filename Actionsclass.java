package week4.day1class_section;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Actionsclass {
	public static void main(String[] args) {
		
		 WebDriverManager.chromedriver().setup();
		 ChromeDriver driver = new ChromeDriver();
		 driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		 driver.get("https://jqueryui.com/draggable/");
		 
		 
		 WebElement dragit = driver.findElement(By.xpath( "//div[@class='demo-list']//following::iframe"));
		 driver.switchTo().frame(dragit);
		 WebElement findElement = driver.findElement(By.id("draggable"));
		 Actions buldier = new Actions(driver);
		 buldier.dragAndDropBy(findElement, 100, 50).perform();
		 
		 
	}

}
