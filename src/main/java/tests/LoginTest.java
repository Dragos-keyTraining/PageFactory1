package tests;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import utils.BaseTest;
import utils.ScreenShots;
import utils.TestNgListener;

//@Listeners(TestNgListener.class)
public class LoginTest  extends BaseTest{

	@Parameters({"user", "pass"})
	@Test(priority = 1)
	public void login(String user,  String pass ) {
		
		app.click(app.menu.myAccountLink);
		app.myAccount.loginInApp(user, pass);
		assertTrue(app.checkElementIsDisplayed(app.myAccount.greetingsMessage));
		ScreenShots.screenShot(driver);
		app.click(app.myAccount.logOutButton);
	}
	
	@Test(priority = 2)
	public void loginInvalid() {
		
		app.click(app.menu.myAccountLink);
		app.myAccount.loginInApp("customer123", "customer@123");
		assertTrue(app.checkElementIsDisplayed(app.myAccount.loginErrorMsg));
	}
	
}
