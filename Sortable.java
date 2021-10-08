package week4.day1class_section;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Sortable {

	public static void main(String[] args) {
		
		 WebDriverManager.chromedriver().setup();
		 ChromeDriver driver = new ChromeDriver();
		 driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		 driver.get("https://jqueryui.com/sortable/");
		 
		 WebElement iframe = driver.findElement(By.xpath("//div[@class='demo-list']//following::iframe"));
		 driver.switchTo().frame(iframe);
		 WebElement item1 = driver.findElement(By.xpath( "(//ul[@id='sortable']//li)[1]"));
	     WebElement item2 = driver.findElement(By.xpath( "(//ul[@id='sortable']//li)[4]"));
	     Actions builder  = new Actions(driver);
	     builder.dragAndDropBy(item1, 0, 100).perform();

	}

}
