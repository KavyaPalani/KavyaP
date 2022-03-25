package week4.day2.Assignment;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ActionDrop {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver drive =new ChromeDriver();
		drive.get("http://www.leafground.com/pages/drop.html");
		drive.manage().window().maximize();
		drive.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		WebElement from = drive.findElement(By.id("draggable"));
		WebElement to = drive.findElement(By.id("droppable"));
		Actions act=new Actions(drive);
		act.dragAndDrop(from, to).build().perform();
		if(drive.findElement(By.xpath("//p[text()='Dropped!']")).isDisplayed())
		{
			System.out.println("Drag and Drop is successfull!!!!");
		}
		else
		{
			System.out.println("Not Successfull");
		}
	}

}
