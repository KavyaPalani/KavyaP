package week4.day1.Assignment;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ServicenowFrames {

	public static void main(String[] args) throws IOException {

		//https://developer.servicenow.com/
		WebDriverManager.chromedriver().setup();
		ChromeDriver drive =new ChromeDriver();
		drive.get("https://dev114597.service-now.com");
		drive.manage().window().maximize();
		drive.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		drive.switchTo().frame(0);
		drive.findElement(By.id("user_name")).sendKeys("admin");
		drive.findElement(By.id("user_password")).sendKeys("vrPzn1pJCNS1");
		drive.findElement(By.xpath("//button[text()='Log in']")).click();
		drive.findElement(By.id("filter")).sendKeys("incident" , Keys.TAB);
		drive.findElement(By.xpath("(//div[text()='All'])[2]")).click();
		drive.switchTo().frame(0);
		drive.findElement(By.xpath("//button[@class='selected_action action_context btn btn-primary']")).click();
		drive.findElement(By.id("lookup.incident.caller_id")).click();
		Set<String> windowHandlesSet = drive.getWindowHandles();
		List<String> list = new ArrayList<String>(windowHandlesSet);
		String newWindow = list.get(1);
		drive.switchTo().window(newWindow);

		drive.findElement(By.xpath("(//a[@class='glide_ref_item_link'])[1]")).click();
		drive.switchTo().window(list.get(0));
		drive.switchTo().frame(0);
		drive.findElement(By.id("incident.short_description")).sendKeys("short description");
		// Read the incident number and save it a variable
		String incidentNumber = drive.findElement(By.id("incident.number")).getAttribute("value");
		System.out.println(incidentNumber);
		// Click on Submit button
		drive.findElement(By.xpath("(//button[text()='Submit'])[2]")).click();

		// Search the same incident number in the next search screen as below
		drive.findElement(By.xpath("(//input[@class='form-control'])[1]")).sendKeys(incidentNumber, Keys.ENTER);
		 //take snapshot of the created incident.
		File screenshot= drive.getScreenshotAs(OutputType.FILE);
		File image = new File("./snaps/servicenow.jpg");
		FileUtils.copyFile(screenshot, image);
		
		// Verify the incident is created successful  
	String incident = drive.findElement(By.xpath("(//a[@class='linked formlink'])[1]")).getText();
		System.out.println(incident);
		if (incidentNumber.equals(incident)) {
			System.out.println("Incident created successfully");
		}
		else {
			System.out.println("Incident not created successfully");
		}
	

}
}


