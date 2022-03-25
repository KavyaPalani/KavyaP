package week4.day2.Assignment;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ExplicitAppear {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver drive = new ChromeDriver();
		drive.manage().window().maximize();
		drive.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		drive.get("http://www.leafground.com/pages/appear.html");
		WebElement findElement = drive.findElement(By.xpath("//b[contains(text(), 'Guys')]"));
		System.out.println("The text is: " +findElement.getText());
		WebDriverWait wait = new WebDriverWait (drive,Duration.ofSeconds(15));
		wait.until(ExpectedConditions.invisibilityOf(findElement));
		if(findElement.isDisplayed()) {
			System.out.println("Appeared");
		}
		else
		{
			System.out.println("Not Appeared");
		}
	}

}
