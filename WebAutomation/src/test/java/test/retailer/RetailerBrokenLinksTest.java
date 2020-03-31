package test.retailer;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import core.Browsers;
import pages.LoginPage;
//import com.pages.RetailerHomePage;
import utility.ExtentBase;

import core.TestNGCore;

public class RetailerBrokenLinksTest extends TestNGCore 
{
	//private RetailerHomePage retailerPage;
	private LoginPage loginPage;



	@Test
	public void retailerHomePageBrokenLinksTest()
	{
		//retailerPage = new RetailerHomePage(Browsers.getDriver());
		loginPage = new LoginPage(Browsers.getDriver());
		HttpURLConnection huc = null;
		int respCode = 200;
		String homePage = "http://tst.app.v2.shelfmint.com";
		String url = "";


		try {
			test = extent.startTest("Test Retailer - Broken Links" , "Verify all links in Retailer Page");
			loginPage.retailerLogin();
			test.log(LogStatus.PASS, "Retailer Logged in "  , "Pass");

			Thread.sleep(5000);
			List<WebElement> links = Browsers.getDriver().findElements(By.tagName("a"));
			test.log(LogStatus.PASS, "Number of links found in page: " +  links.size() , "Pass");

			Iterator<WebElement> it = links.iterator();
			while(it.hasNext())
			{
				url = it.next().getAttribute("href");
				System.out.println(url);

				if(url == null || url.isEmpty())
				{
					test.log(LogStatus.INFO, "Link: " + url  , "URL is either not configured for anchor tag or it is empty");
					System.out.println("URL is either not configured for anchor tag or it is empty");
					continue;
				}

				if(!url.startsWith(homePage))
				{
					test.log(LogStatus.INFO, "Link: " + url  , "URL belongs to another domain, skipping it");
					System.out.println("URL belongs to another domain, skipping it.");
					continue;
				}

				try {
					huc = (HttpURLConnection)(new URL(url).openConnection());
					//huc.setRequestMethod("GET");
					huc.connect();
					respCode = huc.getResponseCode();
					if(respCode >= 400)
					{
						test.log(LogStatus.FAIL, "Link: " + url  , "Broken. Code: " + respCode);
						System.out.println(url+" is a broken link");
					}
					else{
						test.log(LogStatus.PASS, "Link: " + url  , "Pass");
						System.out.println(url+" is a valid link");
					}

				} catch (MalformedURLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			test.log(LogStatus.ERROR, "Test failed while execution" , e);
		}
		ExtentBase.createScreenshot(Browsers.getDriver() , "retailerHomePageBrokenLinksTest");
		test.log(LogStatus.INFO, "Test Retailer - Broken Links"  , test.addScreenCapture("C:\\Selenium\\Reports\\screenshots\\retailerHomePageBrokenLinksTest.png"));

	}
}