package week4.day2.Assignment;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Sortable {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver drive =new ChromeDriver();
		drive.get("http://www.leafground.com/pages/sortable.html");
		drive.manage().window().maximize();
		drive.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		WebElement item2 = drive.findElement(By.xpath("(//li[@class='ui-state-default ui-sortable-handle']/span)[7]"));
		WebElement item7 =drive.findElement(By.xpath("(//li[@class='ui-state-default ui-sortable-handle']/span)[2]"));
		Actions act=new Actions(drive);
		act.clickAndHold(item2).moveToElement(item7).release().perform();
		
		
	}

}
