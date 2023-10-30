package ContactsTests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;
import objectRepository.ContactsInfoPage;
import objectRepository.ContactsPage;
import objectRepository.CreateNewContactsPage;
import objectRepository.CreateNewOrganizationPage;
import objectRepository.HomePage;
import objectRepository.LoginPage;
import objectRepository.OrganizationInfoPage;
import objectRepository.OrganizationPage;

public class CreateContactWithOrganizationTest extends BaseClass {
	
	@Test
	public void createContactWithOrganizationTest() throws Throwable
	{

		
		String ORGNAME = eUtil.readDataFromExcel("Contacts", 7, 3)+jUtil.getRandomNumber();
		String LASTNAME = eUtil.readDataFromExcel("Contacts", 7, 2);
		
		//Launch the browser
		
		
		
		//click on organization
		HomePage hp=new HomePage(driver);
		hp.organizationLink();
		
		//click on organization lookup
		OrganizationPage op=new OrganizationPage(driver);
		op.clickOnOrganizationLookUp();
		//click on create new organization with mandatory fields
		CreateNewOrganizationPage cnop=new CreateNewOrganizationPage(driver);
		cnop.createNewOrganization(ORGNAME);
		//validate organization
		OrganizationInfoPage oip=new OrganizationInfoPage(driver);
		String orgHeader = oip.getHeaderText();
		
		Assert.assertTrue(orgHeader.contains(ORGNAME));
		System.out.println(orgHeader);
		
				
		//click on contacts
		hp.contactsLink();
		//click on contacts look up
		ContactsPage cp=new ContactsPage(driver);
		cp.clickOnContactsLookUp();
		//create new contacts with mandatory fields
		CreateNewContactsPage cncp=new CreateNewContactsPage(driver);
		cncp.createNewContact(driver, LASTNAME, ORGNAME);
		//validation for contacts
		ContactsInfoPage cip=new ContactsInfoPage(driver);
		String contactHeader=cip.getContactsHeaderText();
		
		Assert.assertTrue(contactHeader.contains(LASTNAME));
		System.out.println(contactHeader);
		
		}

}
