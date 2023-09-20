package tests;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.testng.Reporter;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import pages.BasePage;
import utils.BaseTest;
import utils.ScreenShots;
import io.cucumber.java.en.Then;

public class LoginTestDefiniton {
	
	public WebDriver driver = BaseTest.driver;//to be replaced by TestRunner class
	public BasePage app = new BasePage(BaseTest.driver);
	String user = Reporter.getCurrentTestResult().getTestContext()
			.getCurrentXmlTest().getParameter("user");
	String pass = Reporter.getCurrentTestResult().getTestContext()
			.getCurrentXmlTest().getParameter("pass");
	String invUser = Reporter.getCurrentTestResult().getTestContext()
			.getCurrentXmlTest().getParameter("invUser");
	String invPass = Reporter.getCurrentTestResult().getTestContext()
			.getCurrentXmlTest().getParameter("invPass");
	
  @Given("User is on Login page")
  public void userIsOnLoginPage() throws Throwable {
	  app.click(app.menu.myAccountLink);
  }
  
  @When("User enters correct username and password")
  public void userEntersCorrectUserAndPass() throws Throwable {
	  app.myAccount.loginInApp(user, pass);
  }
  
  @When("User enters wrong username and password")
  public void userEntersWrongUserAndPass() throws Throwable {
	  app.myAccount.loginInApp(invUser, invPass);

  }

  @Then("User should be able to see success message")
  public void userShouldSeeSuccessMessage() throws Throwable {
	  assertTrue(app.checkElementIsDisplayed(app.myAccount.greetingsMessage));
		ScreenShots.screenShot(driver);
		app.click(app.myAccount.logOutButton);
  }

  @Then("User should be able to see error message")
  public void userShouldSeeErrorMessage() throws Throwable {
		assertTrue(app.checkElementIsDisplayed(app.myAccount.loginErrorMsg));

  }
  
}
