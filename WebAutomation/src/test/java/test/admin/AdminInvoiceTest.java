package test.admin;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import core.Browsers;
import pages.AdminPage;
import com.relevantcodes.extentreports.LogStatus;
import utility.ExtentBase;

import core.TestNGCore;

public class AdminInvoiceTest extends TestNGCore
{
	private AdminPage adminPage;
	
	@Test
	public void adminLogin() throws InterruptedException
	{	
		adminPage = new AdminPage(Browsers.getDriver());
		
		try {
			test = extent.startTest("Test Admin Invoice" , "Find duplicated");

			adminPage.adminLogin();
			test.log(LogStatus.PASS, "Set user" , "Pass");
			test.log(LogStatus.PASS, "Set password" , "Pass");
			test.log(LogStatus.PASS, "Admin Login" , "Pass");
			
			String URL = Browsers.getDriver().getCurrentUrl();
			//Assert.assertEquals(URL, Browsers.getAdminURL() + "/dashboard" );
			test.log(LogStatus.PASS, "Verify URL" , "Pass");
			Thread.sleep(2 * 1000);
			
			//Refresh the page 
			Browsers.getDriver().navigate().refresh();
			Thread.sleep(2 * 1000);
						
			//click Payments
			Browsers.getDriver().findElement(By.xpath("//div[@id='m_ver_menu']/ul/li[11]/a/span")).click();
			Thread.sleep(2 * 1000);
			Browsers.getDriver().findElement(By.xpath("//div[@id='m_ver_menu']/ul/li[11]/div/ul/li[2]/a/span/span/span")).click();
			Thread.sleep(2 * 1000);
			
			
			/*
			//added////////////////////////////////////////////
			//Create list Of Lists 
			ArrayList<ArrayList<String>> results =new ArrayList<ArrayList<String>>();
			
			//Get All columns and loop			
			List<WebElement> invoiceNums = Browsers.getDriver().findElements(By.xpath("//*[@id=\"base_column_width\"]/div[1]/div[1]/div[2]/div/div/div[6]/div"));
			List<WebElement> orderNums = Browsers.getDriver().findElements(By.xpath("//*[@id=\"base_column_width\"]/div[1]/div[1]/div[2]/div/div/div[7]/a"));
			
			for (WebElement invoiceNums : lines) 
			{
				ArrayList<String> singleList = new ArrayList<String>();
				singleList.add("hello");
				singleList.add("world");
				results.add(singleList);
				//test.log(LogStatus.PASS, "Invoice number:" , line.fi .getText());
			}
			//added////////////////////////////////////////////
			*/
			
			List<WebElement> invoices = Browsers.getDriver().findElements(By.xpath("//*[@id=\"base_column_width\"]/div[1]/div[1]/div[2]/div/div/div[6]/div"));
			
			for (WebElement invoice : invoices) 
			{
				test.log(LogStatus.PASS, "Invoice number:" , invoice.getText());
			}
			//Get second page
			Browsers.getDriver().findElement(By.xpath("//div[2]/ul/li/a")).click();
			Thread.sleep(2 * 1000);
			
			while(!Browsers.getDriver().findElement(By.xpath("//div[2]/div/div/div[2]/div/div/div")).getText().equals(" "))
			{
				Browsers.getDriver().findElement(By.xpath("//div[2]/ul/li[2]/a")).click();
				Thread.sleep(3 * 1000);
				invoices = Browsers.getDriver().findElements(By.xpath("//*[@id=\"base_column_width\"]/div[1]/div[1]/div[2]/div/div/div[6]/div"));
				for (WebElement invoice : invoices) 
				{
					test.log(LogStatus.PASS, "Invoice number:" , invoice.getText());
				}
				Thread.sleep(2 * 1000);
			}				
				
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			test.log(LogStatus.ERROR, "Test failed while execution" , e);
		}

		ExtentBase.createScreenshot(Browsers.getDriver() , "AdminInvoice");
		test.log(LogStatus.PASS, "Test Login - Brand - Add New Product"  , test.addScreenCapture("C:\\Selenium\\Reports\\screenshots\\AdminInvoice.png"));

	}

}
