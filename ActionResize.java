package week4.day2.Assignment;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ActionResize {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver drive =new ChromeDriver();
		drive.get("https://jqueryui.com/resizable");
		drive.manage().window().maximize();
		drive.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		WebElement findFrame = drive.findElement(By.className("demo-frame"));
		drive.switchTo().frame(findFrame);
		WebElement sourceElement = drive.findElement(By.xpath("//div[contains(@class='ui-widget-content ui-resizable')]"));
		Actions act=new Actions(drive);
		act.clickAndHold().dragAndDropBy(sourceElement, 60, 40).perform();
		
	}

}
