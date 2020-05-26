package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DashboardPage {
	
	public WebDriver driver;
	
	By learning_button=By.xpath("//a[@title='Learning']/span");
	By search_button=By.xpath("//input[@class=' -plain']");

		
	public DashboardPage(WebDriver driver) {
		// TODO Auto-generated constructor stub

		this.driver = driver;

	}
	
	public WebElement clickLearning() {

		return driver.findElement(learning_button);
	}

	public WebElement inputSearchValue() {
		
		return driver.findElement(search_button);
	}

	
	public WebElement selectCourse1() {
		
		return driver.findElement(courseName);
	}
	
	
	public WebElement selectCourse() {
		
		return driver.findElement(courseName);
	}
	
}
