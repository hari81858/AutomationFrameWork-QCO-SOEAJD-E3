package practice;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import genericutilities.BaseClass;
import objectRepository.ContactsInfoPage;
import objectRepository.ContactsPage;
import objectRepository.CreateNewContactsPage;
import objectRepository.HomePage;

@Listeners(genericutilities.ListenersImplementationClass.class)
public class ListnerClassPractice extends BaseClass {
	

	@Test(groups = "SmokeSuite")
	public void createContactTest() throws Throwable
	{
				
		
		String LASTNAME = eUtil.readDataFromExcel("Contacts", 7, 2)+jUtil.getRandomNumber();
		
		//click on contacts
		HomePage hp=new HomePage(driver);
		hp.contactsLink();
		Reporter.log("click on contacts link");
		
		//click on contacts look up
		ContactsPage cp=new ContactsPage(driver);
		cp.clickOnContactsLookUp();
		Reporter.log("click on create contact look up image");
	
		//create new contacts with mandatory fields
		CreateNewContactsPage cncp=new CreateNewContactsPage(driver);
		cncp.createNewContact(LASTNAME);
		Reporter.log("new contact is created");
		
		//validation for contacts
		ContactsInfoPage cip=new ContactsInfoPage(driver);
		String contactHeader=cip.getContactsHeaderText();
		Reporter.log("Header is captured");
		
		Assert.fail();
		
		Assert.assertTrue(contactHeader.contains(LASTNAME));
		System.out.println(contactHeader);
		Reporter.log("header validated");
		
			
	}

	@Test
	public void demo()
	{
		System.out.println("===== Demo =====");
	}

}
