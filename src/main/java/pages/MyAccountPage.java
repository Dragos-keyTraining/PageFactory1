package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.SeleniumWrappers;

public class MyAccountPage extends SeleniumWrappers{

	public MyAccountPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="username") 
	public WebElement usernameField;
	
	@FindBy(id="password")
	public WebElement passwordField;
	
	@FindBy(name="login")
	public WebElement signInButton;
	
	@FindBy(css="div[class='woocommerce-MyAccount-content']")
	public WebElement greetingsMessage;
	
	@FindBy(css="ul[class='woocommerce-error']")
	public WebElement loginErrorMsg;
	
	@FindBy(linkText = "Log out")
	public WebElement logOutButton;

	
	public void loginInApp(String user, String pass) {
		sendKeys(usernameField, user);
		sendKeys(passwordField, pass);
		click(signInButton);
	}
	
	
	
}
