package utility;

public class GetPropertyUtil {

	private static String browser;
	private static String baseURL;
	private static String email;
	private static String pass;	
	private static String adminURL;	
	private static String retailerEmail;
	private static String brandEmail;
	static String path = System.getProperty("user.dir");
	
	public GetPropertyUtil()
	{
		PropertyUtil pus = new PropertyUtil(path + "\\selenium.properties");
		baseURL = pus.getProperty("url");
		browser = pus.getProperty("Browser");
		email = pus.getProperty("Email");		
		pass = pus.getProperty("Pass");
		adminURL = pus.getProperty("AdminURL");
		retailerEmail = pus.getProperty("RetailerEmail");
		brandEmail = pus.getProperty("BrandEmail");
	}
	
	public static String getBrandEmail() {
		return brandEmail;
	}

	public static void setBrandEmail(String brandEmail) {
		GetPropertyUtil.brandEmail = brandEmail;
	}

	public String getBrowser() {
		return browser;
	}

	public static void setBrowser(String browser) {
		GetPropertyUtil.browser = browser;
	}

	public String getBaseURL() {
		return baseURL;
	}

	public static void setBaseURL(String baseURL) {
		GetPropertyUtil.baseURL = baseURL;
	}

	public String getEmail() {
		return email;
	}

	public static void setEmail(String email) {
		GetPropertyUtil.email = email;
	}

	public String getPass() {
		return pass;
	}

	public static void setPass(String pass) {
		GetPropertyUtil.pass = pass;
	}
	
	public String getAdminURL() {
		return adminURL;
	}

	public static void setAdminURL(String adminURL) {
		GetPropertyUtil.adminURL = adminURL;
	}
	
	public String getRetailerEMAIL() {
		return retailerEmail;
	}

	public static void setRetailerEMAIL(String retailerEmail) {
		GetPropertyUtil.retailerEmail = retailerEmail;
	}

	

}
