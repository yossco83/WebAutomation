package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import core.Browsers;
import utility.GetPropertyUtil;

public class LoginPage {
	//Login - email
	@FindBy(xpath = "//input[@name='email']")
	public static WebElement loginEmail;

	//Login - pass
	@FindBy(name = "password")
	public static WebElement loginpass;

	//Login - Remember me checkbox
	@FindBy(xpath = "//label/span")
	public static WebElement loginRemembeMe;

	//Login - Sing in Button
	@FindBy(xpath = "//button")
	public static WebElement loginButton;

	//Constructor
	public LoginPage(WebDriver driver)
	{
		//this.driver=driver;

		//Initialise Elements
		PageFactory.initElements(driver, this);
	}

	public void setEmail()
	{
		String email = Browsers.pUtli.getEmail();
		loginEmail.sendKeys(email);
	}

	public void setRetailerEmail()
	{
		String email = Browsers.pUtli.getRetailerEMAIL();
		loginEmail.sendKeys(email);
	}

	public void setBrandEmail()
	{
		String email = GetPropertyUtil.getBrandEmail();
		loginEmail.sendKeys(email);
	}

	public void setPass()
	{
		String pass = Browsers.pUtli.getPass();
		loginpass.sendKeys(pass);
	}

	public void clickSingIn()
	{
		loginButton.click();
	}

	public void brandLogin() throws InterruptedException
	{
		setBrandEmail();
		Thread.sleep(1 * 1000);
		setPass();
		Thread.sleep(1 * 1000);
		clickSingIn();
		Thread.sleep(3 * 1000);
	}

	public void retailerLogin() throws InterruptedException
	{
		setRetailerEmail();
		Thread.sleep(1 * 1000);
		setPass();
		Thread.sleep(1 * 1000);
		clickSingIn();
		Thread.sleep(3 * 1000);
	}




}
