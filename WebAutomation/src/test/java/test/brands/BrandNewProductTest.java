package test.brands;

import java.util.Objects;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import core.Browsers;
import core.TestNGCore;
import pages.BrandPage;
import pages.LoginPage;
import com.relevantcodes.extentreports.LogStatus;
import utility.ExtentBase;

public class BrandNewProductTest extends TestNGCore
{	
	private BrandPage brandPage;
	private LoginPage loginPage;
	@Test
	public void brandAddNewProduct()
	{
		 brandPage = new BrandPage(Browsers.getDriver());
		 loginPage = new LoginPage(Browsers.getDriver());
		
		try
		{	
			test = extent.startTest("Test Brand Add New Product" , "Create new product and verify product added");
		
			loginPage.brandLogin();
			test.log(LogStatus.PASS, "Log In" , "Pass");
			
			brandPage.clickMyProductBTN();
			Thread.sleep(2 * 1000);	
			test.log(LogStatus.PASS, "Brand My Products" , "Pass");
			
			brandPage.clickNewProductBTN();
			Thread.sleep(2 * 1000);	
			test.log(LogStatus.PASS, "Brand New Products" , "Pass");
			
			//General Information
			brandPage.setProductNameTB("Organic Tea 2");
			Thread.sleep(1 * 1000);	
			test.log(LogStatus.PASS, "Brand My Products - Set Product Name" , "Pass");
			
			brandPage.setcategoryTB("Tea");
			test.log(LogStatus.PASS, "Brand My Products - Set Category" , "Pass");	
			Thread.sleep(1 * 1000);	
			
			brandPage.setAttributeTB("paleo");
			test.log(LogStatus.PASS, "Brand My Products - Set Attribute" , "Pass");	
			Thread.sleep(1 * 1000);	
			
			brandPage.setDescriptionTB();
			test.log(LogStatus.PASS, "Brand My Products - Set Description" , "Pass");	
			
			brandPage.setUnitSizeTB();
			test.log(LogStatus.PASS, "Brand My Products - Set Unit Size" , "Pass");	
			
			brandPage.setShelfLifeTB();
			test.log(LogStatus.PASS, "Brand My Products - Set Shelf Life" , "Pass");	
			
			brandPage.setDepositRB();
			test.log(LogStatus.PASS, "Brand My Products - Set Deposit to YES" , "Pass");
			
			brandPage.setUnitPerCaseTB();
			test.log(LogStatus.PASS, "Brand My Products - Set Unit Per Case" , "Pass");
			
			brandPage.setSrpTBTB();
			test.log(LogStatus.PASS, "Brand My Products - Set Suggested Retail Price" , "Pass");
			
			brandPage.setInventoryTB();
			test.log(LogStatus.PASS, "Brand My Products - Set Inventory Price" , "Pass");
			
			brandPage.clickSaveBTN();
			test.log(LogStatus.PASS, "Brand My Products - Click Save button" , "Pass");
			Thread.sleep(3 * 1000);
			
			//Packaging And Shipping
			brandPage.setLengthTB();
			test.log(LogStatus.PASS, "Brand My Products - Set Packing Length" , "Pass");
			
			brandPage.setWidthTB();
			test.log(LogStatus.PASS, "Brand My Products - Set Packing Width" , "Pass");
			
			brandPage.setHeightTB();
			test.log(LogStatus.PASS, "Brand My Products - Set Packing Height" , "Pass");

			brandPage.setWeightTB();
			test.log(LogStatus.PASS, "Brand My Products - Set Packing Weight" , "Pass");
						
			brandPage.setUPCTB();
			test.log(LogStatus.PASS, "Brand My Products - Set UPC number with 8 digits" , "Pass");
			Thread.sleep(3 * 1000);	
			
			try{
				Assert.assertTrue(brandPage.ifUPCadded());
				test.log(LogStatus.PASS, "Brand My Products - UPC number added" , "Pass");
		        }catch(AssertionError e)
		        {
		        	test.log(LogStatus.FAIL, "Brand My Products - UPC number added" , "FAILED");
		        }			
			
			brandPage.clickSavePackagingBTN();
			test.log(LogStatus.PASS, "Brand My Products - Save Packaging" , "Pass");			
			Thread.sleep(3 * 1000);
			
			//Pack Options
			brandPage.clickAddNewCaseBTN();
			test.log(LogStatus.PASS, "Brand My Products - Pack Option - Add New Pack" , "Pass");
			Thread.sleep(1 * 1000);
			
			brandPage.setTotalWightTB();
			test.log(LogStatus.PASS, "Brand My Products - Pack Option - Set Total Weight " , "Pass");
			
			brandPage.setcostPerCaseTB();
			test.log(LogStatus.PASS, "Brand My Products - Pack Option - Set Cost Per Single Case" , "Pass");
			
			brandPage.setOuterLengthTB();
			test.log(LogStatus.PASS, "Brand My Products - Pack Option - Set Outer Length " , "Pass");
			
			brandPage.setOuterWidthTB();
			test.log(LogStatus.PASS, "Brand My Products - Pack Option - Set Outer Width" , "Pass");
						
			brandPage.setOuterHeightTB();
			test.log(LogStatus.PASS, "Brand My Products - Pack Option - Set Outer Height" , "Pass");
			Thread.sleep(2 * 1000);
			
			brandPage.clickSavePackOptionPageBTN();
			brandPage.clickCalculateBTN();
			test.log(LogStatus.PASS, "Brand My Products - Pack Option - Click Calculate" , "Pass");
			Thread.sleep(3 * 1000);			
		   
	        brandPage.clickNewCaseBTN();
			test.log(LogStatus.PASS, "Brand My Products - Pack Option - Click New Case" , "Pass");
			Thread.sleep(3 * 1000);
			
			try{
				Assert.assertTrue(brandPage.verifyCaseAdded());
				test.log(LogStatus.PASS, "Brand My Products - Pack Option - Verify Pack Added ", "Pass");
		        }catch(AssertionError e)
		        {
		        	test.log(LogStatus.FAIL, "Brand My Products - Pack Option - Verify Pack Added" , "FAILED");
		        };
	        Thread.sleep(1 * 1000);

	        brandPage.clickSavePackOptionPageBTN();	       
	        test.log(LogStatus.PASS, "Brand My Products - Pack Option - Click Save Pack Option Page" , "Pass");
			Thread.sleep(3 * 1000);
			
			//Marketing
			brandPage.sendPathToUpload();	
			test.log(LogStatus.PASS, "Brand My Products - Marketing info - Upload Image" , "Pass");
			Thread.sleep(1 * 1000);

			brandPage.clickFrontImageRB();
			test.log(LogStatus.PASS, "Brand My Products - Marketing info - Click Front Image" , "Pass");
			
			brandPage.clickOKBTN();
			test.log(LogStatus.PASS, "Brand My Products - Marketing info - Click OK" , "Pass");   
			Thread.sleep(3 * 1000);
			
			brandPage.setTargetCustomer();
			test.log(LogStatus.PASS, "Brand My Products - Marketing info - Set Target Customer" , "Pass");
			Thread.sleep(3 * 1000);
			
			brandPage.setSuperMarket();
			test.log(LogStatus.PASS, "Brand My Products - Marketing info - Set SuperMarket" , "Pass");
			
			brandPage.clickSaveMarketingBTN();
			test.log(LogStatus.PASS, "Brand My Products - Marketing info - Click Save" , "Pass");   
			Thread.sleep(3 * 1000);
			
			brandPage.clickFinishBTN();
			test.log(LogStatus.PASS, "Brand My Products - Click Finish" , "Pass");   
			Thread.sleep(3 * 1000);
			
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			test.log(LogStatus.ERROR, "Test failed while execution" , e);
		}
		
		ExtentBase.createScreenshot(Browsers.getDriver() , "brandAddNewProduct");
		test.log(LogStatus.PASS, "Test Brand - Add New Product"  , test.addScreenCapture("C:\\Selenium\\Reports\\screenshots\\brandAddNewProduct.png"));			
	}
	
