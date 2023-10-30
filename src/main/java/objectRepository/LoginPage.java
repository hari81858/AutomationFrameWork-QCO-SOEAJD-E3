package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage { //Rule 1-Create separate page 
	
	//Rule 2-Declaration
	@FindBy(name = "user_name")
	private WebElement userNameEdt;
	
	@FindBy(name = "user_password")
	private WebElement passworgEdt;
	
	@FindBy(id = "submitButton")
	private WebElement loginBtn;
	
	//Rule 3-initialization
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	//Rule 4-utilization

	public WebElement getUserNameEdt() {
		return userNameEdt;
	}

	public WebElement getPassworgEdt() {
		return passworgEdt;
	}

	public WebElement getLoginBtn() {
		return loginBtn;
	}
	
	//Business logic-Generic methods according to the need of the project
	/**
	 * This method will helps to login application
	 * @param USERNAME
	 * @param PASSWORD
	 */
	public void loginToApplication(String USERNAME,String PASSWORD)
	{
		userNameEdt.sendKeys(USERNAME);
		passworgEdt.sendKeys(PASSWORD);
		loginBtn.click();
	}

}
