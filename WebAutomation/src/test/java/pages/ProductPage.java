package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage {
	//private WebDriver driver;

	//SRP  
	@FindBy(xpath = "(.//*[normalize-space(text()) and normalize-space(.)='Suggested Retail Price (SRP)'])[1]/following::span[1]")
	public static WebElement srpLBl;

	//GM
	@FindBy(xpath = "(.//*[normalize-space(text()) and normalize-space(.)='Gross margin'])[1]/following::span[1]")
	public static WebElement gmLBl;

	//Unit per Case
	@FindBy(xpath = "(.//*[normalize-space(text()) and normalize-space(.)='Units per Case'])[1]/following::span[1]")
	public static WebElement unitLBl;
		
	//Constructor
	public ProductPage(WebDriver driver)
	{
		//this.driver=driver;
		
		//Initialise Elements
		PageFactory.initElements(driver, this);
	}
	
	//Methods
	public String getSRPLBL()
	{
		return srpLBl.getText();
	}
	
	public String getGMLBL()
	{
		return gmLBl.getText();
	}

	
	public String getUnitLBL()
	{
		return unitLBl.getText();
	}

}
