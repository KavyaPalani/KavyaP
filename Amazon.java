package week4.day1.Assignment;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Amazon {

	public static void main(String[] args) {
//https://www.amazon.in/
		WebDriverManager.chromedriver().setup();
		ChromeDriver drive =new ChromeDriver();
		drive.get("https://www.amazon.in/");
		drive.manage().window().maximize();
		drive.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		drive.findElement(By.id("twotabsearchtextbox")).sendKeys("oneplus 9 pro" , Keys.ENTER);
		String text = drive.findElement(By.xpath("(//span[@class='a-price-symbol'])[1]")).getText();
		String replace = text.replace(",", " ");
		float parseFloat = Float.parseFloat(replace);
		int x=Math.round(parseFloat);
		System.out.println("The Price is : " +x);
		drive.findElement(By.xpath("(//i[@class='a-icon a-icon-star-small a-star-small-4-5 aok-align-bottom'])[1]")).click();
		String text2 = drive.findElement(By.xpath("//span[@class='a-link-normal s-underline-text s-underline-link-text s-link-style']")).getText();
		System.out.println("The Customer rating : " +text2);
			
		
		
		
	}

}
