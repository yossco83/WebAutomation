package test.admin;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import core.Browsers;
import core.TestNGCore;
import pages.AdminPage;
import com.relevantcodes.extentreports.LogStatus;
import utility.ExtentBase;

public class BillingTest extends TestNGCore
{
	private AdminPage adminPage;
	
	@Test
	public void examplePage()
	{
		adminPage = new AdminPage(Browsers.getDriver());
		try {
			test = extent.startTest("Test Admin" , "Verify Billing");
			
			adminPage.adminLogin();
			Thread.sleep(15 * 1000);
			adminPage.clickOrder();
			adminPage.sendOrderID("6021");
			Thread.sleep(4 * 1000);
			
			adminPage.clickOnOrder();
			
			List<WebElement> products = adminPage.getAllAddToCartBTN();
			for (WebElement amount : products) 
			{
				System.out.println(amount.toString());
			}
			
			
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			test.log(LogStatus.ERROR, "Test failed while execution" , e);
		}
		ExtentBase.createScreenshot(Browsers.getDriver() , "AdminBilling");
		test.log(LogStatus.PASS, "Test Admin - Brand - Add New Product"  , test.addScreenCapture("C:\\Selenium\\Reports\\screenshots\\AdminBilling.png"));

	}

}
