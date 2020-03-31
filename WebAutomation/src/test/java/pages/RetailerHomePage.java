package pages;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import core.Browsers;

public class RetailerHomePage {
	//private WebDriver driver;
	
	//HomePage -  New Productsbutton
	@FindBy(xpath = "(//a[contains(text(),'Shop Now')])[1]")
	public static WebElement newProductBtn;

	//HomePage -  New veganbtn button
	@FindBy(xpath = "(//a[contains(text(),'Shop Now')])[7]")
	public static WebElement veganBtn;

	//HomePage -  New organicnBtn button
	@FindBy(xpath = "(//a[contains(text(),'Shop Now')])[2]")
	public static WebElement organicnBtn;

	//HomePage -  New KosherBtn button
	@FindBy(xpath = "(//a[contains(text(),'Shop Now')])[3]")
	public static WebElement kosherBtn;

	//HomePage -  New LocalBtn button
	@FindBy(xpath = "(//a[contains(text(),'Shop Now')])[5]")
	public static WebElement localBtn;

	//HomePage -  New ketogenicBtn button
	@FindBy(xpath = "(//a[contains(text(),'Shop Now')])[8]")
	public static WebElement ketogenicBtn;

	//HomePage -  New glutenFreeBtn button
	@FindBy(xpath = "(//a[contains(text(),'Shop Now')])[4]")
	public static WebElement glutenFreeBtn;

	//HomePage -  New hotListBtn button
	@FindBy(xpath = "(//a[contains(text(),'Shop Now')])[6]")
	public static WebElement hotListBtn;

	//HomePage -  New topBtn button
	@FindBy(xpath = "(//a[contains(text(),'Shop Now')])[9]")
	public static WebElement topBtn;
	
	//MOV for first product 
	@FindBy(xpath = "//div[2]/div/button")
	public static List<WebElement> firstProductMov;
	
	//first product quantity input
	@FindBy(xpath = "//div/div/input")
	public static WebElement firstProductQuantity;
	
	//First Product  (Change first div's number to pointing different products)
	@FindBy(xpath = "(.//*[normalize-space(text()) and normalize-space(.)='No more items in the inventory'])[1]/following::button[1]")
	public static WebElement addToCartBTN;

	//Proceed to checkout button
	@FindBy(xpath = "//div[2]/div/button")
	public static WebElement proceedToCheckoutBTN;

	//Pay with your account  
	@FindBy(xpath = "(.//*[normalize-space(text()) and normalize-space(.)='Choose payment method:'])[1]/following::button[1]")
	public static WebElement payWithYourAccountBTN;

	//Done BTN   
	@FindBy(css = "button.btn.m-btn--pill.btn--super-wide.btn-block.btn-success")
	public static WebElement doneBTN;
	
	//First Item
	@FindBy(xpath = "//a/div/div")
	public static WebElement firstItem;
		
	//SRP for first product   
	@FindBy(xpath = "(.//*[normalize-space(text()) and normalize-space(.)='SRP'])[1]/preceding::span[1]")
	public static WebElement srpFirst;
	
	//All products  
	@FindBy(xpath = "//div[@class='d-flex flex-row flex-wrap col-product justify-content-center']")
	public static List<WebElement> allProductC;
	
	//All Add to Cart buttons  
	@FindBy(xpath = "//div[@class='d-flex']/div/button")
	public static List<WebElement> allAddToCartBTN;
		
	//Order Number 
	@FindBy(xpath = "(.//*[normalize-space(text()) and normalize-space(.)='Invoice Confirmation'])[1]/following::h1[1]")
	public static WebElement orderNumbrLBL;
		
	//Close cart preview
	@FindBy(xpath = "(.//*[normalize-space(text()) and normalize-space(.)='My Cart'])[1]/following::a[1]")
	public  WebElement closeCartBTN;
	
