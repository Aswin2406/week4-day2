package week4.day1class_section;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DragandDrop {

	public static void main(String[] args) {
             
		
		 WebDriverManager.chromedriver().setup();
		 ChromeDriver driver = new ChromeDriver();
		 driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		 driver.get("https://jqueryui.com/droppable/");
		 
		 
		 WebElement iframe = driver.findElement(By.xpath( "//div[@class='demo-list']/following::iframe"));
		 driver.switchTo().frame(iframe);
		 WebElement dragit = driver.findElement(By.id("draggable"));
		 WebElement droper = driver.findElement(By.id("droppable"));
		 Actions  builder = new Actions(driver);
		 builder.dragAndDrop(dragit, droper).perform();
		 
		 
	}

}
