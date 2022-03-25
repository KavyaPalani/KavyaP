package week4.day2.Assignment;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Nykaa {

	public static void main(String[] args) throws IOException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver drive =new ChromeDriver();
		drive.get("https://www.nykaa.com/");
		drive.manage().window().maximize();
		drive.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		WebElement brand = drive.findElement(By.xpath("//a[text()='brands']"));
		Actions act=new Actions(drive);
		act.moveToElement(brand).perform();
		drive.findElement(By.xpath("(//a[text()=\"L'Oreal Paris\"])[1]")).click();
		String titlePage = drive.getTitle();
		System.out.println("The Title of the page: " +titlePage);
		if(titlePage.contains("L'Oreal Paris")) {
			System.out.println("The Title of the page is L'Oreal Paris");
		}
		else {
			System.out.println("The Title of the page is not L'Oreal Paris");
		}
		//sort by
		drive.findElement(By.xpath("//span[contains(text(),'Sort By : popularity')]")).click();
		//customer rated
		drive.findElement(By.xpath("//span[contains(text(),'customer top rated')]")).click();
		//click=catergory-hair-haircare-shampoo
		drive.findElement(By.xpath("//span[text()='Category']")).click();
		drive.findElement(By.xpath("//span[text()='Hair']")).click();
		drive.findElement(By.xpath("//span[contains(text(),'Hair Care')]")).click();
		drive.findElement(By.xpath("//span[text()='Shampoo']")).click();
		drive.findElement(By.xpath("//span[text()='Concern']")).click();
		drive.findElement(By.xpath("//span[contains(text(),'Color Protection')]")).click();
		WebElement filter = drive.findElement(By.xpath("//span[@class='filter-value']"));
		if(filter.equals("Shampoo")) 
			System.out.println("Filter is applied");
		else 
			System.out.println("Filter is not applied");
		drive.findElement(By.xpath("(//div[@class='css-43m2vm']/img)[1]")).click();
		Set<String> windowHandles1 = drive.getWindowHandles();
		List<String> windowHandlesList=new ArrayList<String>(windowHandles1);
		String newWindow = windowHandlesList.get(1);
		drive.switchTo().window(newWindow);
		WebElement dropdown = drive.findElement(By.xpath("//select[@class='css-2t5nwu']"));
		Select dd = new Select(dropdown);
		dd.selectByIndex(1);
		String MRP = drive.findElement(By.xpath("//span[@class='css-1jczs19']")).getText();
		System.out.println("The Shampoo Rate is: " +MRP);
		drive.findElement(By.xpath("//span[text()='ADD TO BAG']")).click();
		drive.findElement(By.xpath("//button[@class='css-g4vs13']")).click();
		drive.switchTo().frame(0);
		String grandTotal = drive.findElement(By.xpath("(//div[@class='value'])[4]")).getText();
		String grandTotalreplace = grandTotal.replace("₹", "");
		int total = Integer.parseInt(grandTotalreplace);
		System.out.println("The Grand Total is " + total);
		drive.findElement(By.xpath("//button[@class='btn full fill no-radius proceed ']")).click();
		// Click on Continue as Guest
		drive.findElement(By.xpath("//button[@class='btn full big']")).click();
		// Check if this grand total is the same in step 14
		String cartTotal = drive.findElement(By.xpath("(//div[@class='value']/span)[2]")).getText();
		int total2 = Integer.parseInt(cartTotal);
		System.out.println("The Cart Total is " + total2);
		if (total == total2)
			System.out.println("The grandTotal & cartTotal are same " + cartTotal);

		else
			System.out.println("The grandTotal & cartTotal are not same " + cartTotal);
		File screenshot = drive.getScreenshotAs(OutputType.FILE);
		File image = new File("./snap/Nykaa.jpg");
		FileUtils.copyFile(screenshot, image);
		// Close all windows
		drive.quit();
	}

		
		
		
			
		
	}


