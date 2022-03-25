package week4.day1.Assignment;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AlertsandFrames {

	public static void main(String[] args) {
		//https://www.w3schools.com/js/tryit.asp?filename=tryjs_confirm
		WebDriverManager.chromedriver().setup();
		ChromeDriver drive =new ChromeDriver();
		drive.get("https://www.w3schools.com/js/tryit.asp?filename=tryjs_confirm");
		drive.manage().window().maximize();
		drive.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		//switch to frame
		drive.switchTo().frame("iframeResult");
		//click on try it
		drive.findElement(By.xpath("//button[text()='Try it']")).click();
		//switch to alert
		Alert alert = drive.switchTo().alert();
		//get the text using id
		String text = alert.getText();
		System.out.println(text);
		alert.accept();
		//verify the text based on the action
		String text2 = drive.findElement(By.id("demo")).getText();
		System.out.println(text2);	
		
		
	}

}
