package week4.day1.Assignment;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Classroom2 {

	public static void main(String[] args) {
		//https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_prompt
		WebDriverManager.chromedriver().setup();
		ChromeDriver drive =new ChromeDriver();
		drive.get("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_prompt");
		drive.manage().window().maximize();
		drive.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		drive.switchTo().frame("iframeResult");
		WebElement frameElement = drive.findElement(By.xpath("//button[text()='Try it']"));
		frameElement.click();
		drive.switchTo().alert().accept();
	
		
		
	}

}
