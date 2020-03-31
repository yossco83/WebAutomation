package test.admin;


import org.testng.Assert;
import org.testng.annotations.Test;

import core.Browsers;
import pages.AdminPage;
import com.relevantcodes.extentreports.LogStatus;
import utility.ExtentBase;

import core.TestNGCore;

public class AdminLoginTest extends TestNGCore
{
	private AdminPage adminPage;

	@Test
	public void adminLogin() throws InterruptedException
	{	
		adminPage = new AdminPage(Browsers.getDriver());
		
		try {
			test = extent.startTest("Test Admin Login" , "Login to Admin");

			adminPage.adminLogin();
			test.log(LogStatus.PASS, "Set user" , "Pass");
			test.log(LogStatus.PASS, "Set password" , "Pass");
			test.log(LogStatus.PASS, "Admin Login" , "Pass");
			
			String URL = Browsers.getDriver().getCurrentUrl();
			Assert.assertEquals(URL, "http://stg.admin.v2.shelfmint.com/dashboard" );
			test.log(LogStatus.PASS, "Verify URL" , "Pass");
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			test.log(LogStatus.ERROR, "Test failed while execution" , e);
		}

		ExtentBase.createScreenshot(Browsers.getDriver() , "AdminLogin");
		test.log(LogStatus.PASS, "Test Login - Brand - Add New Product"  , test.addScreenCapture("C:\\Selenium\\Reports\\screenshots\\AdminLogin.png"));

	}
}
