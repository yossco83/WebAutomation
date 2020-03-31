package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import core.Browsers;


public class BrandPage{
	//private WebDriver driver;
	//Brand - My Products
	@FindBy(linkText = "My Products")
	public static WebElement myProductBTN;

	//Add new Product
	@FindBy(xpath = "(.//*[normalize-space(text()) and normalize-space(.)='My Products'])[2]/following::span[3]")
	public static WebElement newProductBTN;

	//Product Name
	@FindBy(id = "productName")
	public static WebElement productNameBTN;

	//Category
	@FindBy(xpath = "(.//*[normalize-space(text()) and normalize-space(.)='Categories'])[1]/following::text[1]")
	public static WebElement categoryTB;

	//Attributes
	@FindBy(xpath = "(.//*[normalize-space(text()) and normalize-space(.)='Attributes'])[1]/following::text[1]")
	public static WebElement attributeTB;

	//Description
	@FindBy(name = "description")
	public static WebElement descriptionTB;

	//Unit Size
	@FindBy(id = "unitSize")
	public static WebElement unitSizeTB;

	//shelf_life
	@FindBy(name = "shelf_life")
	public static WebElement unitLifeTB;

	//shelf_life
	@FindBy(xpath = "//label/span")
	public static WebElement depositRB;

	//unit Per Case
	@FindBy(name = "units_per_case")
	public static WebElement unitPerCaseTB;

	//SRP
	@FindBy(name = "srp")
	public static WebElement srpTB;

	//inventory
	@FindBy(name = "inventory")
	public static WebElement inventoryTB;

	//Save btn
	@FindBy(xpath = "(.//*[normalize-space(text()) and normalize-space(.)='Cancel'])[1]/following::button[1]")
	public static WebElement saveBTN;

	//Length
	@FindBy(name = "length")
	public static WebElement lengthTB ;

	//Width
	@FindBy(name = "width")
	public static WebElement widthTB;

	//Height
	@FindBy(name = "height")
	public static WebElement heightTB;

	//Weight 
	@FindBy(name = "weight")
	public static WebElement weightTB;

	//upc
	@FindBy(name = "upc")
	public static WebElement upcTB;

	//upc Add Button
	@FindBy(xpath = "//div[@id='Layout']/div/div/div/div[2]/div/div/div[2]/div/div/form/div/div/div[5]/div/div/div[2]/div/div[2]/button")
	public static WebElement upcAddBTN;

	//upc Add Button
	@FindBy(xpath = "(.//*[normalize-space(text()) and normalize-space(.)='If a variety pack, please include every SKUs UPC code.'])[1]/following::td[1]")
	public static WebElement upcAddedLBL;			

	//Save Packaging level Button
	@FindBy(xpath = "(.//*[normalize-space(text()) and normalize-space(.)='Back'])[1]/following::button[1]")
	public static WebElement savePackagingBTN;		

	//Add New Case Button 
	@FindBy(xpath = "(.//*[normalize-space(text()) and normalize-space(.)='My Cases'])[1]/following::span[1]")
	public static WebElement addNewCaseBTN;

	//Total Weight
	@FindBy(name = "totalWight")
	public static WebElement totalWightTB;

	//costPerCase
	@FindBy(name = "costPerCase")
	public static WebElement costPerCaseTB;

	//Outer length
	@FindBy(name = "length")
	public static WebElement outerLengthTB;

	//Outer Width
	@FindBy(name = "width")
	public static WebElement outerWidthTB;

	//Outer height
	@FindBy(name = "height")
	public static WebElement OuterHeightTB;

	//Calculate
	@FindBy(xpath = "(.//*[normalize-space(text()) and normalize-space(.)='Gross Margin including shipment for NY:'])[1]/following::button[1]")
	public static WebElement calculateBTN ;

	//Save Pack Option 
	@FindBy(xpath = "(.//*[normalize-space(text()) and normalize-space(.)='Back'])[1]/following::button[1]")
	public static WebElement savePackOptionBTN;

	//Calculated GM
	@FindBy(xpath = "//*[@id=\"NewPackageForm\"]/div/div[3]/div/div/div[2]/table/tbody/span")
	public static WebElement calculatedGMLBL;

	//Add New Case BTN
	@FindBy(xpath = "(.//*[normalize-space(text()) and normalize-space(.)='Discard Changes'])[1]/following::button[1]")
	public static WebElement newCaseBTN ;

