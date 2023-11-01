package genericutilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import objectRepository.HomePage;
import objectRepository.LoginPage;

public class BaseClass {
	
	public PropertyFileUtilities pUtil=new PropertyFileUtilities();
	public ExcelFileUtility eUtil=new ExcelFileUtility();
	public JavaUtility jUtil=new JavaUtility();
	public WebDriverUtilities wUtil=new WebDriverUtilities();
	public WebDriver driver=null;
	
	//For listener
	public static WebDriver sdriver;
	
	@BeforeSuite(groups = {"SmokeSuite","ReggressionSuite"})
	public void bsConfig()
	{
		System.out.println("......DB connection successfully......");
	}
	
	//@Parameters("browser")
	//@BeforeTest
	@BeforeClass(alwaysRun = true)
	public void bcConfig(/*String BROWSER*/) throws Throwable
	{
		String BROWSER = pUtil.readDataFromPropertyFile("browser");
		String URL = pUtil.readDataFromPropertyFile("url");
		
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

		// used in  listener
		sdriver=driver;
		
		driver.get(URL);
	}
	@BeforeMethod(alwaysRun=true)
	public void bmConfig() throws Throwable
	{
		String USERNAME = pUtil.readDataFromPropertyFile("username");
		String PASSWORD = pUtil.readDataFromPropertyFile("password");
		
		LoginPage lp=new LoginPage(driver);
		lp.loginToApplication(USERNAME, PASSWORD);
		
	}
	@AfterMethod(alwaysRun = true)
	public void amConfig() throws Throwable
	{
		HomePage hp=new HomePage(driver);
		hp.logOutOfApp(driver);
		System.out.println("........LogOutSuccessfully.........");
	}
	
	//@AfterTest
	@AfterClass(alwaysRun = true)
	public void acConfig()
	{
		driver.quit();
		System.out.println(".......Browser closed.........");

	}
	@AfterSuite(alwaysRun = true)
	public void asConfig()
	{
		System.out.println("......DB connection closed......");

	}

}
