package utility;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import core.TestNGCore;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class ExtentBase extends TestNGCore{
	//public static ExtentReports extent;
	//public static ExtentTest test; 
	static String reportLocation = "C:\\Selenium\\Reports\\screenshots\\";
	
	public static ExtentReports extentInit()
	{
		extent = new  ExtentReports("c://Selenium//Reports//ExtentReport.html" , true);
		//extent.addSystemInfo("","").addSystemInfo(\)
		extent.loadConfig(new File(System.getProperty("user.dir") + "\\extent-config.xml"));
		return extent;
	}			
	
	public static void extentEndTest()
	{
		extent.endTest(test); 
		System.out.println("extentEndTest");
	}
	
	//Screenshot
	public static void createScreenshot(WebDriver driver , String name) {  
        // generate screenshot as a file object
        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try {
            // copy file object to designated location
           org.apache.commons.io.FileUtils.copyFile(scrFile, new File(reportLocation + name + ".png"));
                   } catch (IOException e) {
            System.out.println("Error while generating screenshot:\n" + e.toString());
        }
    }
	
	
	public static void extentClose(ExtentReports extent)
	{
		extent.flush();
		extent.close();
	}
	

}