	//Add Pack Verify Case Added
	@FindBy(xpath = "(.//*[normalize-space(text()) and normalize-space(.)='Single Case'])[2]/following::i[1]")
	public static WebElement  editCaseBTN;

	//Save Pack option page	
	@FindBy(xpath = "(.//*[normalize-space(text()) and normalize-space(.)='Back'])[1]/following::button[1]")
	public static WebElement  savePackOptionPageBTN;		

	/////Marketing Information//////	
	//Input File Path
	@FindBy(xpath = "//*[@id=\"Layout\"]/div/div/div/div[2]/div/div/div[2]/div[1]/div/div[2]/div[1]/div[4]/div[1]/input")
	public static WebElement  fileUploadeBTN;

	//Front Image
	@FindBy(xpath = "(.//*[normalize-space(text()) and normalize-space(.)='Front of Image'])[1]/span[1]")
	public static WebElement frontImage;

	//Back Image
	@FindBy(xpath = "(.//*[normalize-space(text()) and normalize-space(.)='Back of Image'])[1]/span[1]")
	public static WebElement backImage;

	//Label Image
	@FindBy(xpath = "(.//*[normalize-space(text()) and normalize-space(.)='Label/Ingredients'])[1]/span[1]")
	public static WebElement labelImage;

	//Other Image
	@FindBy(xpath = "(.//*[normalize-space(text()) and normalize-space(.)='Other Image'])[1]/span[1]")
	public static WebElement otherImage;

	//OK button 
	@FindBy(xpath = "(.//*[normalize-space(text()) and normalize-space(.)='Other Image'])[1]/following::button[1]")
	public static WebElement OKBTN;

	//Target Customer
	@FindBy(xpath = "(.//*[normalize-space(text()) and normalize-space(.)='Target Customers'])[1]/following::div[4]")
	public static WebElement targetCustomer;

	//Supermarket 
	@FindBy(xpath = "(.//*[normalize-space(text()) and normalize-space(.)='Supermarkets, groceries and etc.'])[1]/following::div[4]")
	public static WebElement supermarket;

	//Save 
	@FindBy(xpath = "(.//*[normalize-space(text()) and normalize-space(.)='Back'])[1]/following::button[1]")
	public static WebElement saveMarketingBTN;

	//Save New Product
	@FindBy(xpath = "(.//*[normalize-space(text()) and normalize-space(.)='Back'])[1]/following::button[1]")
	public static WebElement finishBTN;

	//My Order 
	@FindBy(linkText = "My Orders")
	public static WebElement myOrderBTN;

	//All product Elemnts 
	@FindBy(xpath = "//table/tbody/tr")
	public  List<WebElement> allProducts;

	//Set DDL to 100 Products
	@FindBy(name = "numberOfItemToShow")
	public  WebElement showItemDDL;

	//Spinner	
	@FindBy(css = "m-spinner m-spinner--success")
	public  WebElement spinner;

	//Action for first product	
	@FindBy(xpath = "//*[@id=\"Layout\"]/div/div/div/div[2]/div/div/div[2]/div/div/table/tbody/tr[1]/td[10]/div/div/a/a")
	public  WebElement actionFirstProduct;

	@FindBy(xpath = "(.//*[normalize-space(text()) and normalize-space(.)='Edit Product'])[1]/following::button[1]")
	public  WebElement addSimilarBTN;

	//My Orders - list of all orders 
	@FindBy(xpath = "//tbody/tr/td[5]/span")
	public  List<WebElement> allOrdersStatuses;

	//Shipping label BTN
	@FindBy(css = "tr.text-left.sm-collapse-bg-table > td.border-bottom.sm-border-top-none.border-top-0 > div.row.justify-content-between.sm-padding-top-1r > div.col-sm-4.text-right > span.btn.btn-outline-success.m-btn.m-btn--icon.m-btn--pill")
	public WebElement shippingLabelBTN;
	
	//Shipping labels spinner   
	@FindBy(css = "#Layout > div > div > div > div.m-content > div.myOrders.row.d-print-none > div > div > div.m-portlet__body > div:nth-child(1) > div > div > table > tbody > tr.text-left.sm-collapse-bg-table > td > div > div.col-sm-4.text-right > div > div > span:nth-child(2) > div")
	public List<WebElement> shippingLabelSpinner;
	
