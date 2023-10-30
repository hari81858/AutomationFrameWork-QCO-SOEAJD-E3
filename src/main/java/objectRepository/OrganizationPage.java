package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationPage {
	
	public OrganizationPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//img[@src='themes/softed/images/btnL3Add.gif']")
	private WebElement organizationLookUp;

	public WebElement getOrganizationLookUp() {
		return organizationLookUp;
	}
	
	//Business library
	/**
	 * This method will helps us click on organization lookup image
	 */
	public void clickOnOrganizationLookUp()
	{
		organizationLookUp.click();
	}

}
