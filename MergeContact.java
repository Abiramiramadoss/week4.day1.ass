package week4.day1;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MergeContact {

	public static void main(String[] args) {
		 WebDriverManager.chromedriver().setup();
			
			ChromeDriver driver = new ChromeDriver();
			driver.get("http://leaftaps.com/opentaps/control/login");
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
			
			 WebElement username = driver.findElement(By.id("username"));
			 username.sendKeys("DemoSalesManager");
		
			 driver.findElement(By.id("password")).sendKeys("crmsfa");
		
			 driver.findElement(By.className("decorativeSubmit")).click();
			 
			  driver.findElement(By.linkText("CRM/SFA")).click();
			  
			  driver.findElement(By.linkText("Contacts")).click();
			  
			  driver.findElement(By.xpath("//a[text()='Merge Contacts']")).click();
			  driver.findElement(By.xpath("(//img[@alt='Lookup'])[1]")).click();
			  Set<String> allWindows = driver.getWindowHandles();
				List<String> allhandles = new ArrayList<String>(allWindows);
				driver.switchTo().window(allhandles.get(1));
				driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a)[1]")).click();
				driver.switchTo().window(allhandles.get(0));
				
				//driver.navigate().back();
				
				driver.findElement(By.xpath("(//img[@alt='Lookup'])[2]")).click();
				 Set<String> allWindows1 = driver.getWindowHandles();
					List<String> allhandles1 = new ArrayList<String>(allWindows1);
					driver.switchTo().window(allhandles1.get(1));
				//driver.switchTo().window(allhandles.get(1));
				driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a)[2]")).click();
				driver.switchTo().window(allhandles1.get(0));
				driver.findElement(By.xpath("//a[text()='Merge']")).click();
				Alert alert = driver.switchTo().alert();
				alert.accept();
				String title = driver.getTitle();
				System.out.println(title);
				
				
				
				
				
				
			 
	}

}

