package week4.day1.Assignment;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WindowsHandling {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver drive =new ChromeDriver();
		drive.get("http://leaftaps.com/opentaps/control/main");
		drive.manage().window().maximize();
		drive.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		drive.findElement(By.id("username")).sendKeys("Demosalesmanager");
		drive.findElement(By.id("password")).sendKeys("crmsfa");
		drive.findElement(By.xpath("//input[@class='decorativeSubmit']")).click();
		drive.findElement(By.xpath("//a[contains(text(),'CRM/SFA')]")).click();
		drive.findElement(By.xpath("//a[text()='Contacts']")).click();
		drive.findElement(By.xpath("//a[text()='Merge Contacts']")).click();
		drive.findElement(By.xpath("(//img[@src= '/images/fieldlookup.gif'])[1]")).click();
		Set<String> windowHandles1 = drive.getWindowHandles();
		List<String> windowHandleList = new ArrayList<String>(windowHandles1);
		String newWindow = windowHandleList.get(1);
		drive.switchTo().window(newWindow);
		System.out.println(drive.getCurrentUrl());
		drive.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a)[1]")).click();
		drive.findElement(By.xpath("(//img[@src='/images/fieldlookup.gif'])[2]")).click();
		Set<String> windowHandles2 = drive.getWindowHandles();
		List<String> windowHandleslist2 = new ArrayList<String> ();
		windowHandleslist2.addAll(windowHandles2);
		String newWindow2 = windowHandleslist2.get(1);
		drive.switchTo().window(newWindow2);
		System.out.println(drive.getCurrentUrl());
		drive.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a)[2]")).click();
		drive.findElement(By.xpath("//a[text()='Merge']")).click();
		drive.switchTo().alert().accept();
		String title = drive.getTitle();
		System.out.println("The Title of the page:"  +title);
		
	}

}
