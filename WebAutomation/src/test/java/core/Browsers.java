package core;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import utility.GetPropertyUtil;

public class Browsers {
	public static WebDriver driver;
	public static GetPropertyUtil pUtli;
	private static String baseURL;
	static String path = System.getProperty("user.dir");
	
	public static void init(String browser)
	{		
		//get Browser and baseURL
		getProperties();
		
		//Check if its ADMIN test - So run test on Fire fox Browser
		if(browser.equals("FireFox"))
		{
			System.setProperty("webdriver.gecko.driver", "c://Selenium//geckodriver.exe");
			driver = new FirefoxDriver();						
			
			browserGeneralProp();			
			goTo(baseURL);
			
		}
		else if(browser.equals("Chrome"))
		{			
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--disable-notifications");				
			System.setProperty("webdriver.chrome.driver", "c://Selenium//chromedriver.exe");			
			driver = new ChromeDriver(options);	
			browserGeneralProp();			
			goTo(baseURL);
		}	
	}
	
	public static void browserGeneralProp()
	{
		//Set Timeout
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
 		
		//Maximize and GoTo url
		driver.manage().window().maximize();  
	}

	public static void getProperties()
	{
		pUtli = new GetPropertyUtil();
		baseURL = pUtli.getBaseURL();
	}
	
	public static WebDriver getDriver()
    {
         return driver; 
    }
	
	public static void goTo(String url)
    {
        driver.get(url);      
    }
    
    public static void close()
    {
        driver.close();      
    }	    
}
