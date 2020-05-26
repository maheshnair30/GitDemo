package Academy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.ForgotPassword;
import pageObjects.LandingPage;
import pageObjects.LoginPage;
import pageObjects.loginPage1;
import resources.base;

public class loginTest extends base {

	public WebDriver driver;
	

	public static Logger log = LogManager.getLogger(base.class.getName());

	@BeforeTest
	public void initialize() throws IOException {

		driver = initializeDriver();

	}

	@Test
	public void basePageNavigation() throws IOException {

		// one is inheritance

		// creating object to that class and invoke methods of it
		driver.get(prop.getProperty("url"));
		loginPage1 l = new loginPage1(driver);
		l.inputUsername().sendKeys("ADAMS381");
		l.inputPassword().sendKeys("passw0rd!");
		l.clickLoginButton().click();

	}

	@AfterTest
	public void teardown() {

		driver.close();

	}

}
