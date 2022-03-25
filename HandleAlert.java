package week4.day1.Assignment;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleAlert {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver drive =new ChromeDriver();
		drive.get("http://leafground.com/pages/Alert.html");
		drive.manage().window().maximize();
		drive.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		drive.findElement(By.xpath("//button[text()='Alert Box']")).click();
		drive.switchTo().alert().accept();
		drive.findElement(By.xpath("//button[text()='Confirm Box']")).click();
		drive.switchTo().alert().accept();
		drive.findElement(By.xpath("//button[text()='Prompt Box']")).click();
		drive.switchTo().alert().sendKeys("Kavya");
		drive.switchTo().alert().accept();
		drive.findElement(By.xpath("//button[text()='Line Breaks?']")).click();
		drive.switchTo().alert().accept();
		drive.findElement(By.xpath("//button[text()='Sweet Alert']")).click();
		drive.switchTo().alert().accept();	
		
		
	}

}
