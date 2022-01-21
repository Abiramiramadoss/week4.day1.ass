package week4.day1;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FunWithFrames {

	public static void main(String[] args) throws IOException {
		 WebDriverManager.chromedriver().setup();
			ChromeDriver driver = new ChromeDriver();
			driver.get("http://www.leafground.com/pages/frame.html");
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
			driver.switchTo().frame(0);
			driver.findElement(By.xpath("//button[@id='Click']")).click();
			File source = driver.getScreenshotAs(OutputType.FILE);
			File dest=new File("./images/button.png");
			FileUtils.copyFile(source, dest);
			
			driver.switchTo().defaultContent();
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
			driver.close();

	}

}
