package test.brands;

import org.testng.annotations.Test;

import core.Browsers;
import pages.BrandPage;
import pages.LoginPage;
import com.relevantcodes.extentreports.LogStatus;
import utility.ExtentBase;

import core.TestNGCore;

public class BrandAddCartonTest extends TestNGCore
{
	private BrandPage brandPage;
	private LoginPage loginPage;
	
	@Test
	public void VerifyAddCartonTest()
	{
		brandPage = new BrandPage(Browsers.getDriver());
		loginPage = new LoginPage(Browsers.getDriver());
		
		try {
			test = extent.startTest("Test Brand - Add new Carton" , "Verify Add New Carton function");
			
			//Login
			loginPage.brandLogin();
			test.log(LogStatus.PASS, "Brand Log In" , "Pass");	
			
			//Click My carton
			brandPage.clickElement(brandPage.myCartoBTN);
			test.log(LogStatus.PASS, "My Carton" , "Pass");	
			
			//Click Add New carton
			brandPage.clickAddNewCartonBTN();
			test.log(LogStatus.PASS, "Add New carton" , "Pass");
			
			//Click Add New carton
			brandPage.setCartonValues();
			test.log(LogStatus.PASS, "Set Carton Name" , "Pass");
			test.log(LogStatus.PASS, "Set Inner Length" , "Pass");
			test.log(LogStatus.PASS, "Set Inner Width" , "Pass");
			test.log(LogStatus.PASS, "Set Inner Height" , "Pass");
			test.log(LogStatus.PASS, "Set Maximum Load" , "Pass");
			//Thread.sleep(5 * 1000);
			
			//Click Add carton - Finish
			brandPage.clickAddNewCartonFinishBTN();
			test.log(LogStatus.PASS, "Add new Carton", "Pass");
			
			
			Thread.sleep(5 * 1000);
		}
				catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			test.log(LogStatus.ERROR, "Test failed while execution" , e);
			
		}
		ExtentBase.createScreenshot(Browsers.getDriver() , "brandAddCarton");
		test.log(LogStatus.PASS, "Test Brand - Add new Carton"  , test.addScreenCapture("C:\\Selenium\\Reports\\screenshots\\brandAddCarton.png"));

		
		
	}

}
