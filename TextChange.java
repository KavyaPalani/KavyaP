package week4.day2.Assignment;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TextChange {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver drive = new ChromeDriver();
		drive.get("http://www.leafground.com/pages/TextChange.html");
		drive.manage().window().maximize();
		drive.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		WebElement findElement = drive.findElement(By.xpath("//button[contains(text(),'going to change')]"));
		System.out.println("The Text is: " +findElement.getText());
		WebDriverWait wait = new WebDriverWait (drive,Duration.ofSeconds(15));
		wait.until(ExpectedConditions.invisibilityOf(findElement));
		drive.findElement(By.xpath("//button[text()='Click ME!']")).click();
		drive.switchTo().alert().accept();
		
		
		
	}

}
