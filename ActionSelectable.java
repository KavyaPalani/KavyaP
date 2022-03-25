package week4.day2.Assignment;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ActionSelectable {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver drive =new ChromeDriver();
		drive.get("http://www.leafground.com/pages/selectable.html");
		drive.manage().window().maximize();
		drive.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		WebElement findElement = drive.findElement(By.id("mydiv"));
		findElement.click();
		drive.switchTo().frame(findElement);
		WebElement item1 = drive.findElement(By.xpath("//li[text()='Item 3']"));
		WebElement item2 =drive.findElement(By.xpath("//li[text()='Item 5']"));
		WebElement item3 =drive.findElement(By.xpath("//li[text()='Item 7']"));
		Actions selectable=new Actions(drive);
		selectable.keyDown(Keys.CONTROL).click(item1).click(item2).click(item3).keyUp(Keys.CONTROL).perform();
		

	
	}

}
