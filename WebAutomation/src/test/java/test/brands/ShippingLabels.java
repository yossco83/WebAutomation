package test.brands;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.List;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import core.Browsers;
import core.TestNGCore;
import pages.BrandPage;
import pages.LoginPage;
import com.relevantcodes.extentreports.LogStatus;
import utility.ExtentBase;



public class ShippingLabels extends TestNGCore
{
	private BrandPage brandPage;
	private LoginPage loginPage;
	
	
	@Test
	public void verifyShippingLabelsTest() throws AWTException
	{
		brandPage = new BrandPage(Browsers.getDriver());
		loginPage = new LoginPage(Browsers.getDriver());
		
		String ordernum;
		Robot r = new Robot();
		
		try {
			test = extent.startTest("Test Brand - Verify Shipping Labels Test" , "Verify printting labels");
			
			//Login
			loginPage.brandLogin();
			test.log(LogStatus.PASS, "Brand Log In" , "Pass");			
			
			//Click My Orders
			brandPage.clickMyOrderBTN();
			test.log(LogStatus.PASS, "My Orders page" , "Pass");
			Thread.sleep(4 * 1000);
			
			brandPage.setAllFilters();
			test.log(LogStatus.PASS, "Set Filters" , "Pass");
			Thread.sleep(3 * 1000);
			
			//All orders			
			List<WebElement> orders = brandPage.getAllOrders();
			int i = 0;			
			for (WebElement order : orders) 
			{
				//Expand the order
				order.click();
				Thread.sleep(6 * 1000);
				test.log(LogStatus.PASS, "Expand order" , "Pass");
				
				//Wait to shipping label BTN
				while(Browsers.getDriver().findElements(By.cssSelector("tr.text-left.sm-collapse-bg-table > td.border-bottom.sm-border-top-none.border-top-0 > div.row.justify-content-between.sm-padding-top-1r > div.col-sm-4.text-right > span.btn.btn-outline-success.m-btn.m-btn--icon.m-btn--pill")).size() == 0  )
				{
					Thread.sleep(2 * 1000);
				}
				
				//Click on visible Shipping Labels				
				brandPage.clickShippingLabelBTN();
				Thread.sleep(2 * 1000);
				
				//Wait to labels - Spinner show				
				while((brandPage.getShippingLabelSpinner()).size() > 0  )
				{
					Thread.sleep(1 * 1000);
					//If Error Alert show					
					if(brandPage.getAllShippigLabelsErrorAlert().size() > 0 )
					{
						ExtentBase.createScreenshot(Browsers.getDriver() , "Failed"+i);
						test.log(LogStatus.FAIL, "Shipping label not printed"  , test.addScreenCapture("C:\\Selenium\\Reports\\screenshots\\Failed"+i+".png"));											
					}					
				}
				Thread.sleep(2 * 1000);
				
				//Verify print up
				ordernum = "Labelsfororder" + i;
				ExtentBase.createScreenshot(Browsers.getDriver() , ordernum);
				test.log(LogStatus.PASS, "Print dialog opened"  , test.addScreenCapture("C:\\Selenium\\Reports\\screenshots\\"+ordernum+".png"));

				//Perform Escape - to close Print dialog
				r.keyPress(KeyEvent.VK_ESCAPE);
				r.keyRelease(KeyEvent.VK_ESCAPE);
				
				
				Thread.sleep(3 * 1000);
				order.click();
				i++;
			}
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			test.log(LogStatus.ERROR, "Test failed while execution" , e);
		}
		
		ExtentBase.createScreenshot(Browsers.getDriver() , "brandPrintLabels");
		test.log(LogStatus.PASS, "Test Brand - Order Confirmed successfully"  , test.addScreenCapture("C:\\Selenium\\Reports\\screenshots\\brandPrintLabels.png"));
	}
}
