package week4.day1class_section;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AlertHandling {
	public static void main(String[] args) throws InterruptedException {
		
	
	WebDriverManager.chromedriver().setup();
	ChromeDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	driver.get("http://www.leafground.com/pages/Alert.html");
	
	driver.findElement(By.xpath( "//button[text()='Confirm Box']")).click();
	Alert alert = driver.switchTo().alert();
	String text = alert.getText();
	System.out.println("text in the alert box :"+ text);
alert.accept();
	
driver.findElement(By.xpath( "//button[text()='Prompt Box']")).click();
// Alert alert2 = driver.switchTo().alert();
 String text2 = alert.getText();
 System.out.println("get the text:"+ text2);
Thread.sleep(3000);
alert.sendKeys("open");

alert.accept();

}

}