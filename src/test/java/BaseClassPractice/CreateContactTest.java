package BaseClassPractice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import genericutilities.BaseClass;
import genericutilities.ExcelFileUtility;
import genericutilities.JavaUtility;
import genericutilities.PropertyFileUtilities;
import genericutilities.WebDriverUtilities;
import objectRepository.ContactsInfoPage;
import objectRepository.ContactsPage;
import objectRepository.CreateNewContactsPage;
import objectRepository.HomePage;
import objectRepository.LoginPage;

public class CreateContactTest extends BaseClass {
	
	@Test(groups = "SmokeSuite")
	public void createContactTest() throws Throwable
	{
				
		
		String LASTNAME = eUtil.readDataFromExcel("Contacts", 7, 2)+jUtil.getRandomNumber();
		
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
		
			
	}

}