	@Test
	public void addSimilarProductTest()
	{
		 brandPage = new BrandPage(Browsers.getDriver());
		 loginPage = new LoginPage(Browsers.getDriver());
		
		try {
			test = extent.startTest("Test Brand - Add similar Product" , "Verify add similar Product function");
			loginPage.brandLogin();
			test.log(LogStatus.PASS, "Log In" , "Pass");
			
			brandPage.clickMyProductBTN();
			test.log(LogStatus.PASS, "Brand My Products" , "Pass");
			
			brandPage.clickActionFirstProduct();
			test.log(LogStatus.PASS, "Action button" , "Pass");
			
			brandPage.clickAddSimilarProduct();
			test.log(LogStatus.PASS, "Add similar product page" , "Pass");
			
			String pName = Browsers.getDriver().findElement(By.xpath("//input")).getAttribute("value");
			/*
			System.out.println("input: " + brandPage.areAllFieldsClear("//span/div/span[1]"));
			if(brandPage.areAllFieldsClear("//input") == 7)
			{	
				if(brandPage.areAllFieldsClear("//span/div/span[1]") == 2)
				{	
					
				}
				
					brandPage.clickSaveBTN();								
					test.log(LogStatus.PASS, "General Information" , "Pass");
							
			}*/
			brandPage.clickSaveBTN();								
			test.log(LogStatus.PASS, "General Information" , "Pass");
			
			brandPage.setUPCTB();
			test.log(LogStatus.PASS, "Brand My Products - Set UPC number with 8 digits" , "Pass");
			
			brandPage.clickSavePackagingBTN();								
			test.log(LogStatus.PASS, "Packaging And Shipping" , "Pass");
			
			brandPage.clickSavePackOptionPageBTN();								
			test.log(LogStatus.PASS, "Pack Options" , "Pass");
			
			brandPage.clickSaveMarketingBTN();								
			test.log(LogStatus.PASS, "Marketing Information" , "Pass");
			
			Thread.sleep(5 * 1000);
			brandPage.clickFinishBTN();		
			Thread.sleep(2 * 1000);
			test.log(LogStatus.PASS, "Anaylize Product" , "Pass");
			
			//Set DDL to 100 Products
			Select dropdown = new Select(brandPage.showItemDDL);
			dropdown.selectByValue("2");
			
			System.out.println(pName + " And " + Browsers.getDriver().findElement(By.xpath("//*[@id=\"Layout\"]/div/div/div/div[2]/div/div/div[2]/div/div/table/tbody/tr[1]/td[2]/tr/td[2]/div")).getText());
			if(Objects.equals(pName , Browsers.getDriver().findElement(By.xpath("//*[@id=\"Layout\"]/div/div/div/div[2]/div/div/div[2]/div/div/table/tbody/tr[1]/td[2]/tr/td[2]/div")).getText()))
			{
				test.log(LogStatus.PASS, "Product: " + pName + "Added successfully" , "Pass");
			}
			
			
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			test.log(LogStatus.ERROR, "Test failed while execution" , e);
		}
		ExtentBase.createScreenshot(Browsers.getDriver() , "brandAddNewSimilarProduct");
		test.log(LogStatus.PASS, "	Test Brand - Add Similar Product"  , test.addScreenCapture("C:\\Selenium\\Reports\\screenshots\\brandAddNewSimilarProduct.png"));

	}
}
