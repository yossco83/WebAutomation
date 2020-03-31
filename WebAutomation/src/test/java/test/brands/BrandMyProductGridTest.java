package test.brands;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import core.Browsers;
import pages.BrandPage;
import pages.LoginPage;
import com.relevantcodes.extentreports.LogStatus;
import utility.ExtentBase;

import core.TestNGCore;

public class BrandMyProductGridTest extends TestNGCore
{
	private BrandPage brandPage;
	private LoginPage loginPage;
	
	@Test
	public void myProductGridDataTest()
	{
		brandPage = new BrandPage(Browsers.getDriver());
		loginPage = new LoginPage(Browsers.getDriver());
		WebDriverWait wait = new WebDriverWait(Browsers.getDriver(), 30);		
		String str;
		
		try {
			test = extent.startTest("Test Brand Grid data" , "Verify My Products - Grid data");
			
			//Login
			loginPage.brandLogin();
			test.log(LogStatus.PASS, "Brand Log In" , "Pass");			
			
			//Click My Product
			brandPage.clickMyProductBTN();
			
			//spinner gone
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("m-spinner m-spinner--success")));
			
			//Set DDL to 100 Products
			Select dropdown = new Select(brandPage.showItemDDL);
			dropdown.selectByValue("2");
			
			//Wait spinner gone
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("m-spinner m-spinner--success")));
			
			List<WebElement> productsRow;			
			List<WebElement> products = brandPage.getAllProducts();
			
			//For each product
			for(int i = 1; i < products.size() + 1; i++)
			{
				//get product details
				productsRow = Browsers.getDriver().findElements(By.xpath("//table/tbody/tr[" + i + "]/td[position() >= 1 and not(position() > 9)]"));
				
				//For each product
				for (WebElement productData : productsRow) 
				{
					System.out.println(productData.getText()+",length:"+productData.getText().length());
					str = productData.getText();
					//Check if data missing
					if(str.length() == 0)
					{
						test.log(LogStatus.FAIL, "Product Page Missing Data" , "Product Number: " + i);
					}
				}
			}
		
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			test.log(LogStatus.ERROR, "Test failed while execution" , e);
		}
		ExtentBase.createScreenshot(Browsers.getDriver() , "brandMyProductGridData");
		test.log(LogStatus.PASS, "Test Brand - Verify Product Grid data"  , test.addScreenCapture("C:\\Selenium\\Reports\\screenshots\\brandMyProductGridData.png"));
	}
}
