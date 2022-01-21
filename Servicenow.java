package week4.day1;

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
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Servicenow {

	public static void main(String[] args) throws IOException {
		 WebDriverManager.chromedriver().setup();
			
			ChromeDriver driver = new ChromeDriver();
			driver.get("https://dev36135.service-now.com/navpage.do");
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
			driver.switchTo().frame("gsft_main");
			driver.findElement(By.xpath("//input[@id='user_name']")).sendKeys("Admin");
			driver.findElement(By.xpath("//input[@id='user_password']")).sendKeys("Abiakr@1606");
			driver.findElement(By.xpath("//button[@id='sysverb_login']")).click();
			driver.findElement(By.xpath("//input[@id='filter']")).sendKeys("incident");
			driver.findElement(By.xpath("(//div[text()='All'])[2]")).click();
			driver.switchTo().frame("gsft_main");
			driver.findElement(By.xpath("//button[@id='sysverb_new']")).click();
			driver.switchTo().defaultContent();
			driver.switchTo().frame("gsft_main");
			driver.findElement(By.xpath("//button[@id='lookup.incident.caller_id']")).click();
			Set<String> window = driver.getWindowHandles();
			List<String>windowhandle=new ArrayList<String>(window);
			driver.switchTo().window(windowhandle.get(1));
			 driver.findElement(By.xpath("//a[text()='Abel Tuter']")).click();
			driver.switchTo().window(windowhandle.get(0));
			driver.switchTo().frame("gsft_main");
			driver.findElement(By.xpath("//input[@id='incident.short_description']")).sendKeys("Add description");
			WebElement incnum = driver.findElement(By.xpath("//input[@id='incident.number']"));
			String attribute = incnum.getAttribute("value");
			System.out.println(attribute);
			driver.findElement(By.xpath("//button[@id='sysverb_insert']")).click();
			driver.switchTo().defaultContent();
			driver.switchTo().frame("gsft_main");
			driver.findElement(By.xpath("//input[@class='form-control']")).sendKeys(attribute,Keys.ENTER);
			driver.switchTo().defaultContent();
			driver.switchTo().frame("gsft_main");
			driver.findElement(By.xpath("//a[@class='linked formlink']")).click();
			driver.switchTo().defaultContent();
			driver.switchTo().frame("gsft_main");
			WebElement incnum1 = driver.findElement(By.xpath("//input[@id='incident.number']"));
			String attribute2 = incnum1.getAttribute("value");
			System.out.println(attribute2);
			driver.switchTo().defaultContent();
			if (attribute2.equals(attribute)) {
				System.out.println("The Incident is Created Successful");
				File source = driver.getScreenshotAs(OutputType.FILE);
				File destination=new File("./images/Incident.png");
				FileUtils.copyFile(source, destination);		
			}
			else {
				System.out.println("Incident not Created");
			}
	}

}
