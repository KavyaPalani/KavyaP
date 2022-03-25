package week4.day2.Assignment;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ExplicitWaitDisapper {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver drive = new ChromeDriver();
		drive.manage().window().maximize();
		drive.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		drive.get("http://www.leafground.com/pages/disapper.html");
		WebElement element = drive.findElement(By.xpath("//b[contains(text(),'going to disappear')]"));
		System.out.println("The text is: " + element.getText());
		WebDriverWait wait = new WebDriverWait (drive,Duration.ofSeconds(15));
		wait.until(ExpectedConditions.invisibilityOf(element));
		if(element.isDisplayed())
		{
			System.out.println("Button Visible");
		}
		else
		{
			System.out.println("Button disappear");
		}
		
	}

}
