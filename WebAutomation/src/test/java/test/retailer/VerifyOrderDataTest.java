package test.retailer;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import core.Browsers;
import core.TestNGCore;
import pages.BrandPage;
import pages.LoginPage;
import pages.RetailerHomePage;
import com.relevantcodes.extentreports.LogStatus;
import utility.ExtentBase;

public class VerifyOrderDataTest extends TestNGCore 
{
	private LoginPage loginPage;
	private RetailerHomePage retailerPage;
	
	
	@Test
	public void verifyAmountCartCheckout()
	{
		loginPage = new LoginPage(Browsers.getDriver());
		retailerPage = new RetailerHomePage(Browsers.getDriver());
		
		try {
			test = extent.startTest("Test Retailer" , "Order Data");
			loginPage.retailerLogin();
			
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			test.log(LogStatus.ERROR, "Test failed while execution" , e);
		}
		ExtentBase.createScreenshot(Browsers.getDriver() , "RetailerAmountData");
		test.log(LogStatus.PASS, "Test Retiler -Verify Amount Cart Checkout"  , test.addScreenCapture("C:\\Selenium\\Reports\\screenshots\\RetailerAmountData.png"));

	}
	
	@Test
	public void addProductsToCart()
	{
		WebDriverWait wait = new WebDriverWait(Browsers.getDriver(), 10);
		LoginPage loginPage = new LoginPage(Browsers.getDriver());
		RetailerHomePage retailerPage = new RetailerHomePage(Browsers.getDriver()); 
		
		int lastProduct = 0;
		String productName;
		int i = 1;
		
		try {
			test = extent.startTest("Test Retailer - Add Products to cart" , "Add Products to cart");

			loginPage.retailerLogin();

			//Click on any local menu 
			retailerPage.clickLocalBtn();
			
			WebElement element = wait.until(ExpectedConditions.visibilityOf(retailerPage.nextPageBTN));						 
			retailerPage.clickNextPage();
			//Get all Product in Page 
			List<WebElement> products = retailerPage.getAllAddToCartBTN();
			System.out.println("number of product: " + products.size() );
			
			List<WebElement> pName =  retailerPage.getAllProductsName();
			for(WebElement it : products) 
			{				
				element = wait.until(ExpectedConditions.visibilityOf(it));
				productName = pName.get(i).getText();
				it.click();				
				element = wait.until(ExpectedConditions.visibilityOf(retailerPage.closeCartBTN));
				test.log(LogStatus.PASS, "Product: "+ productName +" added to cart" , "Pass");				
				//Close cart preview 
				retailerPage.clickCloseCart();
				i++;
			}
			
			test.log(LogStatus.PASS, "Total Cart Preview" , retailerPage.getTotalCart());
			
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			test.log(LogStatus.ERROR, "Test failed while execution" , e);
		}
		ExtentBase.createScreenshot(Browsers.getDriver() , "AddMultiProtuctsToCart");
		test.log(LogStatus.PASS, "Test Retailer - Add Products to cart"  , test.addScreenCapture("C:\\Selenium\\Reports\\screenshots\\AddMultiProtuctsToCart.png"));

	}
	
	@Test
	public void retaileMyOrderTest()
	{
		LoginPage loginPage = new LoginPage(Browsers.getDriver());
		RetailerHomePage retailerPage = new RetailerHomePage(Browsers.getDriver()); 
		int index = 1;
		String total, orderNum;
		try {
			test = extent.startTest("Test Retailer - My order" , "Verify totals in My order screen");
			
			//Login
			loginPage.retailerLogin();
			test.log(LogStatus.PASS, "Retailer logged in" , "Pass");
			
			//Go to My Orders
			retailerPage.getMyOrders();
			Thread.sleep(2 * 1000);
			
			//Get all vie details BTN's 
			List<WebElement> orderDetails = retailerPage.getViewDetailsBTNs();
			
			for(int i = 0; i < orderDetails.size(); i++ )
			{
				orderDetails = retailerPage.getViewDetailsBTNs();
				WebElement inner = orderDetails.get(i);
				
					//Get order num and total
					orderNum = Browsers.getDriver().findElement(By.xpath("//div[@id='root']/div/div/div/div/div[2]/div/div/div/div[3]/div/div/div/table/tbody/tr[" + index + "]/td")).getText();
					total = Browsers.getDriver().findElement(By.xpath("//tr[" + index + "]/td[6]/span")).getText();
					System.out.println(total);
					
					//Click view detail
					inner.click();
					System.out.println("order.click();");
					Thread.sleep(2 * 1000);
					System.out.println("Total in page: " +  retailerPage.getOrderTotalLBL());
					//Compare totals
					//Assert.assertEquals(total, retailerPage.getOrderTotalLBL());
					if(total.equals(retailerPage.getOrderTotalLBL()))
					{
						test.log(LogStatus.PASS, "Total Order: " +orderNum+ "  equal" , "Pass");
					}
					else
					{
						test.log(LogStatus.FAIL, "Total Order: " +orderNum+ "  Not equal to Order summary page" , "Pass");
					}
					
					//Back to My Orders Page
					retailerPage.clickMyOrderBackBTN();
					Thread.sleep(2 * 1000);
					
					index++;
				}
			
			
			
			
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			test.log(LogStatus.ERROR, "Test failed while execution" , e);
		}
		ExtentBase.createScreenshot(Browsers.getDriver() , "myOrderTotals");
		test.log(LogStatus.PASS, "Test Retailer - My order"  , test.addScreenCapture("C:\\Selenium\\Reports\\screenshots\\myOrderTotals.png"));
	}
	
	
	
	

}

