package week4.day1class_section;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class snapdeal {

	public static void main(String[] args) throws InterruptedException, IOException {
		  
		
		WebDriverManager.chromedriver().setup();
		  ChromeDriver driver =new ChromeDriver();
		  driver.manage().window().maximize();
		  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		  driver.get(" https://www.snapdeal.com/");
		  WebElement menfashion = driver.findElement(By.linkText("Men's Fashion"));
		  Actions builder = new Actions(driver);
		  builder.clickAndHold(menfashion).perform();
		  driver.findElement(By.xpath( "(//span[text()='Sports Shoes'])[1]")).click();
		  WebElement sizeofsportshoes = driver.findElement(By.xpath( "//h1[@class='category-name']"));
		  System.out.println(sizeofsportshoes.getText());
		  driver.findElement(By.xpath("//div[text()='Training Shoes']")).click();
		  driver.findElement(By.xpath("//span[text()='Sort by:']")).click();
		  driver.findElement(By.xpath("(//li[@class='search-li'])[1]")).click();
		  Thread.sleep(2000);
		  List<WebElement> sortlowtohigh = driver.findElements(By.xpath("//span[@class='lfloat product-price']"));
		  System.out.println("price started low to high:" + sortlowtohigh);
		  
		  List<String>  strlist = new ArrayList<String>();
		     for (WebElement sort : sortlowtohigh) {
		    	 String lprice = sort.getText();
		    	 strlist.add(lprice);
				}
		 	System.out.println("Price list from low to high: "+ strlist);		
		 	
		 	Thread.sleep(2000);
		 	builder.sendKeys(Keys.PAGE_DOWN).perform();
		  		WebElement low = driver.findElement(By.xpath( "(//input[@class='input-filter'])[1]"));
            	low.clear();
            	low.sendKeys("900");
            	WebElement high = driver.findElement(By.xpath( "(//input[@class='input-filter'])[2]"));
            	high.clear();
            	high.sendKeys("1200");
            	driver.findElement(By.xpath( "//div[@class='price-go-arrow btn btn-line btn-theme-secondary']")).click();
            	Thread.sleep(2000);
            	builder.sendKeys(Keys.PAGE_DOWN).perform();            	
            	driver.findElement(By.xpath("(//button[text()='View More '])[1]")).click();
            	driver.findElement(By.xpath("//label[@for='Color_s-Navy']")).click();
            	List<WebElement> snapFilter = driver.findElements(By.xpath("//div[@class='filters']/div/a"));
            	for (WebElement eachitem : snapFilter) {
        			String fil = eachitem.getText();
        			System.out.println("filters from snap"+fil);			
        		}
        		Thread.sleep(2000);
        		WebElement shoe = driver.findElement(By.xpath("//p[@class='product-title']"));
        		builder.moveToElement(shoe).perform();
        		
        		driver.findElement(By.xpath("//div[contains(@class,'center quick-view-bar')]")).click();
        		String text2 = driver.findElement(By.xpath("//span[@class='payBlkBig']")).getText();
        		System.out.println("Price of the shoe : " + text2);
        		String text3 = driver.findElement(By.xpath("//span[@class='percent-desc ']")).getText();
        		System.out.println("Discount Percentage of the shoe : " + text3);

        		File src = driver.getScreenshotAs(OutputType.FILE);
        		File dst = new File("./snapDeal/snapdeal.png");
        		FileUtils.copyFile(src, dst);
        		
        		driver.close();

            	
            	
            	
      
            	
            	
             }
	      }
	     
	
			

	


