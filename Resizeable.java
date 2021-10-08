package week4.day1class_section;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Resizeable {
	public static void main(String[] args) {
		
		  WebDriverManager.chromedriver().setup();
		  ChromeDriver driver = new ChromeDriver();
		  driver.manage().window().maximize();
		  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		  driver.get("https://jqueryui.com/resizable/");
		  
		  WebElement resize = driver.findElement(By.xpath( "//div[@class='demo-list']//following::iframe"));
		  driver.switchTo().frame(resize);
		  WebElement pointer = driver.findElement(By.xpath( "//div[@class='ui-resizable-handle ui-resizable-se ui-icon ui-icon-gripsmall-diagonal-se']"));
	      Actions builder = new Actions(driver);
	      builder.clickAndHold(pointer).perform();
	      builder.dragAndDropBy(pointer, -78, -61).perform();
	      
	
	
	}

}
