package week4.day1.Assignment;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Frames {

	public static void main(String[] args) {
//https://chercher.tech/practice/frames-example-selenium-webdriver
		WebDriverManager.chromedriver().setup();
		ChromeDriver drive =new ChromeDriver();
		drive.get("https://chercher.tech/practice/frames-example-selenium-webdriver");
		drive.manage().window().maximize();
		drive.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		drive.switchTo().frame("frame1");
		//drive.findElement(By.xpath("//b[text()='Topic :']/input")).click();
		drive.switchTo().frame("frame3");
		drive.findElement(By.id("a")).click();
		drive.switchTo().defaultContent();
		drive.switchTo().frame("frame2");
		WebElement ddelement = drive.findElement(By.id("animals"));
		Select dd=new Select(ddelement);
		dd.selectByValue("babycat");
		
		
	}

}