	//Shipping labels - Error alert
	@FindBy(xpath = "//*[@id=\"toast-container\"]/div/div")
	public  List<WebElement> shippigLabelsErrorAlert;
	
	//Click first confirm order
	@FindBy(xpath = "//*[text()[contains(.,'Confirm order')]]")
	public  WebElement confirmOrderBTN;
	
	//Order number from confirmation page
	@FindBy(xpath = "//*[@id=\"Layout\"]/div/div/div/div[2]/div/div[1]/div/div[1]/div[1]/h1")
	public  WebElement OrderNumberConfirmationPageLBL;
	
	//My Carton 
	@FindBy(linkText = "My Cartons")
	public  WebElement myCartoBTN;
	
	//Add New Carton 
	@FindBy(xpath = "//div[2]/a/span/span/span")
	public  WebElement addNewCartonBTN;
	
	//Carton Name
	@FindBy(id = "cartonTitle")
	public  WebElement cartonNameTB;
	
	//Length TB
	@FindBy(id = "i_length")
	public  WebElement cartoLengthTB;
	
	//Width  TB
	@FindBy(id = "i_width")
	public  WebElement cartoWidthTB;
	
	//Inner Height 
	@FindBy(id = "i_height")
	public  WebElement cartonHeightTB;
	
	//Maximum Load
	@FindBy(id = "maximum_load")
	public  WebElement cartonMaxLoadTB;
	
	//Tare Weight
	@FindBy(id = "tare_weight")
	public  WebElement cartonWeightTB;
	
	//Add new - Finish
	@FindBy(xpath = "//button[2]")
	public  WebElement addNewCartonFinishBTN;
	
	//My order filter
	@FindBy(id = "multiFilterBtn")
	public static WebElement  myOrderFilterBTN;
	
	//My order filter
	@FindBy( xpath = "//div[@id='Layout']/div/div/div/div[2]/div/div/div/div[2]/div/div/div/table/tbody/tr/td[8]")
	public static List<WebElement>  allOrders;
	
	//My order filter - 1
	@FindBy(xpath = "//*[@id=\"multiFilterDropDown\"]/li[1]/label/span")
	public static WebElement  myOrderFilterOneBTN;
	
	//My order filter - 3
	@FindBy(xpath = "//*[@id=\"multiFilterDropDown\"]/li[3]/label/span")
	public static WebElement  myOrderFilterThreeBTN;
	
	//My order filter - 4
	@FindBy(xpath = "//*[@id=\"multiFilterDropDown\"]/li[4]/label/span")
	public static WebElement  myOrderFilterFourBTN;
	
	//Confirm order check box
	@FindBy(xpath = "/html/body/div[2]/div/div[1]/div/div/div[2]/div/div/div[3]/label/span")
	public static WebElement confirmOrderCB;
	
	//Confirm order pop up!
	@FindBy(xpath = "//button[2]")
	public static WebElement confirmOrderPopUpBTN;
	
	//Confirm order pop up!
	@FindBy(xpath = "//div[2]/button")
	public static WebElement secondConfirmOrderBTN;
	
	//Please wait alert
	@FindBy(xpath = "//div[2]/div/span")
	public static WebElement pleaseWaitAlertLBL;
	
	
	//Constructor
	public BrandPage(WebDriver driver)
	{
		//this.driver=driver;

		//Initialise Elements
		PageFactory.initElements(driver, this);
	}

	//Generic click function
	public void clickElement(WebElement element)
	{
		element.click();
	}
	
	//Generic set value function
	public void sendValueToElement(WebElement element, String str)
	{
		element.sendKeys(str);
	}
	
	
	
	
	

	///////Methods//////////
	public void clickMyProductBTN()
	{
		myProductBTN.click();
	}

	public void clickNewProductBTN()
	{
		newProductBTN.click();
	}

	public void setProductNameTB(String productName)
	{
		productNameBTN.sendKeys(productName);
	}

	public void setcategoryTB(String category) throws InterruptedException
	{
		categoryTB.click();
		Thread.sleep(2 * 1000);	
		Browsers.getDriver().findElement(By.id("categories")).sendKeys(category);
		Thread.sleep(2 * 1000);	
		Browsers.getDriver().findElement(By.id("categories")).sendKeys(Keys.ENTER);		
	}

