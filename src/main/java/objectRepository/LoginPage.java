package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

public class LoginPage { //Rule 1
	
	//Rule 2 - Declaration
	//@FindAll - Identify single web-element thru multiple locators
	//OR - operator - Auto-healing process
	@FindAll({@FindBy(id = "user-name"),@FindBy(xpath = "//input[@name='user-name']")})
	private WebElement usernameText1;
	
	//@FindBys - Identify single WebElement thru multiple locators
	//AND operators
	@FindBys({@FindBy(id = "user-name"),@FindBy(xpath = "//input[@name='user-name']")})
	private WebElement usernameText2;
	
	@FindBy(id = "user-name") 
	private WebElement usernameText;
	
	@FindBy(name = "password")
	private WebElement passwordText;
	
	@FindBy(id = "login-button")
	private WebElement loginBtn;
	
	//Rule 3 - Initialization
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	//Rule 4 - Utilization
	public WebElement getUsernameText() {
		return usernameText;
	}

	public WebElement getPasswordText() {
		return passwordText;
	}

	public WebElement getLoginBtn() {
		return loginBtn;
	}
	
	//Business Librray - Optimizing - generic methods
	
	/**
	 * This method will perform Login Operation
	 * @param un
	 * @param pwd
	 */
	public void loginToApp(String un,String pwd)
	{
		usernameText.sendKeys(un);
		passwordText.sendKeys(pwd);
		loginBtn.click();
	}
	
	
	
	
	
	
	

}