	//Next Page BTN
	@FindBy(xpath = "//*[@id='root']/div/div/div/div/div/div/div/div/div/div[3]/div/div/div/a[2]")
	public  WebElement nextPageBTN;
		
	//All products name 
	@FindBy(xpath = "//h6")
	public static List<WebElement> allProductsName;
	
	//cart icon
	@FindBy(xpath = "//*[@id=\"root\"]/div/header/div[1]/div/div/div/div[3]/ul/li[1]")
	public static WebElement cartIconBTN;
	
	//cart total
	@FindBy(xpath = "//h2/span")
	public static WebElement cartTotalLBL;	
	
	//cart  total
	@FindBy(css = "h4.m-0 > span")
	public static WebElement previewTotalLBL;
	
	//MOV in Cart
	@FindBy(xpath = "//*[contains(text(), 'This brand has a minimum')]")
	public static List<WebElement> cartMOV;
	
	//MyCart css - find all  brands in cart
	@FindBy(css = "MyCart")
	public static WebElement allBrandInCart;
	
	//MyCart css - find all  MOV Alert
	@FindBy(xpath = "//div[contains(@class, 'MyCart') and contains(.//span, 'someText')]")
	public static WebElement movAlert;
	
	//Personal info icon
	@FindBy(xpath = "//div[@id='root']/div/header/div/div/div/div/div[3]/ul/li[2]/div/span/span/i")
	public static WebElement infoBTN;
		
	//Personal info in menu  
	@FindBy(xpath = "//div[@id='root']/div/header/div/div/div/div/div[3]/ul/li[2]/div[2]/div/div[2]/div/ul/li[3]/a/span/span/span")
	public static WebElement infoMenuBTN;
	
	//Personal info firstName
	@FindBy(xpath = "//input[contains(@class , 'form-control')]")
	public static List<WebElement> personalInfoData;
	
	//Personal info email
	@FindBy(name = "email")
	public static WebElement personalInfoMailLbl;
	
	//Personal info save BTN
	@FindBy(xpath = "//button[2]")
	public static WebElement personalInfoSaveBTN;
	
	//Error alert
	@FindBy(xpath = "//button[2]")
	public static List<WebElement> errorAlert;
	
	@FindBy(xpath = "//*[@id=\"react-select-2--value\"]/div[1]")
	public static WebElement searchTBClick; 
	
	@FindBy(xpath = "//*[@id=\"state-select\"]")
	public static WebElement searchTB;
	
	//button
	@FindBy(xpath = "//button")
	public static WebElement searchBTN;
	
	//button
	@FindBy(id = "exampleModalLabel")
	public static WebElement movAlertPopUp;
	
	//Personal info icon
	@FindBy(xpath = "(.//*[normalize-space(text()) and normalize-space(.)='Section'])[1]/following::span[3]")
	public static WebElement myOrderBTN ;
		
	//My Order View details btn
	@FindBy(xpath = "//div[@id='root']/div/div/div/div/div[2]/div/div/div/div[3]/div/div/div/table/tbody/tr/td[7]/span/span/span")
	public static List<WebElement> viewDetailsBTN;
	
	//My order - total
	@FindBy(xpath = "//div[2]/p/span")
	public static WebElement myOrderTotalLBL;
	
	//My order - Back btn
	@FindBy(xpath = "//div[2]/div[2]/span")
	public static WebElement myOrderBackBTN;
	
	/*
	public static WebElement ;
	@FindBy(xpath = "")
	public static WebElement ;
	*/
	
	
	//Constructor
	public RetailerHomePage(WebDriver driver)
	{
		//this.driver=driver;

		//Initialise Elements
		PageFactory.initElements(driver, this);
	}

	public void clickNewProductbtn()
	{
		newProductBtn.click();
	}

	public void clickVeganbtn()
	{
		veganBtn.click();
	}

	public void clickKosherBtn()
	{
		kosherBtn.click();
	}

	public void clickOrganicnBtn()
	{
		organicnBtn.click();
	}

