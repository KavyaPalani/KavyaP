package week4.day2.Assignment;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Erail {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver drive =new ChromeDriver();
		drive.get("https://erail.in/");
		drive.manage().window().maximize();
		drive.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		drive.findElement(By.xpath("(//td/input)[4]")).clear();
		drive.findElement(By.xpath("(//td/input)[4]")).sendKeys("tpj", Keys.TAB);
		drive.findElement(By.xpath("(//td/input)[5]")).clear();
		drive.findElement(By.xpath("(//td/input)[5]")).sendKeys("MS", Keys.TAB);
		drive.findElement(By.xpath("(//td/input)[1]")).click();
		String trainName = drive.findElement(By.xpath("//table[@class='DataTable DataTableHeader TrainList TrainListHeader']//tr[1]/td[2]]")).getText();
		System.out.println(trainName);
		List<WebElement> rows = drive.findElements(By.xpath("//table[@class='DataTable DataTableHeader TrainList TrainListHeader']//tr"));
		System.out.println(rows.size());
		for(int i=0;i<=rows.size();i++) {
			String allTrain = drive.findElement(By.xpath("//table[@class='DataTable DataTableHeader TrainList TrainListHeader']//tr["+i+"]/td[2]")).getText();
			System.out.println(allTrain);
		if(allTrain.contains("CHENNAI")) {
			System.out.println(allTrain);
		}
			
		}
	}

}
