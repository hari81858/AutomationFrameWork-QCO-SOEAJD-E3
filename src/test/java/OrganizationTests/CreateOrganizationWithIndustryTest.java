package OrganizationTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import genericutilities.ExcelFileUtility;
import genericutilities.JavaUtility;
import genericutilities.PropertyFileUtilities;
import genericutilities.WebDriverUtilities;
import objectRepository.CreateNewOrganizationPage;
import objectRepository.HomePage;
import objectRepository.LoginPage;
import objectRepository.OrganizationInfoPage;
import objectRepository.OrganizationPage;

public class CreateOrganizationWithIndustryTest {
	
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
		
		//Login to the application
		
		LoginPage lp=new LoginPage(driver);
		lp.loginToApplication(USERNAME, PASSWORD);
		
		//Navigate to the organization link
		HomePage hp=new HomePage(driver);
		hp.organizationLink();
		
		//Click on organization look up 
		OrganizationPage op=new OrganizationPage(driver);
		op.clickOnOrganizationLookUp();
		
		//Create organization with mandatory information
		CreateNewOrganizationPage cnop=new CreateNewOrganizationPage(driver);
		cnop.createNewOrgnizationWithIndustry(ORGNAME, INDUSTRY);
		
		//Validate
		OrganizationInfoPage oip=new OrganizationInfoPage(driver);
		String OrgHeader = oip.getHeaderText();
		
		Assert.assertTrue(OrgHeader.contains(ORGNAME));
		System.out.println(OrgHeader);
		
		
		//logout application
		hp.logOutOfApp(driver);
		
		//close the browser
		driver.quit();
		
	}

}
