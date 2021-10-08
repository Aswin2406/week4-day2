package week4.day1class_section;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Amazon {

	public static void main(String[] args) throws InterruptedException, IOException {
		
		 WebDriverManager.chromedriver().setup();
		 ChromeDriver driver = new ChromeDriver();
		 driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		 driver.get( "https://www.amazon.in/");
		 
		 driver.findElement(By.id("twotabsearchtextbox")).sendKeys("oneplus 9 pro ");
		 driver.findElement(By.xpath( "//input[@type='submit']")).click();
		 Thread.sleep(2000);
		 WebElement price = driver.findElement(By.xpath( "(//a[@class='a-size-base a-link-normal a-text-normal']//span)[5]"));
		 System.out.println("price of the oneplus 9 pro: "+ price.getText());
		 WebElement rating = driver.findElement(By.xpath( "(//div[@class='a-section a-spacing-none a-spacing-top-micro']//span)[4]"));
		 System.out.println("nuber of rating for one plus 9 pro :"+ rating.getText());
		
		 WebElement starrating = driver.findElement(By.xpath( "(//a[@class='a-popover-trigger a-declarative'])[1]"));
		 Actions builder = new Actions(driver);
	
		 builder.doubleClick(starrating).perform();
		 WebElement starrating5 = driver.findElement(By.xpath( "(//td[@class='a-text-right a-nowrap']//span//a)[1]"));
		 System.out.println(" no of percentage people vote 5 star rating:"+ starrating5.getText());
		 
		  driver.findElement(By.xpath( "(//span[@class='a-size-medium a-color-base a-text-normal'])[1]")).click();
		  Set<String> windows = driver.getWindowHandles();
		  List<String> srtlist= new ArrayList<String>(windows);
		  driver.switchTo().window(srtlist.get(1));
		 
		  WebElement oneplus8 = driver.findElement(By.id("imgTagWrapperId"));
		  File Src1 = oneplus8.getScreenshotAs(OutputType.FILE);
		 File dst = new File ("./snaps/button.png");
		 FileUtils.copyFile(Src1, dst);
		 
		 driver.findElement(By.id("add-to-cart-button")).click();
		 WebElement cart = driver.findElement(By.xpath("//span[@id='attach-accessory-cart-total-string']//b"));
		 System.out.println("no of items in cart:"+ cart.getText());
		 
		 
		 
		 

	}

}
