package week4.day1;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LearnWindow {

	public static void main(String[] args) throws InterruptedException {
		 WebDriverManager.chromedriver().setup();
			ChromeDriver driver = new ChromeDriver();
			driver.get("http://leafground.com/pages/Window.html");
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			String parentwindow = driver.getWindowHandle();
			driver.findElement(By.id("home")).click();
			Set<String> childwindow = driver.getWindowHandles();
			List<String>WindowHandles= new ArrayList<String>(childwindow); 
			driver.switchTo().window(WindowHandles.get(1));
			String title = driver.getTitle();
			System.out.println(title);
			//driver.quit();
			driver.close();
			driver.switchTo().window(WindowHandles.get(0));
			driver.findElement(By.xpath("//button[text()='Open Multiple Windows']")).click();
			Set<String> childwindow1 = driver.getWindowHandles();
			List<String>WindowHandles1 = new ArrayList<String>(childwindow1);
			driver.switchTo().window(WindowHandles1.get(1));
			driver.switchTo().window(WindowHandles1.get(2));
			int size = driver.getWindowHandles().size();
			System.out.println(size);
			driver.close();
			driver.switchTo().window(WindowHandles1.get(0));
			driver.findElement(By.xpath("//button[text()='Do not close me ']")).click();
			Set<String> childwindow2 = driver.getWindowHandles();
			List<String> windowHandles2 = new ArrayList<String>(childwindow2);
			driver.switchTo().window(windowHandles2.get(1));
			driver.switchTo().window(windowHandles2.get(2));
			driver.close();
			driver.switchTo().window(windowHandles2.get(0));
			driver.findElement(By.xpath("//button[text()='Wait for 5 seconds']")).click();
			Thread.sleep(5000);
			Set<String> childwindow3 = driver.getWindowHandles();
			List<String> WindowHandles3 = new ArrayList<String>(childwindow3);
			driver.switchTo().window(WindowHandles3.get(1));
			driver.switchTo().window(WindowHandles3.get(2));
		    driver.switchTo().window(WindowHandles3.get(0));
		    driver.quit();
			
			

	}

}
