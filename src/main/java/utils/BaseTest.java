package utils;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import pages.BasePage;

public class BaseTest {
	
	public WebDriver driver;
	public BasePage app;
	
	@BeforeMethod()
	public void setup() {
		//System.setProperty("webdriver.chrome.driver", "path catre/chromedriver.exe")
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();//maximizeaza fereastra browserului
		driver.get("https://keyfood.ro/");
		app = new BasePage(driver);
	}
	
	@AfterMethod
	public void teardown() throws InterruptedException {
		Thread.sleep(4000);//bad practice
		
		driver.quit();//inchide tot browserul cu toate taburile
	}	
}