	public void clickLocalBtn()
	{
		localBtn.click();
	}	

	public void clickKetogenicBtn()
	{
		ketogenicBtn.click();
	}

	public void clickGlutenFreeBtn()
	{
		glutenFreeBtn.click();
	}

	public void clickHotListBtn()
	{
		hotListBtn.click();
	}

	public void clicktopBtn()
	{
		topBtn.click();
	}

	public void clicAddToCartBTN()
	{
		addToCartBTN.click();
	}

	public void clickProceedToCheckoutBTN()
	{
		proceedToCheckoutBTN.click();
	}

	public void clickPayWithYourAccountBTN()
	{
		payWithYourAccountBTN.click();
	}
	public void clickDoneBTN()
	{
		doneBTN.click();
	}
		
	public String getSRPFirst()
	{
		return srpFirst.getText();
	}	
	
	public void clickFirstItem()
	{
		firstItem.click();
	}
	
	public void clickMenuRandomly()
	{
		Random rand = new Random();

		// nextInt as provided by Random is exclusive of the top value so you need to add 1 
		int randomNum = rand.nextInt((6 - 2) + 1) + 2;
		Browsers.getDriver().findElement(By.xpath("(//a[contains(text(),'Shop Now')])["+randomNum+"]")).click();
		System.out.println("The number is: " + randomNum );
	}
	
	public int getProductCount()
	{
		return allProductC.size();
	}
	
	public List<WebElement> getProductsElements()
	{
		return allProductC;
	}
	
	public List<WebElement> getAllAddToCartBTN()
	{
		return allAddToCartBTN;
	}
	
	public String getOrderNumberLBL()
	{
		return orderNumbrLBL.getText();
	}
		
	public void clickCloseCart()
	{
		closeCartBTN.click();
	}
	
	public void clickNextPage()
	{
		nextPageBTN.click();
	}
	
	public List<WebElement> getAllProductsName()
	{
		return allProductsName;
	}
	
	public void clickCartIcon()
	{
		cartIconBTN.click();
	}
	
	public String getTotalCart()
	{
		return cartTotalLBL.getText();
	}
	
	public String getPreviewTotal()
	{
		return previewTotalLBL.getText();
	}
	
	public boolean checkIMOVExistInFirstProduct()
	{
		if(firstProductMov.size()>0)
		{
			return true;
		}
		return false;
	}
	
	public void firstProductChangeQuantity()
	{
		firstProductQuantity.clear();
		firstProductQuantity.sendKeys("10");
		
	}
	
	public boolean ifMOVExistInCart() {
		System.out.println("MOV show " + cartMOV.size() + "Time");
	    return cartMOV.size() > 0;
	}	
	
	public void getPersonalInfo()
	{
		infoBTN.click();
		infoMenuBTN.click();		
	}
	
	public void getMyOrders()
	{
		infoBTN.click();
		myOrderBTN.click();		
	}
	
	public List<WebElement> getpersonalDataInput()
	{
		return personalInfoData;
	}
	
	public void searchProduct()
	{
		searchTBClick.click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		searchTB.sendKeys("Now Food");
		searchBTN.click();		
	}
	
	public boolean movPopUpShow()
	{
		if(movAlertPopUp.isDisplayed())
			return true;
		return false;
	}
	
	public List<WebElement> getViewDetailsBTNs()
	{
		return viewDetailsBTN;
	}
	
	public String getOrderTotalLBL()
	{
		return myOrderTotalLBL.getText();
	}
	
	public void clickMyOrderBackBTN()
	{
		myOrderBackBTN.click();
	}
	
	public void clickPersonalInfoSaveBTN()
	{
		personalInfoSaveBTN.click();
	}
	
	public List<WebElement> getErrorAlert()
	{
		return errorAlert;
	}	
	
	public void setPersonalInfoMailLbl(String mail)
	{
		personalInfoMailLbl.clear();
		personalInfoMailLbl.sendKeys(mail);
	}
}
