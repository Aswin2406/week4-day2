package week4.day1class_section;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Nykka {

	public static void main(String[] args) throws InterruptedException {
               
		  WebDriverManager.chromedriver().setup();
		  ChromeDriver driver =new ChromeDriver();
		  driver.manage().window().maximize();
		  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		  driver.get("https://www.nykaa.com/");
		  
	  //  WebElement frame = driver.findElement(By.xpath( "//div[@id='black_layer']/parent::div"));
	  //   driver.switchTo().frame(frame);
			Thread.sleep(2000);
	  WebElement Brands = driver.findElement(By.id("brand_arrowUp"));
	  Actions builder = new Actions(driver);
	  builder.moveToElement(Brands).perform();
	 driver.findElement(By.id("brandSearchBox")).sendKeys("L'Oreal Paris",Keys.ENTER);
	 driver.findElement(By.linkText("L'Oreal Paris")).click();
	 Thread.sleep(2000);
	 String title = driver.getTitle();
	 System.out.println("title of the web page:"+ title); 
	 if(title.contains("L'Oreal Paris - Buy L'Oreal Paris Products Online at Best Price | Nykaa")) {
		 System.out.println(" it contains");
		 }
	 else
		 System.out.println("not contains");
	 
	 builder.sendKeys(Keys.PAGE_DOWN).perform();	
	 driver.findElement(By.xpath( "//span[@class='pull-left']")).click();

	 driver.findElement(By.xpath( "(//div[@class='control-box sort-control-box']/div)[4]")).click();
	 Thread.sleep(2000);
	 driver.findElement(By.xpath( "(//div[@class='filter-sidebar__filter-title pull-left'])[1]")).click();
	 driver.findElement(By.xpath( "(//li[@class='filter-list-header  '])[1]")).click();
	 driver.findElement(By.xpath( "//span[text()='Hair Care']")).click();
	 driver.findElement(By.xpath( "//div[text()='Concern']")).click();
	// builder.sendKeys(Keys.PAGE_DOWN).perform();
	 Thread.sleep(2000);
	 driver.findElement(By.xpath( "//span[text()='Color Protection']")).click();
	 List<WebElement> filter = driver.findElements(By.xpath( "//ul[@class='pull-left applied-filter-lists']/li"));
	 for (WebElement colour : filter) {
		 String pro  = colour.getText();
		 System.out.println("filter applied: " + pro);
			}
	 Thread.sleep(2000);;
	 driver.findElement(By.xpath( "//div[@class='m-content__product-list__title']/h2/span")).click();
	 Set<String> windowHandles1 = driver.getWindowHandles();
	 List<String> strlist = new ArrayList<String>(windowHandles1);
	 driver.switchTo().window(strlist.get(1));
	 driver.findElement(By.xpath( "(//span[@class='size-pallets'])[1]")).click();
	 WebElement MRP = driver.findElement(By.xpath( "(//span[@class='post-card__content-price-offer'])[1]"));
	String MRPtext = MRP.getText();
	System.out.println("price of shampoo:" + MRPtext);
	Thread.sleep(2000);
	driver.findElement(By.xpath( "//div[@class='pull-left']//button")).click();
	driver.findElement(By.xpath( "//div[@class='cursor-hand arrowup-tooltip']/div")).click();
	WebElement grandprice = driver.findElement(By.xpath( "//div[@class='value medium-strong']"));
	String gprice = grandprice.getText();
	System.out.println("grand price: "+ gprice);
	Thread.sleep(2000);
     driver.findElement(By.xpath( "//button[@class='btn full fill']")).click();
//	driver.findElement(By.xpath( "//div[@class='second-col']/button")).click();
//	driver.findElement(By.xpath( "(//button[@type='button'])[2]")).click();
	
	driver.findElement(By.xpath( "//span[text()='Proceed']")).click();

	driver.findElement(By.xpath( "(//button[@type='button'])[2]")).click();
	WebElement grand = driver.findElement(By.xpath( "(//div[@class='value'])[2]"));
	String text = grand.getText();
	if(gprice.contains(text)) {
		System.err.println("both grand price are same ");
	}
	else {
		System.out.println("not both grand price same");
	}
  	
  	
  	
  	


	}

}
