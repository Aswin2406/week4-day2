package week4.day1class_section;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WindowsHanding {
public static void main(String[] args) throws InterruptedException {

	WebDriverManager.chromedriver().setup();
	ChromeDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	driver.get("http://leaftaps.com/opentaps/control/login");
	//String title2 = driver.getTitle();
//	System.out.println("title of the page:"+ title2);
	
	 
	WebElement username = driver.findElement(By.xpath("//input[@id='username']"));
	username.sendKeys("demosalesmanager");
	 
     WebElement password = driver.findElement(By.xpath(  "//input[@type='password']"));
	password.sendKeys("crmsfa");
	 
	 WebElement login = driver.findElement(By.xpath("//input[@type='submit']"));
    login.click();
	 
    driver.findElement(By.linkText(  "CRM/SFA")).click();
    Thread.sleep(3000);

//	driver.findElement(By.xpath(  "//button[@class='btn btn-primary]")).click();
	driver.findElement(By.linkText("Contacts")).click();
	driver.findElement(By.linkText("Merge Contacts")).click();
	
   driver.findElement(By.xpath(( "(//input[@id='partyIdFrom']/following::a/img)[1]"))).click();
    Set<String> handles = driver.getWindowHandles();
    List<String> strlist = new ArrayList<String>(handles);
    driver.switchTo().window(strlist.get(1));
    driver.manage().window().maximize();
	driver.findElement(By.xpath( "(//a[@class='linktext'])[1]")).click();
	 driver.switchTo().window(strlist.get(0));
	Thread.sleep(3000); 
	
	driver.findElement(By.xpath(( "(//input[@id='partyIdTo']/following::a/img)[1]"))).click();
     Set<String> handles2 = driver.getWindowHandles();
	List<String> strlist2 =new ArrayList<String>(handles2);
	driver.switchTo().window(strlist2.get(1));
	driver.manage().window().maximize();
	driver.findElement(By.xpath( "(//a[@class='linktext'])[6]")).click();
	driver.switchTo().window(strlist2.get(0));
	System.out.println("size of windows :" + strlist.size());
	
	driver.findElement(By.className("buttonDangerous")).click();
	Alert alert = driver.switchTo().alert();
	alert.accept();
	String title = driver.getTitle();
	System.out.println(title);
	
	if(title.contains("View Contact | opentaps CRM")) {
		System.out.println("title of the page is matched");
		}
	else {
		System.out.println("title of the page not matched");
	}
 	driver.close();
	
	
	
}
}
