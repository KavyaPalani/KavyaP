package week4.day2.Assignment;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ActionDrag {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver drive =new ChromeDriver();
		drive.get("http://www.leafground.com/pages/drag.html");
		drive.manage().window().maximize();
		drive.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		WebElement move = drive.findElement(By.xpath("//div[@id=\"draggable\"]"));
		//ACTION CLASS
		Actions act=new Actions(drive);
		//DRAG ANDDROP
		act.dragAndDropBy(move, 150, 20).build().perform();
	}

}
