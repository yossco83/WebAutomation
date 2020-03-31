package test.retailer;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import core.Browsers;
import core.TestNGCore;
import pages.LoginPage;
import pages.RetailerHomePage;
import com.relevantcodes.extentreports.LogStatus;
import utility.ExtentBase;

public class RetailerCreateOrderTest extends TestNGCore
{
	private LoginPage loginPage;
	private RetailerHomePage retailerPage;
	
	@Test
	public void createOrderWithSingleProduct() throws InterruptedException 
	{	  
		loginPage = new LoginPage(Browsers.getDriver());
		retailerPage = new RetailerHomePage(Browsers.getDriver()); 
		WebDriverWait wait = new WebDriverWait(Browsers.getDriver(), 10);
		try {		
			test = extent.startTest("Test Retailer - Create order with single product" , "Verify order with all steps");

			loginPage.setRetailerEmail();	
			loginPage.setPass();	
			loginPage.clickSingIn();
			test.log(LogStatus.PASS, "Retailer Log In" , "Pass");

			//Click New Product
			retailerPage.clickNewProductbtn();
			test.log(LogStatus.PASS, "New Product" , "Pass");
			/*
			if(retailerPage.checkIMOVExistInFirstProduct())
			{
				System.out.println("in IF");
				retailerPage.firstProductChangeQuantity();
			}
			*/
			//Add to Cart
			retailerPage.clicAddToCartBTN();
			Thread.sleep(3 * 1000);
			WebElement element = wait.until(ExpectedConditions.visibilityOf(retailerPage.proceedToCheckoutBTN));
			test.log(LogStatus.PASS, "Add To Cart" , "Pass");

			//Proceed to checkout
			retailerPage.clickProceedToCheckoutBTN();
			Thread.sleep(4 * 1000);
			test.log(LogStatus.PASS, "Proceed to checkout" , "Pass");
			element = wait.until(ExpectedConditions.visibilityOf(retailerPage.payWithYourAccountBTN));		
			/*
			if(retailerPage.ifMOVExistInCart())
			{
				test.log(LogStatus.INFO, "MOV show in cart" , "Pass");
				for (WebElement mov : retailerPage.cartMOV) 
				{
					
					
				}
				throw new SkipException("MOV show");
			}
			*/
			//Pay With Your Account
			retailerPage.clickPayWithYourAccountBTN();
			Thread.sleep(5 * 1000);
			test.log(LogStatus.PASS, "Pay With Your Account" , "Pass");
						
			//Get Order number
			test.log(LogStatus.PASS, "Order Number" , retailerPage.getOrderNumberLBL());
			
			//Done
			retailerPage.clickDoneBTN();
			Thread.sleep(3 * 1000);
			test.log(LogStatus.PASS, "Pay With Your Account" , "Pass");

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			test.log(LogStatus.ERROR, "Test failed while execution" , e);
		}	  

		ExtentBase.createScreenshot(Browsers.getDriver() , "RetailerMakeOrderWithSingleProduct");
		test.log(LogStatus.PASS, "Test Retailer - Create order with single product"  , test.addScreenCapture("C:\\Selenium\\Reports\\screenshots\\RetailerMakeOrderWithSingleProduct.png"));
	}


