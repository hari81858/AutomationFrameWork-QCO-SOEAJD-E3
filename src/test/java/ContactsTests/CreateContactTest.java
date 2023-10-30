package ContactsTests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

import genericutilities.ExcelFileUtility;
import genericutilities.JavaUtility;
import genericutilities.PropertyFileUtilities;
import genericutilities.WebDriverUtilities;
import objectRepository.ContactsInfoPage;
import objectRepository.ContactsPage;
import objectRepository.CreateNewContactsPage;
import objectRepository.HomePage;
import objectRepository.LoginPage;

public class CreateContactTest {
	
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
				
				
				String LASTNAME = eUtil.readDataFromExcel("Contacts", 7, 2)+jUtil.getRandomNumber();
				
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
				
				//Login the application
				LoginPage lp=new LoginPage(driver);
				lp.loginToApplication(USERNAME, PASSWORD);
				
				//click on contacts
				HomePage hp=new HomePage(driver);
				hp.contactsLink();
				
				//click on contacts look up
				ContactsPage cp=new ContactsPage(driver);
				cp.clickOnContactsLookUp();
				
				//create new contacts with mandatory fields
				CreateNewContactsPage cncp=new CreateNewContactsPage(driver);
				cncp.createNewContact(LASTNAME);
				
				//validation for contacts
				ContactsInfoPage cip=new ContactsInfoPage(driver);
				String contactHeader=cip.getContactsHeaderText();
				
				Assert.assertTrue(contactHeader.contains(LASTNAME));
				System.out.println(contactHeader);
				
				//logout
				hp.logOutOfApp(driver);
				//close the browser
				driver.quit();

	}

}
