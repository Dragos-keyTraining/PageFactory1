package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.SeleniumWrappers;

public class MenuPage extends SeleniumWrappers {

	public MenuPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	/* public By myAccountLink = By.linkText("My account");
	 * 
	 * myAccountLink --> locator
	 * 
	 * driver.findElement(myAccountLink) --> WebElement
	 * 
	 */
	
	@FindBy(linkText = "My account") public WebElement myAccountLink;
}
