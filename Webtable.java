package week4.day2.Assignment;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Webtable {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver drive =new ChromeDriver();
		drive.get("http://www.leafground.com/pages/table.html");
		drive.manage().window().maximize();
		drive.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		//get the count of number of columns
		WebElement table = drive.findElement(By.id("table_id"));
		List<WebElement> col = table.findElements(By.tagName("th"));
		int colsize=col.size();
		System.out.println("The column count : " +colsize);
		//get the row count
		List<WebElement> row = table.findElements(By.tagName("tr"));
		int rowsize=row.size();
		System.out.println("The row count : " +rowsize);
		//get the progress value of learn to interact with elements
		
		
	}

}
