package utils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.google.common.io.Files;

public class ScreenShots {
	
	public static void screenShot(WebDriver driver) {
		
		TakesScreenshot tks =  (TakesScreenshot)driver;
		File picture = tks.getScreenshotAs(OutputType.FILE);
		String timestamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());

	 try {
		 Files.copy(picture, new File("screenshots/screen "+timestamp+ ".png"));
	 }catch(IOException e) {
		 Log.error("Picture could not be saved!");
		 Log.error(e.getMessage());
	 }
		
	}
	
		
	
	

}
