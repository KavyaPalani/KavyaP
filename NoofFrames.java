package week4.day1.Assignment;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class NoofFrames {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver drive =new ChromeDriver();
		drive.get("http://leafground.com/pages/frame.html");
		drive.manage().window().maximize();
		drive.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		drive.switchTo().frame(0);
		WebElement frame0 = drive.findElement(By.id("Click"));
		frame0.click();
		System.out.println(frame0.getText());
		drive.switchTo().defaultContent();
		drive.switchTo().frame(1);
		drive.switchTo().frame("frame2");
		WebElement frame2 = drive.findElement(By.xpath("//button[@id='Click1']"));
		frame2.click();
		System.out.println(frame2.getText());
		drive.switchTo().defaultContent();
		List<WebElement> outerframe = drive.findElements(By.tagName("iframe"));
		int count=0;
		count=count+outerframe.size();
		System.out.println(count);
		for (int i = 0; i < outerframe.size(); i++) {
			drive.switchTo().frame(i);
			List<WebElement> innerframe = drive.findElements(By.id("frame2"));
			count=count+innerframe.size();
			drive.switchTo().defaultContent();
		}
		System.out.println("The Frame size: " +count);
	}

}
