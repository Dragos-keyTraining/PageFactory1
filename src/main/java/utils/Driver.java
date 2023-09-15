package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class Driver {
	
	//avem nevoie pentru rularea in paralel a testelor
	public static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
	//public WebDriver driver;
	
	public WebDriver initDriver(String browser) {
		
		if(browser.equalsIgnoreCase("chrome")) {
			
			driver.set(new ChromeDriver(getChromeOptions()));
			
			long chromeId = Thread.currentThread().getId();
			Log.info("Chrome --> Thread id : " + chromeId);
			
			return driver.get();
			
		}else if(browser.equalsIgnoreCase("edge")) {
			
			driver.set(new EdgeDriver(getEdgeOptions()));
			
			long edgeId = Thread.currentThread().getId();
			Log.info("Edge --> Thread id : " + edgeId);
			
			return driver.get();
			
		} else if(browser.equalsIgnoreCase("firefox")) {
			
			driver.set(new FirefoxDriver(getFirefoxOptions()));
			
			long firefoxID = Thread.currentThread().getId();
			Log.info("Firefox --> Thread id : " + firefoxID);
			return driver.get();
		}
		
		return null;
		
	}
	
	
	public static ChromeOptions getChromeOptions() {
		ChromeOptions chromeOptions =  new ChromeOptions();
		//chromeOptions.addArguments("--headless");
		//chromeOptions.addArguments("--window-size=1580,1280");
		return chromeOptions;
	}
	
	public static EdgeOptions getEdgeOptions() {
		EdgeOptions edgeOptions =  new EdgeOptions();
		//edgeOptions.addArguments("--headless");
		//edgeOptions.addArguments("--window-size=1580,1280");	
		return edgeOptions;
	}

	public static FirefoxOptions getFirefoxOptions() {
		FirefoxBinary firefoxBinary = new FirefoxBinary();
		//firefoxBinary.addCommandLineOptions("--headless");
		FirefoxOptions firefoxOptions = new FirefoxOptions();
		firefoxOptions.setBinary(firefoxBinary);
		return firefoxOptions;
		
	}
	
}
