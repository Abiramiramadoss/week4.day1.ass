package week4.day1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CherCher {

	public static void main(String[] args) {
		 WebDriverManager.chromedriver().setup();
			ChromeDriver driver = new ChromeDriver();
			driver.get("https://chercher.tech/practice/frames-example-selenium-webdriver");
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.switchTo().frame("frame1");
			driver.findElement(By.xpath("//b[@id='topic']/following::input")).sendKeys("Not a Friendly Topic");
			driver.switchTo().frame("frame3");
			driver.findElement(By.xpath("//input[@type='checkbox']")).click();
			driver.switchTo().defaultContent();
			driver.switchTo().frame("frame2");
			WebElement dd = driver.findElement(By.id("animals"));
			Select dropdown = new Select(dd);
			dropdown.selectByIndex(1);
			
			
			
			
			

	}

}
