package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactsPage {
	
	public ContactsPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//img[@src='themes/softed/images/btnL3Add.gif']")
	private WebElement contactsLookUp;

	public WebElement getContactsLookUp() {
		return contactsLookUp;
	}
	//Business libraries
	/**
	 * This method will click on contacts lookup image
	 */
	public void clickOnContactsLookUp()
	{
		contactsLookUp.click();
	}

}
