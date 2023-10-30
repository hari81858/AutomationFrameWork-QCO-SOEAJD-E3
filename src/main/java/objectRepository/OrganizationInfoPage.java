package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationInfoPage {
	
	public OrganizationInfoPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//span[@class='dvHeaderText']")
	private WebElement orgHeaderText;

	public WebElement getOrgHeader() {
		return orgHeaderText;
	}
	
	//Business libraries
	/**
	 * This method will capture the header text and return it to caller
	 * @return
	 */
	public String getHeaderText()
	{
		return orgHeaderText.getText();
	}
	

}
