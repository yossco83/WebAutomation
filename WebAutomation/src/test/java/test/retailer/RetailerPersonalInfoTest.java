package test.retailer;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import core.Browsers;
import pages.LoginPage;
import pages.RetailerHomePage;
import utility.ExtentBase;

import core.TestNGCore;

public class RetailerPersonalInfoTest extends TestNGCore
{
	private LoginPage loginPage;
	private RetailerHomePage retailerPage;
	
	
	@Test
	public void verifyPersonalDataTest()
	{
		loginPage = new LoginPage(Browsers.getDriver());
		retailerPage = new RetailerHomePage(Browsers.getDriver());
		String strInfo = "";
		String originalMail = "";
		int index = 1;
		
		try {
			test = extent.startTest("Test Retailer - Personal Info Test" , "Verify Personal Info for retailer");
			
			//Login
			loginPage.retailerLogin();
			test.log(LogStatus.PASS, "Retailer Log In" , "Pass");
			
			retailerPage.getPersonalInfo();
			
			for (WebElement webElement : retailerPage.getpersonalDataInput()) 
			{
				strInfo = webElement.getAttribute("value");
				if(strInfo.length() != 0)
				{
					System.out.println(strInfo);
					test.log(LogStatus.PASS, "Details: " + strInfo , "Pass");
					webElement.clear();
					
					switch(index)
					{
					 case 1:  webElement.sendKeys("A" + strInfo);
                     break;
					 case 2:  webElement.sendKeys("A" + strInfo);
                     break;
					 case 3:  webElement.sendKeys("A" + strInfo);
                     break;
					 case 4:  webElement.sendKeys("a" + strInfo);
                     break;		          
					}					
				}
				else
				{
					test.log(LogStatus.FAIL, "Info Missing" , "Failed");
				}				
				index++;
			}
			
			//Click Save
			retailerPage.clickPersonalInfoSaveBTN();
			Thread.sleep(2 * 1000);
			
			if(retailerPage.getErrorAlert().size()> 0)
			{
				test.log(LogStatus.FAIL, "Error Alert" , "Failed");
			}
			
			//Back to original Mail 
			retailerPage.setPersonalInfoMailLbl(strInfo);
			//Click Save
			retailerPage.clickPersonalInfoSaveBTN();
			Thread.sleep(2 * 1000);	
			
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			test.log(LogStatus.ERROR, "Test failed while execution" , e);
		}
		ExtentBase.createScreenshot(Browsers.getDriver() , "PersinalInfoTest");
		test.log(LogStatus.PASS, "Verify Personal Info for retailer"  , test.addScreenCapture("C:\\Selenium\\Reports\\screenshots\\PersinalInfoTest.png"));

	}


}
