package week4.day1.Assignment;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AlertsandWindows {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver drive =new ChromeDriver();
		drive.get("https://www.irctc.co.in");
		drive.manage().window().maximize();
		drive.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		drive.findElement(By.xpath("//button[@class='btn btn-primary']")).click();
		drive.findElement(By.xpath("//a[text()=' FLIGHTS ']")).click();
		Set<String> windowHandlesSet = drive.getWindowHandles();
		List<String> windowHandlesList=new ArrayList<String>(windowHandlesSet);
		String newWindow1=windowHandlesList.get(1);
		drive.switchTo().window(newWindow1);
		drive.findElement(By.xpath("//button[text()='Allow']")).click();
		drive.findElement(By.xpath("//a[@id='dropdown10']")).click();
		String emailAddress = drive.findElement(By.xpath("(//a[@class='dropdown-item'])[3]")).getAttribute("href");
		System.out.println("Customer care Email address:" +emailAddress);
		
	}

}
