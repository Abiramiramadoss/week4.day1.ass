package week4.day1;

import java.time.Duration;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Frames {

	public static void main(String[] args) {
		
		 WebDriverManager.chromedriver().setup();
			ChromeDriver driver = new ChromeDriver();
			driver.get("http://www.leafground.com/pages/frame.html");
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			driver.switchTo().frame(0);
			WebElement frame1 =driver.findElement(By.id("Click"));
			frame1.click();
			String text = frame1.getText();
			System.out.println(text);
			driver.switchTo().defaultContent();
			driver.switchTo().frame(1);
			driver.switchTo().frame("frame2");
			WebElement frame2 = driver.findElement(By.id("Click1"));
			frame2.click();
			String text2 = frame2.getText();
			System.out.println(text2);
			driver.switchTo().defaultContent();
			
			/*List <WebElement> tagname = driver.findElements(By.tagName("iframe"));
			int size1 = tagname.size();
			System.out.println(size1);
			for (int i = 0; i <size1; i++) {
				
				driver.switchTo().frame(tagname.get(i));
				WebElement tagname1 = driver.findElement(By.tagName("iframe"));
				size= size + tagname1.size();*/
			List<WebElement> outerframe = driver.findElements(By.tagName("iframe"));
			
			int size = outerframe.size();
			System.out.println(size+" frames are in outerframes");
			for(int i=0;i<outerframe.size();i++) {
				driver.switchTo().frame(outerframe.get(i));//0,1,2
				List<WebElement> innerFrame = driver.findElements(By.tagName("iframe"));//0,1,1
			    size = size + innerFrame.size();
			    driver.switchTo().defaultContent();
			    
				 			//driver.switchTo().parentFrame();//will pass the control to parent frame
		}
			System.out.println("Totally "+size+" frames are in page");
			
				
				
				
			}
			
			}
		
			
	


