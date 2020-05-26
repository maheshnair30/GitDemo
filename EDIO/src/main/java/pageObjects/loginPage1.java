package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class loginPage1 {

	public WebDriver driver;

	By username = By.xpath("//input[@id='username']");
	By password = By.xpath("//input[@id='password']");
	By login_Button = By.xpath("//button[@class='c-button']");
	By forgotPassword = By.xpath("//a[text()='Forgot your password or username?']");

	public loginPage1(WebDriver driver) {
		// TODO Auto-generated constructor stub

		this.driver = driver;

	}

	public WebElement inputUsername() {

		return driver.findElement(username);
	}

	
	public WebElement inputPassword() {

		return driver.findElement(password);
	}

	
	public WebElement clickLoginButton() {

		return driver.findElement(login_Button);
	}

	
}
