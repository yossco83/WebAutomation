package test.retailer;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import core.Browsers;
import core.TestNGCore;
import pages.LoginPage;
import pages.ProductPage;
import pages.RetailerHomePage;
import com.relevantcodes.extentreports.LogStatus;
import utility.ExtentBase;


public class VerifyGM extends TestNGCore
{
	private LoginPage loginPage;
	private RetailerHomePage retailerPage;	
	
	@Test
	public void verifyGMInProductPage()
	{
		loginPage = new LoginPage(Browsers.getDriver());
		retailerPage = new RetailerHomePage(Browsers.getDriver());
		ProductPage productPage = new ProductPage(Browsers.getDriver());
		try 
		{
			test = extent.startTest("Test Retailer  - Product Page " , "Verify GM, Cost per unit, SRP are equal to Product Page");
			loginPage.retailerLogin();
			test.log(LogStatus.PASS, "Retailer Login" , "Pass");
			
			retailerPage.clickNewProductbtn();
			test.log(LogStatus.PASS, "New Product" , "Pass");
			
			String srp = retailerPage.getSRPFirst();
			test.log(LogStatus.PASS, "First SRP" , srp);
			
			retailerPage.clickFirstItem();
			String srp2 = productPage.getSRPLBL();
			
			Assert.assertEquals(srp, srp2);
			test.log(LogStatus.PASS, "SRP Equal" , "Pass");			
			
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			test.log(LogStatus.ERROR, "Test failed while execution" , e);
		}
		ExtentBase.createScreenshot(Browsers.getDriver() , "VerifyGM");
		test.log(LogStatus.PASS, "Test Retailer - Verify GM, Cost per unit, SRP are equal to Product Page"  , test.addScreenCapture("C:\\Selenium\\Reports\\screenshots\\VerifyGM.png"));
	}
	
	@Test
	public void verifyAll()
	{			
		LoginPage loginPage = new LoginPage(Browsers.getDriver());
		RetailerHomePage retailerPage = new RetailerHomePage(Browsers.getDriver());
		ProductPage productPage = new ProductPage(Browsers.getDriver());
		
		try {
			test = extent.startTest("Test Retailer Data" , "Loop over all products in page");
			loginPage.retailerLogin();
			test.log(LogStatus.PASS, "Retailer Login" , "Pass");
			
			retailerPage.clickNewProductbtn();
			test.log(LogStatus.PASS, "Click New Product from menu" , "Pass");
						
			test.log(LogStatus.INFO, "Number of product in page" , "Count: " + retailerPage.getProductCount());
			
			
			List<WebElement> products = retailerPage.getProductsElements();
			
			//Second version
			List<String> page = new ArrayList<String>();
			List<String> det = new ArrayList<String>(); 
			for (int i = 1; i < products.size(); i++) 
			{
				products = retailerPage.getProductsElements();
				List<WebElement> inner =  products.get(i).findElements(By.className("detail"));
				for(WebElement it : inner) 
				{
				     System.out.print(it.getText() + " ");
				     //a = it.getText();
				     page.add(it.getText());
				}
				products.get(i).findElement(By.className("sm-img-inner")).click();
				det.add(productPage.getSRPLBL());
				det.add(productPage.getGMLBL());
				det.add(productPage.getUnitLBL());
				try {
					Assert.assertEquals(page, det);
				} catch (Throwable t) {
					// TODO Auto-generated catch block
					System.out.println("Exception!!!!!!!!!!!");
					test.log(LogStatus.FAIL, "Data not Equal" , t);
					t.printStackTrace();
				}
				Browsers.getDriver().navigate().back();
				System.out.println("next product");
			}
			test.log(LogStatus.PASS, "SRP, GM, Units Equal to Product page" , "Pass");
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			test.log(LogStatus.ERROR, "Test failed while execution" , e);
		}
		ExtentBase.createScreenshot(Browsers.getDriver() , "RetailerAllProductData");
		test.log(LogStatus.PASS, "Test Retailer - Verify Data for all products in page"  , test.addScreenCapture("C:\\Selenium\\Reports\\screenshots\\RetailerAllProductData.png"));

	}


}
