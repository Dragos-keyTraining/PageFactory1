package runner;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.google.common.io.Files;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import pages.BasePage;
import utils.*;

@CucumberOptions(tags="",
features="src/test/resources/features",
glue="tests")

public class TestRunner extends AbstractTestNGCucumberTests {

	public static WebDriver driver;
	public BasePage app;
	
	@Parameters({"browser"})
	@BeforeClass()
	public void setup(String browser) throws MalformedURLException {
	//	System.setProperty("webdriver.chrome.driver", "path catre/chromedriver.exe")
	//	System.setProperty("webdriver.edge.driver", "path catre/chromedriver.exe")
	//	System.setProperty("webdriver.gecko.driver", "path catre/chromedriver.exe")

		//driver = new ChromeDriver();
		
		driver = Driver.initDriver(browser);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();//maximizeaza fereastra browserului
		driver.get("https://keyfood.ro/");
		app = new BasePage(driver);
	}
	
	@AfterClass
	public void teardown() throws InterruptedException {
		Thread.sleep(4000);//bad practice
		
		driver.quit();//inchide tot browserul cu toate taburile
	}
	
	@AfterMethod
	public void recordFailure(ITestResult result) {
		
		if(result.getStatus() == ITestResult.FAILURE) {
			//ScreenShots.screenShot(driver);
	
			TakesScreenshot tks =  (TakesScreenshot)driver;
			File picture = tks.getScreenshotAs(OutputType.FILE);
			String timestamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());

		 try {
			 Files.copy(picture, new File("screenshots/"+result.getName()+ " - " +timestamp+ ".png"));
		 }catch(IOException e) {
			 Log.error("Picture could not be saved!");
			 Log.error(e.getMessage());
		 }
			
		
		}
		
		
	}
	
	
}
