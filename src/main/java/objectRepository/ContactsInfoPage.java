package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactsInfoPage {
	
	public ContactsInfoPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//span[@class='dvHeaderText']")
	private WebElement contactsHeader;

	public WebElement getContactsHeader() {
		return contactsHeader;
	}
	
	//Business library
	/**
	 * This method will capture the contacts header and return it to the caller
	 * @return
	 */
	public String getContactsHeaderText()
	{
		return contactsHeader.getText();
	}

}
