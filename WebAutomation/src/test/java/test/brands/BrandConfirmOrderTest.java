package test.brands;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.SkipException;
import org.testng.annotations.Test;

import core.Browsers;
import pages.BrandPage;
import pages.LoginPage;
import com.relevantcodes.extentreports.LogStatus;
import utility.ExtentBase;

import core.TestNGCore;

public class BrandConfirmOrderTest extends TestNGCore
{
	private BrandPage brandPage;
	private LoginPage loginPage;

	@Test
	public void confirmOrderTest()
	{
		brandPage = new BrandPage(Browsers.getDriver());
		loginPage = new LoginPage(Browsers.getDriver());
		String orderNum;		
		
		try {
			test = extent.startTest("Test Brand - Confirm order" , "Verify order confirmation");

			//Login
			loginPage.brandLogin();
			test.log(LogStatus.PASS, "Brand Log In" , "Pass");			
			
			//Click My Orders
			brandPage.clickMyOrderBTN();
			test.log(LogStatus.PASS, "My Orders page" , "Pass");
			Thread.sleep(6 * 1000);
			//Verify their is order to confirm if does expand it
			if(brandPage.ifHaveOrderConfirmation())
			{
				brandPage.clickConfirmOrderBTN();			
				Thread.sleep(2 * 1000);
				test.log(LogStatus.PASS, "Click Confirm Order" , "Pass");
				
				brandPage.clicksecondConfirmOrderBTN();		
				Thread.sleep(2 * 1000);
				test.log(LogStatus.PASS, "Confirmation page - Click Confirm Order" , "Pass");
				
				//Pop up check box
				brandPage.clickConfirmOrderCB();
				test.log(LogStatus.PASS, "Pop Up Screen - Check Box" , "Pass");
				
				//Click clickConfirmOrderPopUpBTN
				brandPage.clickConfirmOrderPopUpBTN();
				test.log(LogStatus.PASS, "Pop Up Screen - Click Confirm Order" , "Pass");
				
				//Get order number
				orderNum = brandPage.getOrderNumFromConfirmationPage();
				
				test.log(LogStatus.PASS, "Orders Number: " + orderNum , "Pass");
				while(brandPage.waitForPleaseWaitAlertLBL().contains("Please wait"))
				{
					Thread.sleep(3 * 1000);
				}
				
			}
			else
			{
				test.log(LogStatus.INFO, "My Orders page" , "No order to confirmation");
				test.log(LogStatus.SKIP, "Skipped test" , "");
			}
			
			
			Thread.sleep(5 * 1000);
			    

		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			test.log(LogStatus.ERROR, "Test failed while execution" , e);
			
		}
		ExtentBase.createScreenshot(Browsers.getDriver() , "brandConfirmOrder");
		test.log(LogStatus.PASS, "Test Brand - Order Confirmed successfully"  , test.addScreenCapture("C:\\Selenium\\Reports\\screenshots\\brandConfirmOrder.png"));

	}
}
