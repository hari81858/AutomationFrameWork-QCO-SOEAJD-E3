package OrganizationTests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import genericutilities.ExcelFileUtility;
import genericutilities.JavaUtility;
import genericutilities.PropertyFileUtilities;
import genericutilities.WebDriverUtilities;
import objectRepository.CreateNewOrganizationPage;
import objectRepository.HomePage;
import objectRepository.LoginPage;
import objectRepository.OrganizationInfoPage;
import objectRepository.OrganizationPage;

public class CreateMultipleOrganizationsIndustryTest {
	
	//Create all the required objects 
			JavaUtility jUtil=new JavaUtility();
			ExcelFileUtility eUtil=new ExcelFileUtility();
			PropertyFileUtilities pUtil=new PropertyFileUtilities();
			WebDriverUtilities wUtil=new WebDriverUtilities();
			
			@Test(dataProvider = "getData")
			public void createMultipleOrga(String ORG,String INDUSTRYNAME) throws Throwable
			{
				
			WebDriver driver=null;	
			//Read the required data
			String BROWSER = pUtil.readDataFromPropertyFile("browser");
			String URL = pUtil.readDataFromPropertyFile("url");
			String USERNAME = pUtil.readDataFromPropertyFile("username");
			String PASSWORD = pUtil.readDataFromPropertyFile("password");
			
			String ORGNAME = ORG+jUtil.getRandomNumber();
			
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
			cnop.createNewOrgnizationWithIndustry(ORGNAME, INDUSTRYNAME);
			wUtil.captureScreenShot(driver, ORGNAME);
			
			//Validate
			OrganizationInfoPage oip=new OrganizationInfoPage(driver);
			String orgHeader = oip.getHeaderText();
			
			Assert.assertTrue(orgHeader.contains(ORGNAME));
			System.out.println(orgHeader);
			
			
			//logout application
			hp.logOutOfApp(driver);
			
			}
			
			@DataProvider
		    public Object[][] getData() throws Throwable
		{
			return eUtil.readMultipleData("MultipleOrgnizations");
		}
}

