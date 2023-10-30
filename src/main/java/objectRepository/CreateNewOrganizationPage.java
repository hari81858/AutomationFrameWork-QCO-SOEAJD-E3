package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericutilities.WebDriverUtilities;

public class CreateNewOrganizationPage extends WebDriverUtilities {
	
	public CreateNewOrganizationPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name = "accountname")
	private WebElement orgNameEdt;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	
	@FindBy(name = "industry")
	private WebElement industryDropDown;
	
    @FindBy(name = "accounttype")
    private WebElement typeDown;
    
	public WebElement getTypeDown() {
		return typeDown;
	}

	public WebElement getOrgNameEdt() {
		return orgNameEdt;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}

	public WebElement getIndustryDropDown() {
		return industryDropDown;
	}
	
	//business libraries
	/**
	 * This method will helps to create a organization with mandatory fields
	 * @param ORGNAME
	 */
	public void createNewOrganization(String ORGNAME)
	{
		orgNameEdt.sendKeys(ORGNAME);
		saveBtn.click();
	}
	
	/**
	 * This method will create organization with industry
	 * @param ORGNAME
	 * @param INDUSTRY
	 */
	public void createNewOrgnizationWithIndustry(String ORGNAME,String INDUSTRY )
	{
		orgNameEdt.sendKeys(ORGNAME);
		handleDropDown(industryDropDown, INDUSTRY);
		saveBtn.click();
	}
	
	/**
	 * This method will crate organization with industry dropDown and type dropDrown
	 * @param ORGNAME
	 * @param INDUSTRY
	 */
	public void createNewOrganization(String ORGNAME,String INDUSTRY,String TYPE)
	{
		orgNameEdt.sendKeys(ORGNAME);
		handleDropDown(industryDropDown, INDUSTRY);
		handleDropDown(industryDropDown, TYPE);
		saveBtn.click();
	}
	

}
