package core;

import datadriven.ReadFromExcel;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import utility.ExtentBase;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import java.lang.reflect.Method;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;

public class TestNGCore {
	public static ExtentReports extent;
	public static ExtentTest test; 

	@BeforeSuite
	public void  beforeSuite()
	{		
		//Init ExtentReports for all Suite		
		extent = ExtentBase.extentInit();
	}

	@BeforeTest
	public void  beforeTest()
	{	

	}
		
	@BeforeMethod
	@Parameters("browser")
	public void beforeMethod(String browser, Method method) 
	{			
		//Get method (test) name
		String methodName = method.getDeclaringClass().toString();
		
		//Set Browser configuration
		Browsers.init(browser);
	}

	@DataProvider	
	public Object[][] readCarData() throws Exception
	{
		//Data Driven - Read data from Excel sheet
		Object[][] testObjArray = ReadFromExcel.getTableArray("C:\\Selenium\\DataDriven\\CarData.xlsx","Manufacture");
		return (testObjArray);
	}	

	@AfterMethod
	public void afterMethod() 
	{	
		//ExtentReports - endTest(test);  
		ExtentBase.extentEndTest();
		
		//Close Browser after test
		Browsers.close();	  
	}

	@AfterTest
	public void afterTest()
	{
		
	}
	
	@AfterSuite
	public void endReport()
	{
		//Close and flush ExtentReports
		ExtentBase.extentClose(extent);
	}

}