	@Test
	public void createOrderMultipleItemsTest()
	{
		loginPage = new LoginPage(Browsers.getDriver());
		retailerPage = new RetailerHomePage(Browsers.getDriver()); 		
		WebDriverWait wait = new WebDriverWait(Browsers.getDriver(), 120);
				
		int lastProduct = 0;
		String productName;
		int i = 1;
		
		try {
			test = extent.startTest("Test Retailer - Create Order With Multiple Items" , "Verify Order With 70 Items ");

			loginPage.retailerLogin();
			test.log(LogStatus.PASS, "Retailer Logged in "  , "Pass");
			//Click on any local menu 
			retailerPage.clickLocalBtn();
			test.log(LogStatus.PASS, "Click Local from menu "  , "Pass");
			Thread.sleep(5000);
			//WebElement element = wait.until(ExpectedConditions.visibilityOf(retailerPage.nextPageBTN));						 
			if(Browsers.getDriver().findElements(By.xpath("//*[@id='root']/div/div/div/div/div/div/div/div/div/div[3]/div/div/div/a[2]")).size() != 0)
			{				
				System.out.println("In if -retailerPage.nextPageBTN.isDisplayed");
				retailerPage.clickNextPage();
				test.log(LogStatus.PASS, "Click next page "  , "Pass");
				Thread.sleep(5000);
			}
			
			
			//Get all Product in Page 
			List<WebElement> products = retailerPage.getAllAddToCartBTN();
			System.out.println("number of product: " + products.size() );
			test.log(LogStatus.INFO, "Number of product: " + products.size(), "Pass");
			
			List<WebElement> pName =  retailerPage.getAllProductsName();
			for(WebElement it : products) 
			{				
				WebElement element = wait.until(ExpectedConditions.visibilityOf(it));
				productName = pName.get(i).getText();
				
				/*try {
					//If MOV alert shows in product
					if(Browsers.getDriver().findElement(By.xpath("//div[@id='root']/div/div/div/div/div/div/div/div/div/div[2]/div/div["+ (lastProduct + 1) +"]/div[2]/div/div[4]/div/small")) != null)
					{
						Browsers.getDriver().findElement(By.xpath("//div["+ (lastProduct + 1) +"]/div[2]/div/div[4]/div[2]/div/div/input")).clear();
						Browsers.getDriver().findElement(By.xpath("//div["+ (lastProduct + 1) +"]/div[2]/div/div[4]/div[2]/div/div/input")).sendKeys("5");
					}
				} catch (NoSuchElementException  e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}*/
				if(it.isDisplayed())
				{
					it.click();				
					element = wait.until(ExpectedConditions.visibilityOf(retailerPage.closeCartBTN));
					test.log(LogStatus.PASS, "Product: "+ productName +" added to cart" , "Pass");
					
					if(lastProduct++ == products.size() - 1)
					{
						break;					
					}
					
					//Close cart preview 
					retailerPage.clickCloseCart();
				}
				else
				{
					lastProduct++;					
				}				
				i++;
			}			
			//products.get(1).click();	
			//retailerPage.clickCartIcon();
			
			test.log(LogStatus.PASS, "Total Cart Preview" , retailerPage.getTotalCart());
			//Proceed to checkout
			retailerPage.clickProceedToCheckoutBTN();
			Thread.sleep(4 * 1000);
			test.log(LogStatus.PASS, "Proceed to checkout" , "Pass");			
			
			test.log(LogStatus.PASS, "Preview Total" , retailerPage.getPreviewTotal());
			//Pay With Your Account
			retailerPage.clickPayWithYourAccountBTN();
			wait.until(ExpectedConditions.visibilityOf(RetailerHomePage.orderNumbrLBL));
			test.log(LogStatus.PASS, "Pay With Your Account" , "Pass");

			//Get Order number
			test.log(LogStatus.PASS, "Order Number" , retailerPage.getOrderNumberLBL());
			
			//Done
			retailerPage.clickDoneBTN();
			Thread.sleep(3 * 1000);
			test.log(LogStatus.PASS, "Order Success" , "Pass");
			
			
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			test.log(LogStatus.ERROR, "Test failed while execution" , e);
		}
		ExtentBase.createScreenshot(Browsers.getDriver() , "createOrderMultipleItemsTest");
		test.log(LogStatus.PASS, "Create Order With Multiple Items"  , test.addScreenCapture("C:\\Selenium\\Reports\\screenshots\\createOrderMultipleItemsTest.png"));
	}
	
