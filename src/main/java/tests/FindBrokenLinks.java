package tests;

import static org.testng.Assert.assertTrue;

import java.io.FileWriter;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import utils.BaseTest;

public class FindBrokenLinks extends BaseTest{
	
	static List<String> brokenLinks =  new ArrayList<String>();
	
	@Test
	public void testBrokenLinks() throws IOException {
		
		List<WebElement> links = driver.findElements(By.cssSelector("a[href*='http']"));
		
		System.out.println("Total links: " + links.size());
		
		
		for(int i=0; i<links.size(); i++) {
			
			WebElement element = links.get(i);
			String url = element.getAttribute("href");
			updateFile(url);
			
			if(url == null) {
				continue;
			}
			checkLinks(url);
			
		}
		
		assertTrue(brokenLinks.size() == 0);
		
		
		
	}
	
	public static void checkLinks(String linkURL) throws IOException {
		
		try {
			URL url = new URL(linkURL);
			HttpURLConnection httpConnect = (HttpURLConnection) url.openConnection();
			httpConnect.setConnectTimeout(3000);
			httpConnect.connect();
			
			if(httpConnect.getResponseCode() == 200) {
				System.out.println(linkURL + " = " + httpConnect.getResponseCode());
			}
			if(httpConnect.getResponseCode() == httpConnect.HTTP_NOT_FOUND) {
				
				System.out.println(linkURL + " = " + httpConnect.getResponseCode());
				brokenLinks.add(linkURL);			}
			
			
		}catch(MalformedURLException e) {
			e.printStackTrace();
		}
	
	}

	public static void updateFile(String textToAdd) {
		try (FileWriter fileWriter = new FileWriter("Links.txt", true)){
			fileWriter.write(textToAdd+"\n");
		}catch(IOException e) {
			e.printStackTrace();
		}	
	}
	
	
	
}
