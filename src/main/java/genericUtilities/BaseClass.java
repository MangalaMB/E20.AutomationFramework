package genericUtilities;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import objectRepository.InventoryPage;
import objectRepository.LoginPage;

/**
 * This class consists of Basic configuration annotations of Testng
 * 
 * @author Chaitra M
 *
 */
public class BaseClass {

	public JavaUtility jUtil = new JavaUtility();
	public SeleniumUtility sUtil = new SeleniumUtility();
	public FileUtility fUtil = new FileUtility();

	public WebDriver driver;

	//For Listeners
	public static WebDriver sdriver;

	@BeforeSuite(alwaysRun = true)
	public void bsConfig() {
		System.out.println("------- Database Connection successful -------");
	}

	// @Parameters("browser")
	// @BeforeTest
	@BeforeClass(alwaysRun = true)

	public void bcConfig(/* String PValue */) throws IOException {
		String URL = fUtil.readDataFromPropertyfile("url");

		driver = new FirefoxDriver();

		// For Cross Browser execution - "Run time Polymorphism - driver"
//		if(PValue.equals("edge"))
//		{
//			driver = new EdgeDriver();
//		}
//		else if(PValue.equals("firefox"))
//		{
//			driver = new FirefoxDriver();
//		}
//		else
//		{
//			driver = new EdgeDriver();
//		}

		sUtil.maximizeWindow(driver);
		sUtil.addImplicitlyWait(driver);

		driver.get(URL);

		// for Listeners
		sdriver = driver;

		System.out.println("------- Browser Launch successful -------");
	}

	@BeforeMethod(alwaysRun = true)
	public void bmConfig() throws IOException {
		String USERNAME = fUtil.readDataFromPropertyfile("username");
		String PASSWORD = fUtil.readDataFromPropertyfile("password");

		LoginPage lp = new LoginPage(driver);
		lp.loginToApp(USERNAME, PASSWORD);

		System.out.println("------- Login to App successful -------");
	}

	@AfterMethod(alwaysRun = true)
	public void amConfig() {
		InventoryPage ip = new InventoryPage(driver);
		ip.logoutOfApp();

		System.out.println("------- Logout of App successful -------");
	}

	// @AfterTest
	@AfterClass(alwaysRun = true)
	public void acConfig() {
		driver.quit();

		System.out.println("------- Browser closure successful -------");
	}

	@AfterSuite(alwaysRun = true)
	public void asConfig() {
		System.out.println("------- Database closure successful -------");
	}
}
