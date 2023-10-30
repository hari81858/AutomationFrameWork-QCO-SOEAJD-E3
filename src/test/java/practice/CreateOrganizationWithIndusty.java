package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import genericutilities.ExcelFileUtility;
import genericutilities.JavaUtility;
import genericutilities.PropertyFileUtilities;
import genericutilities.WebDriverUtilities;
import objectRepository.LoginPage;

public class CreateOrganizationWithIndusty {
	
	public static void main(String[] args) throws Throwable {
		
		        //Create all the required objects 
				JavaUtility jUtil=new JavaUtility();
				ExcelFileUtility eUtil=new ExcelFileUtility();
				PropertyFileUtilities pUtil=new PropertyFileUtilities();
				WebDriverUtilities wUtil=new WebDriverUtilities();
				WebDriver driver=null;
				
				//Read the required data
				String BROWSER = pUtil.readDataFromPropertyFile("browser");
				String URL = pUtil.readDataFromPropertyFile("url");
				String USERNAME = pUtil.readDataFromPropertyFile("username");
				String PASSWORD = pUtil.readDataFromPropertyFile("password");
				
				String ORGNAME = eUtil.readDataFromExcel("Organization", 1, 2)+jUtil.getRandomNumber();
				String INDUSTRY = eUtil.readDataFromExcel("Organization", 4, 3);
				//Launch the browser
				if(BROWSER.equalsIgnoreCase("Chrome")) 
				{
					//WebDriverManager.chromedriver().setup();
					driver=new ChromeDriver();
					System.out.println(BROWSER+"launch");
				}
				else if(BROWSER.equalsIgnoreCase("Edge"))
				{
					//WebDriverManager.edgedriver().setup();
					driver=new EdgeDriver();
					System.out.println(BROWSER+"launched");
				}
				else if(BROWSER.equalsIgnoreCase("FireFox"))
				{
					//WebDriverManager.firefoxdriver().setup();
					driver=new FirefoxDriver();
					System.out.println(BROWSER+"launched");
				}
				else
				{
					System.out.println("Invalrid browser");
				}
				
				wUtil.getMaximize(driver);
				wUtil.waitForPageLoad(driver);
				
				//load the URL
				driver.get(URL);
				
				//Login to application
				//driver.findElement(By.name("user_name")).sendKeys(USERNAME);
				//driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
				//driver.findElement(By.id("submitButton")).click();
				
				LoginPage lp=new LoginPage(driver);
				lp.loginToApplication(USERNAME, PASSWORD);
				
				//lp.getUserNameEdt().sendKeys(USERNAME);
				//lp.getPassworgEdt().sendKeys(PASSWORD);
				//lp.getLoginBtn().click();
				
				
				//Navigate to the organization link
				driver.findElement(By.linkText("Organizations")).click();
				
				//Click on organization look up 
				driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
				
				//Create organization with mandatory information
				driver.findElement(By.name("accountname")).sendKeys(ORGNAME);
				
				//Select chemical as a Industry
				
				WebElement IndustryDropDown = driver.findElement(By.name("industry"));
				Select s=new Select(IndustryDropDown);
				s.selectByValue(INDUSTRY);
				
				//Save
				driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
				
				//Validate
				String OrgHeader = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
				if(OrgHeader.contains(ORGNAME))
				{
					System.out.println(OrgHeader);
					System.out.println("pass");
				}
				else
				{
					System.out.println("fail");
				}
				
				//logout application
				WebElement ele = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
				wUtil.mouserOverAction(driver, ele);
				driver.findElement(By.linkText("Sign Out")).click();
				System.out.println("logout successfull");
				
			}
	
		
		
	}