	public void setAttributeTB(String attribute) throws InterruptedException
	{
		attributeTB.click();
		Thread.sleep(1 * 1000);	
		Browsers.getDriver().findElement(By.id("tags")).sendKeys(attribute);
		Thread.sleep(1 * 1000);	
		Browsers.getDriver().findElement(By.id("tags")).sendKeys(Keys.ENTER);	
		Thread.sleep(1 * 1000);	
		Browsers.getDriver().findElement(By.id("tags")).sendKeys("Organic");
		Thread.sleep(1 * 1000);	
		Browsers.getDriver().findElement(By.id("tags")).sendKeys(Keys.ENTER);
		Thread.sleep(1 * 1000);	
		Browsers.getDriver().findElement(By.id("tags")).sendKeys("Dairy Free");
		Thread.sleep(1 * 1000);	
		Browsers.getDriver().findElement(By.id("tags")).sendKeys(Keys.ENTER);
	}

	public void setDescriptionTB()
	{
		descriptionTB.sendKeys("Text Text Text Text Text Text Text Text Text Text Text Text ");
	}

	public void setUnitSizeTB()
	{
		unitSizeTB.sendKeys("11.15");
	}

	public void setShelfLifeTB()
	{
		unitLifeTB.sendKeys("24");
	}
	public void setDepositRB()
	{
		//depositRB.sendKeys("true");
		depositRB.click();
	}
	public void setUnitPerCaseTB()
	{
		unitPerCaseTB.sendKeys("5");
	}

	public void setSrpTBTB()
	{
		srpTB.sendKeys("25");
	}

	public void setInventoryTB()
	{
		inventoryTB.sendKeys("100");
	}

	public void clickSaveBTN()
	{
		saveBTN.click();
	}

	public void setLengthTB()
	{
		lengthTB.sendKeys("4");
	}

	public void setWidthTB()
	{
		widthTB.sendKeys("14");
	}

	public void setHeightTB()
	{
		heightTB.sendKeys("20");
	}

	public void setWeightTB()
	{
		weightTB.sendKeys("1.5");
	}

	public void setUPCTB() throws InterruptedException
	{
		upcTB.sendKeys("123456789012");
		Thread.sleep(1 * 1000);
		upcAddBTN.click();
	}

	public boolean ifUPCadded()
	{
		boolean flag;
		try 
		{
			upcAddedLBL.isDisplayed();
			flag = true;
		}
		catch (Exception e) {
			flag = false;
		}
		return flag;
	}

	public void clickSavePackagingBTN()
	{
		savePackagingBTN.click();
	}

	//Pack Option
	public void clickAddNewCaseBTN()
	{
		addNewCaseBTN.click();
	}

	public void setTotalWightTB()
	{
		totalWightTB.sendKeys("7.8");
	}

	public void setcostPerCaseTB ()
	{
		costPerCaseTB.sendKeys("20");
	}

	public void setOuterLengthTB ()
	{
		outerLengthTB.sendKeys("20.1");
	}

	public void setOuterWidthTB()
	{
		outerWidthTB.sendKeys("14.1");
	}

	public void setOuterHeightTB()
	{
		OuterHeightTB.sendKeys("20.1");
	}

	//Click Calculate BTN
	public void clickCalculateBTN()
	{
		calculateBTN.click();
	}

	public boolean verifyCalcGM()
	{
		if(calculatedGMLBL.getText() == "Gross Margin OK")
		{
			return true;
		}
		return false;
	}

	public void clickSavePackOptionBTN()
	{
		savePackOptionBTN.click();
	}

	public void clickNewCaseBTN()
	{
		newCaseBTN.click();
	}

	public boolean verifyCaseAdded()
	{
		if(editCaseBTN.isDisplayed())
		{
			return true;
		}
		return false;
	}

	public void clickSavePackOptionPageBTN()
	{
		savePackOptionPageBTN.click();
	}

	public void sendPathToUpload()
	{
		fileUploadeBTN.sendKeys("C:\\Users\\yossico\\Pictures\\Shelfmint\\cocoa.jpg");
	}

	public void clickFrontImageRB()
	{
		frontImage.click();
	}

	public void clickBackImageRB()
	{
		backImage.click();
	}

	public void clickLabelImageRB()
	{
		labelImage.click();
	}

	public void clickOtherImageRB()
	{
		otherImage.click();
	}

	public void clickOKBTN()
	{
		OKBTN.click();
	}


