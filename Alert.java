package week4.day1;

import java.time.Duration;

import org.openqa.selenium.By;

import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;



public class Alert {
	public static void main(String[] args) throws InterruptedException {
     WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://www.leafground.com/pages/Alert.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	
		driver.findElement(By.xpath("//button[text()='Alert Box']")).click();
		org.openqa.selenium.Alert alert = driver.switchTo().alert();
		alert.accept();
        driver.findElement(By.xpath("//button[text()='Confirm Box']")).click();
        org.openqa.selenium.Alert alert2 = driver.switchTo().alert();
        alert2.dismiss();
       driver.findElement(By.xpath("//button[text()='Prompt Box']")).click();
        org.openqa.selenium.Alert alert3 = driver.switchTo().alert();
       alert3.sendKeys("Button");
       alert3.accept();
       
        driver.findElement(By.xpath("//button[text()='Line Breaks?']")).click();
        org.openqa.selenium.Alert alert4 = driver.switchTo().alert();
        alert4.accept();
        
       driver.findElement(By.xpath("//button[text()='Sweet Alert']")).click();
        driver.findElement(By.xpath("//button[text()='OK']")).click();
       //driver.close();
       
        
           
	}
        
}
