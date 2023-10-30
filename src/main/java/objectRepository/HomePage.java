package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericutilities.WebDriverUtilities;

public class HomePage extends WebDriverUtilities{
	
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(linkText = "Contacts")
	private WebElement contactsLink;
	
	@FindBy(linkText = "Organizations")
	private WebElement organizationLink;
	
	@FindBy(linkText = "Opportunities")
	private WebElement opportunitiesLink;
	
	@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']")
	private WebElement administratorImg;
	
	@FindBy(xpath = "//a[text()='Sign Out']")
	private WebElement signOutBtn;
	
	@FindBy(linkText = "Products")
	private WebElement productsLink;

	public WebElement getProductsLink() {
		return productsLink;
	}

	public WebElement getContactsLink() {
		return contactsLink;
	}

	public WebElement getOrganizationLink() {
		return organizationLink;
	}

	public WebElement getOpportunitiesLink() {
		return opportunitiesLink;
	}

	public WebElement getAdministratorImg() {
		return administratorImg;
	}

	public WebElement getSignOutBtn() {
		return signOutBtn;
	}
	
	//Business Library
	/**
	 * This method will click on contact link
	 */
	public void contactsLink()
	{
		contactsLink.click();
	}
	
	/**
	 * This method will click on organization link
	 */
	public void organizationLink()
	{
		organizationLink.click();
	}
	
	/**
	 * This method will logout of the application
	 * @param driver
	 * @throws Throwable
	 */
	public void logOutOfApp(WebDriver driver) throws Throwable
	{
		mouserOverAction(driver, administratorImg);
		Thread.sleep(2000);
		signOutBtn.click();
		
	}
	
	
	
	

	
}
