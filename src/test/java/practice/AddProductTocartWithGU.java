package practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import genericUtilities.FileUtility;
import genericUtilities.JavaUtility;
import genericUtilities.SeleniumUtility;
import objectRepository.LoginPage;

public class AddProductTocartWithGU {

	public static void main(String[] args) throws IOException {
		
		//Create Object of all Utilities
		FileUtility fUtil = new FileUtility();
		JavaUtility jUtil = new JavaUtility();
		SeleniumUtility sUtil = new SeleniumUtility();

		// Read common Data
		String URL = fUtil.readDataFromPropertyfile("url");
		String USERNAME = fUtil.readDataFromPropertyfile("username");
		String PASSWORD = fUtil.readDataFromPropertyfile("password");

		// Read Data from excel file
		String PRODUCTNAME = fUtil.readDataFromExcel("Products", 1, 2); // Run time data

		// Launch the browser
		WebDriver driver = new EdgeDriver();
		sUtil.maximizeWindow(driver);
		sUtil.addImplicitlyWait(driver);

		// Load the URL
		driver.get(URL);

		// Login to Application
//		driver.findElement(By.id("user-name")).sendKeys(USERNAME);
//		driver.findElement(By.id("password")).sendKeys(PASSWORD);
//		driver.findElement(By.id("login-button")).click();
		
		LoginPage lp = new LoginPage(driver);
//		lp.getUsernameText().sendKeys(USERNAME);
//		lp.getPasswordText().sendKeys(PASSWORD);
//		lp.getLoginBtn().click();
		
		lp.loginToApp(USERNAME, PASSWORD);
		

		// Click on a product - Tshirt - Dynamic xpath
		WebElement ele = driver.findElement(By.xpath("//div[.='" + PRODUCTNAME + "']"));
		String productname = ele.getText();
		ele.click();

		// Click on add to cart
		driver.findElement(By.id("add-to-cart")).click();
		
		//Capture screenshot
		String screenshotName = "addProductToCart-"+jUtil.getSystemDate();
		String path = sUtil.captureScreenShot(driver, screenshotName);
		System.out.println(path);

		// Navigate to Cart
		driver.findElement(By.id("shopping_cart_container")).click();

		// Validate the product in Cart
		String productIncart = driver.findElement(By.className("inventory_item_name")).getText();
		if (productIncart.equals(productname)) {
			System.out.println("PASS");
			System.out.println(productIncart);
		} else {
			System.out.println("FAIL");
		}

		// Logout of Application
		driver.findElement(By.id("react-burger-menu-btn")).click();
		driver.findElement(By.linkText("Logout")).click();
	}

}
