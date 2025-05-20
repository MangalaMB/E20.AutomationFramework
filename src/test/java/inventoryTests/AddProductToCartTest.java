package inventoryTests;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import genericUtilities.BaseClass;
import genericUtilities.FileUtility;
import genericUtilities.JavaUtility;
import genericUtilities.SeleniumUtility;
import objectRepository.CartPage;
import objectRepository.InventoryItemPage;
import objectRepository.InventoryPage;
import objectRepository.LoginPage;

@Listeners(genericUtilities.ListenersImplementation.class)
public class AddProductToCartTest extends BaseClass{

	@Test(groups = "SmokeSuite")
	public void tc_01_AddProductToCartTest() throws IOException
	{
		
		// Read Data from excel file
		String PRODUCTNAME = fUtil.readDataFromExcel("Products", 1, 2); // Run time data

		// Click on a product 
		InventoryPage ip = new InventoryPage(driver);
		ip.clickOnAProduct(driver, PRODUCTNAME);

		// Click on add to cart
		InventoryItemPage iip = new InventoryItemPage(driver);
		iip.clickOnAddToCatBtn();

		// Navigate to Cart
		ip.clickOnCartContainer();
		
		// Validate the product in Cart
		CartPage cp = new CartPage(driver);
		String ProductIncart = cp.captureItemName();
		
		Assert.assertEquals(ProductIncart, PRODUCTNAME);
		
		Assert.assertTrue(ProductIncart.equals(PRODUCTNAME));
		System.out.println(ProductIncart);
		
	}
	
	@Test
	public void sampleTest()
	{
		
		System.out.println("Sample");
	}

}
