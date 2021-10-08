package week4.day1class_section;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Myntra {
            public static void main(String[] args) throws InterruptedException {
				
              
            	 WebDriverManager.chromedriver().setup();
       		  ChromeDriver driver =new ChromeDriver();
       		  driver.manage().window().maximize();
       		  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
       		  driver.get(" https://www.myntra.com/");	
       		  
       		  WebElement mens = driver.findElement(By.xpath( "(//div[@class='desktop-navLink']//a)[1]"));
       		  Actions builder = new Actions (driver);
       		  builder.clickAndHold(mens).perform();
       		  WebElement jackects = driver.findElement(By.linkText("Jackets"));
            	jackects.click();
            	
           String text = driver.findElement(By.className("title-count")).getText();
            int count = Integer.parseInt(text.replaceAll("\\D", ""));
            System.out.println("jacket count category:" + count);
            
            String text2 = driver.findElement(By.xpath("//span[@class='title-count']")).getText();
            int count1 = Integer.parseInt(text2.replaceAll("\\D", ""));
            System.out.println("jacket count header:" + count1);
            if(count==count1) {
            	System.out.println("jacket count matched");
            }
            else {
            	System.out.println("not matched");
            }
            
      //      Thread.sleep(2000);
           WebElement more = driver.findElement(By.xpath("//div[@class='brand-more']"));
           builder.moveToElement(more).click().perform();
           driver.findElement(By.xpath("//input[@class='FilterDirectory-searchInput']")).sendKeys("Duke");
    		driver.findElement(By.xpath("//label[@class=' common-customCheckbox']")).click();
    		WebElement closed = driver.findElement(By.xpath("//span[@class='myntraweb-sprite FilterDirectory-close sprites-remove']"));
    		closed.click();
    	
    		List<WebElement> duke = driver.findElements(By.xpath( "//h3[@class='product-brand']"));
         	List<String> srtlist = new ArrayList<String>();
    		
    		for (WebElement list : duke) {
    			String brandname = list.getText();
    			srtlist.add(brandname);
    		}
    			System.out.println("Brand Name:" + srtlist);
    			
    	//		if(srtlist.contains("[Duke]")){
    	//			System.out.println("matched");
    		//	}
    		//	else {
    		//		System.out.println("not matched");
    		//	}
    					
				
				
			
    		
    		
            	
            	 
			}
}
