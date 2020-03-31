package pages;

import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import core.Browsers;

public class AdminPage {
	//private WebDriver driver;
	//Body 
	@FindBy(css = "body")
	public static WebElement bodyTag;

	//Admin - Login - user name
	@FindBy(xpath = "//input")
	public static WebElement adminUser;

	//Admin - Login - pass
	@FindBy(xpath = "//div[2]/input")
	public static WebElement adminPass;

	//Admin - Login - SignIn Button
	@FindBy(id = "m_login_signin_submit")
	public static WebElement adminSignInBTN;

	//Admin - Order Button
	@FindBy(xpath = "//div[@id='m_ver_menu']/ul/li[2]/a/span/span/span")
	public static WebElement orderBTN;
	
	//Admin - Order Filter
	@FindBy(xpath = "(//input[@value=''])[3]")	
	public static WebElement orderIDTB;
	
	//Admin 
	@FindBy(xpath = "//td[10]/a/i")	
	public static WebElement orderRowBTN;
	
	//All total order from Brand  
	@FindBy(xpath = "(.//*[normalize-space(text()) and normalize-space(.)='Total ordered from Brand after discount:'])/following::dd[1]")	
	public static List<WebElement> allTotalAfterDiscountLBL;
		
		
	//Constructor
	public AdminPage(WebDriver driver)
	{
		//this.driver=driver;

		//Initialise Elements
		PageFactory.initElements(driver, this);
	}

	public void openNewTab() throws InterruptedException
	{
		Actions builder = new Actions(Browsers.getDriver());			
		builder.moveToElement(bodyTag);		
		builder.keyDown(Keys.CONTROL);
		builder.sendKeys("t");
		builder.perform();		
		//bodyTag.sendKeys(Keys.CONTROL +"t");
	}

	public void adminLogin() throws InterruptedException
	{
		adminUser.sendKeys("admin@moonsite.co.il");
		adminPass.sendKeys("Moonsite78()");
		Thread.sleep(1 * 1000);
		adminSignInBTN.click();
		Thread.sleep(3 * 1000);
	}
	
	public void clickOrder()
	{
		orderBTN.click();
	}

	public void sendOrderID(String id)
	{
		orderIDTB.sendKeys(id);
	}
	
	public void clickOnOrder()
	{
		orderRowBTN.click();
	}
	
	public List<WebElement> getAllAddToCartBTN()
	{
		return allTotalAfterDiscountLBL;
	}
}
