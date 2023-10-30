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
import objectRepository.CreateNewOrganizationPage;
import objectRepository.HomePage;
import objectRepository.LoginPage;
import objectRepository.OrganizationInfoPage;
import objectRepository.OrganizationPage;

public class CreateOrganizationTest extends BaseClass {
	@Test
	public void createOrgTest() throws Throwable
	{
		
				
				String ORGNAME = eUtil.readDataFromExcel("Organization", 1, 2)+jUtil.getRandomNumber();
				
							
				//Navigate to the organization link
				HomePage hp=new HomePage(driver);
				hp.organizationLink();
				
				//Click on organization look up 
				OrganizationPage op=new OrganizationPage(driver);
				op.clickOnOrganizationLookUp();
				
				//Create organization with mandatory information
				CreateNewOrganizationPage cnop=new CreateNewOrganizationPage(driver);
				cnop.createNewOrganization(ORGNAME);
				
				//Validate
				OrganizationInfoPage oip=new OrganizationInfoPage(driver);
				String orgHeader = oip.getHeaderText();
				
				Assert.assertTrue(orgHeader.contains(ORGNAME));
				System.out.println(orgHeader);
				
				
				
	}

}