	//@SuppressWarnings("deprecation")
	public void setTargetCustomer() throws InterruptedException
	{		
		targetCustomer.click();						
		Thread.sleep(2 * 1000);
		Actions builder = new Actions(Browsers.getDriver());			
		builder.moveToElement(Browsers.getDriver().findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Target Customers'])[1]/following::div[5]/input")));		
		builder.sendKeys("kids");
		builder.pause(2*1000);
		builder.sendKeys(Keys.ENTER);
		builder.perform();		
	}

	//@SuppressWarnings("deprecation")
	public void setSuperMarket() throws InterruptedException
	{		
		supermarket.click();
		Thread.sleep(2 * 1000);
		Actions builder = new Actions(Browsers.getDriver());			
		builder.moveToElement(Browsers.getDriver().findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Supermarkets, groceries and etc.'])[1]/following::div[5]/input")));		
		builder.sendKeys("Amazon");
		builder.pause(2*1000);
		builder.sendKeys(Keys.ENTER);
		builder.perform();			
	}

	public void clickSaveMarketingBTN()
	{
		saveMarketingBTN.click();
	}

	public void clickFinishBTN()
	{
		finishBTN.click();
	}

	public void clickMyOrderBTN()
	{
		myOrderBTN.click();
	}

	public List<WebElement> getAllProducts()
	{
		return allProducts;
	}

	public void clickActionFirstProduct()
	{
		actionFirstProduct.click();
	}

	public void clickAddSimilarProduct()
	{
		addSimilarBTN.click();
	}

	public int areAllFieldsClear(String element)
	{
		int i = 0;
		List<WebElement> myFields = Browsers.getDriver().findElements(By.xpath(element));
		for (WebElement input : myFields) 
		{
			if(input.getAttribute("value") != "")
			{
				i++;
				System.out.println(input.getAttribute("value"));
			}	    
		}
		return i;
	}

	public boolean ifHaveOrderConfirmation()
	{
		for (WebElement status : allOrdersStatuses) 
		{
			if(status.getText().equalsIgnoreCase("Awaiting Confirmation"))
			{
				status.click();
				return true;
			}		
		}
		return false;
	}
	
	public void clickConfirmOrderBTN()
	{
		confirmOrderBTN.click();
	}
	
	public String getOrderNumFromConfirmationPage()
	{
		return OrderNumberConfirmationPageLBL.getText();
	}

	////////Add New Carton////////
	//click my carton
	public void clickMyCartonBTN()
	{
		clickElement(myCartoBTN);
	}
	
	//Click Add new carton
	public void clickAddNewCartonBTN()
	{
		clickElement(addNewCartonBTN);
	}
	
	//Set carton values
	public void setCartonValues()
	{
		sendValueToElement(cartonNameTB, "MyCarton");
		sendValueToElement(cartoLengthTB, "12");
		sendValueToElement(cartoWidthTB, "12");
		sendValueToElement(cartonHeightTB, "12");
		sendValueToElement(cartonMaxLoadTB, "12");
		sendValueToElement(cartonWeightTB, "10");
	}
	
	//Click Add new carton - Finish
	public void clickAddNewCartonFinishBTN()
	{
		clickElement(addNewCartonFinishBTN);
	}
	////////End - Add New Carton////////
	
	//Change my orders filters	
	public void setAllFilters()
	{
		myOrderFilterBTN.click();
		myOrderFilterOneBTN.click();
		myOrderFilterThreeBTN.click();
		myOrderFilterFourBTN.click();
		myOrderFilterBTN.click();
	}
	
	public List<WebElement> getAllOrders()
	{
		return allOrders;
	}
	
	//Click Shipping label BTN
	public void clickShippingLabelBTN()
	{
		shippingLabelBTN.click();
	}
	
	public List<WebElement> getShippingLabelSpinner()
	{
		return shippingLabelSpinner;
	}
	
	public List<WebElement> getAllShippigLabelsErrorAlert()
	{
		return shippigLabelsErrorAlert;
	}
	
	//Click Shipping label BTN
	public void clickConfirmOrderCB()
	{
		confirmOrderCB.click();
	}
	
	//Click Shipping label BTN
	public void clickConfirmOrderPopUpBTN()
	{
		confirmOrderPopUpBTN.click();
	}
	
	//Click secondConfirmOrderBTN
	public void clicksecondConfirmOrderBTN()
	{
		secondConfirmOrderBTN.click();
	}
	
	public String waitForPleaseWaitAlertLBL()
	{
		return pleaseWaitAlertLBL.getText();
	}
}
