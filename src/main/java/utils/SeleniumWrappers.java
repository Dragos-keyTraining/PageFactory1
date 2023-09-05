package utils;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumWrappers extends BaseTest {

	public SeleniumWrappers(WebDriver driver) {
		this.driver = driver;
	}
	
	
	//webelement.click();
	
	public void click(WebElement element) {
		System.out.println("Called method<click> on  " );
		try {
			WebDriverWait wait =  new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(element));
			element.click();
			
		}catch(StaleElementReferenceException e) {
			
			WebDriverWait wait =  new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.stalenessOf(element));
			element.click();

		}catch(NoSuchElementException e) {
			System.out.println(e.getMessage());
	
		}
		
	}
	
	public void sendKeys(WebElement element, String text) {
		System.err.println("called method <sendKeys> on locator ");
		try {
			//WebElement element = driver.findElement(locator);
			waitForElementToBeVisible(element);
			element.clear();
			element.sendKeys(text);
			
		}catch (Exception e) {
			System.out.println(e.getMessage());	
		}
		
	}
	
	
	public void waitForElementToBeVisible(WebElement element) {
		System.out.println("Called method <waitForElementToBeVisible> on locator :");
		try {
			WebDriverWait wait =  new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.visibilityOf(element));

		}catch(NoSuchElementException e) {
			System.out.println(e.getMessage());
		}
	}
	
	
	
	public WebElement returnWebElement(By locator) {
		return driver.findElement(locator);
	}
	
	
	public boolean checkElementIsDisplayed(WebElement element) {
		return element.isDisplayed();
	}
	
}
