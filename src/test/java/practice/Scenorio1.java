package practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Scenorio1 {
	
	public static void main(String[] args) {
		
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//Load the application
		driver.get("http://localhost:8888/");
		
		//login to the application
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		
		//Navigate to contact link
		driver.findElement(By.linkText("Contacts")).click();
		
		//click on create contact look up link
		driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();
		
		//create contact
		driver.findElement(By.name("lastname")).sendKeys("spiderman");
		
		//save
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		//validate
		String contactHeader = driver.findElement(By.className("dvHeaderText")).getText();
		if(contactHeader.contains("spiderman"))
		{
			System.out.println("pass");
		}
		else
		{
			System.out.println("fail");
		}
		
		//logout
		WebElement ele = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		Actions act=new Actions(driver);
		act.moveToElement(ele).perform();
		driver.findElement(By.linkText("Sign Out")).click();
		System.out.println("sing out successful");
		
	

	}

}