	@Test
	public void addToCartQuickTest()
	{
		loginPage = new LoginPage(Browsers.getDriver());
		retailerPage = new RetailerHomePage(Browsers.getDriver()); 
		WebDriverWait longWait = new WebDriverWait(Browsers.getDriver(), 360);
		WebDriverWait shortWait = new WebDriverWait(Browsers.getDriver(), 180);
		WebElement element;
		
		try {
			test = extent.startTest("Test Retailer - Perfom Quick Add Multiple Items To Cart" , "Verify app does not crash  ");
			
			//Login
			loginPage.retailerLogin();
			test.log(LogStatus.PASS, "Retailer Logged in "  , "Pass");
			
			//Click on any local menu 
			retailerPage.clickLocalBtn();
			test.log(LogStatus.PASS, "Click Local from menu "  , "Pass");
			Thread.sleep(5000);
			
			//Get all Product in Page 
			List<WebElement> products = retailerPage.getAllAddToCartBTN();
			System.out.println("number of product: " + products.size() );
			test.log(LogStatus.INFO, "Number of product: " + products.size(), "Pass");
			
			//List<WebElement> pName =  retailerPage.getAllProductsName();
			for(WebElement it : products) 
			{				
				element = longWait.until(ExpectedConditions.visibilityOf(it));
				
				if(it.isDisplayed())
				{
					it.click();					
				}				
			}
			
			test.log(LogStatus.PASS, "Add all product to cart" , "Pass");
			//Wait to Proceed to checkout BTN
			longWait.until(ExpectedConditions.visibilityOf(RetailerHomePage.proceedToCheckoutBTN));
			
			test.log(LogStatus.PASS, "Wait to procced to checkout button" , "Pass");
			retailerPage.clickProceedToCheckoutBTN();
			Thread.sleep(3 * 1000);
			test.log(LogStatus.PASS, "Proceed to checkout" , "Pass");
			
			test.log(LogStatus.PASS, "Preview Total" , retailerPage.getPreviewTotal());
			//Pay With Your Account
			retailerPage.clickPayWithYourAccountBTN();
			//Thread.sleep(5 * 1000);
			test.log(LogStatus.PASS, "Pay With Your Account" , "Pass");
			
			//Wait to order get paid
			longWait.until(ExpectedConditions.visibilityOf(RetailerHomePage.doneBTN));
			
			//Get Order number
			test.log(LogStatus.PASS, "Order Number" , retailerPage.getOrderNumberLBL());
			
			
			//Done
			retailerPage.clickDoneBTN();
			Thread.sleep(3 * 1000);
			test.log(LogStatus.PASS, "Order Success" , "Pass");			
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			test.log(LogStatus.ERROR, "Test failed while execution" , e);
		}
		ExtentBase.createScreenshot(Browsers.getDriver() , "createOrderMultipleItemsQuickTest");
		test.log(LogStatus.PASS, "Quick Add Multiple Items To Cart"  , test.addScreenCapture("C:\\Selenium\\Reports\\screenshots\\createOrderMultipleItemsQuickTest.png"));
	}
	
	@Test
	public void MOVTest()
	{
		loginPage = new LoginPage(Browsers.getDriver());
		retailerPage = new RetailerHomePage(Browsers.getDriver()); 
		WebDriverWait wait = new WebDriverWait(Browsers.getDriver(), 10);
		
		try {
			test = extent.startTest("Test Retailer - Minimum order value" , "Verify MOV function");

			//Retailer Log in
			loginPage.retailerLogin();
			test.log(LogStatus.PASS, "Retailer Logged in"  , "Pass");
			
			//Search now food
			retailerPage.searchProduct();
			test.log(LogStatus.PASS, "Search now food"  , "Pass");
			
			//Add to Cart
			retailerPage.clicAddToCartBTN();
			Thread.sleep(3 * 1000);
			
			wait.until(ExpectedConditions.visibilityOf(retailerPage.proceedToCheckoutBTN));
			test.log(LogStatus.PASS, "Add To Cart" , "Pass");

			//Proceed to checkout
			retailerPage.clickProceedToCheckoutBTN();
			Thread.sleep(2 * 1000);						
			test.log(LogStatus.PASS, "Proceed to checkout" , "Pass");
			
			wait.until(ExpectedConditions.visibilityOf(retailerPage.payWithYourAccountBTN));		
			retailerPage.clickPayWithYourAccountBTN();
			test.log(LogStatus.PASS, "Pay With Your Account" , "Pass");
			Thread.sleep(2 * 1000);	
			
			//Verify MOV pop up
			if(retailerPage.movPopUpShow())
			{
				test.log(LogStatus.PASS, "MOV pop up display" , "Pass");
			}
			else
			{
				test.log(LogStatus.FAIL, "MOV pop up not display" , "Pass");
			}
			
			/*			
			//Get Order number
			test.log(LogStatus.PASS, "Order Number" , retailerPage.getOrderNumberLBL());
			
			//Done
			retailerPage.clickDoneBTN();
			Thread.sleep(3 * 1000);
			test.log(LogStatus.PASS, "Pay With Your Account" , "Pass");
			*/			
		}
			catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
				test.log(LogStatus.ERROR, "Test failed while execution" , e);
			}
			ExtentBase.createScreenshot(Browsers.getDriver() , "MOV");
			test.log(LogStatus.PASS, "Quick Add Multiple Items To Cart"  , test.addScreenCapture("C:\\Selenium\\Reports\\screenshots\\MOV.png"));
		
		
	}
	
}
