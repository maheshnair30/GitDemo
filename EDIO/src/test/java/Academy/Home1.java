package Academy;

import java.io.IOException;
import java.util.LinkedHashMap;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;

import com.tcs.saf.exceptions.DataSheetException;
import com.tcs.saf.exceptions.InvalidBrowserException;
import com.tcs.saf.test.BiffException;
import com.tcs.saf.utilities.TestDataProvider;

import pageObjects.ForgotPassword;
import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.base;

public class Home1 extends base{
	public WebDriver driver;
	
	 public static Logger log =LogManager.getLogger(base.class.getName());
	 
	 public Home1()
	    {
	        this.testDataProvider = new TestDataProvider();
	        getGridProperties();
	        getGlobalProperties();
	    }

	    public Home1(String testName, String browser, LinkedHashMap<String, String> mapDataSheet)
	    {
	        this.testName = testName;
	        this.testDataProvider = new TestDataProvider();
	        this.testBrowser = browser;
	        this.mapDataSheet = mapDataSheet;
	    }

	    @Factory(dataProvider = "dataSheet")
	    public Object[] testCreator(LinkedHashMap<String, String> mapDataSheet) {
	        return new Object[] { new Home1(this.getClass().getSimpleName(),mapDataSheet.get("Browser"), mapDataSheet) };
	    }

	    @DataProvider(name="dataSheet")
	    public  Object[][] getTestData() throws BiffException, IOException, InvalidBrowserException, DataSheetException{
	        return testDataProvider.getTestDataFromExcel(externalSheetPath, this.getClass().getSimpleName(),"Mahesh");
	    }
	 
	 
	 
	 
	 
	 
	 
	@BeforeTest
	public void initialize() throws IOException
	{
	
		 driver =initializeDriver();

	}
	@Test(dataProvider="getData")
	
	public void basePageNavigation(String Username,String Password,String text) throws IOException
	{

		//one is inheritance

		// creating object to that class and invoke methods of it
	//	driver.get(prop.getProperty("url"));
		driver.get("http://www.qaclickacademy.com/");
		LandingPage l=new LandingPage(driver);
		LoginPage lp=l.getLogin(); //driver.findElement(By.css()
		lp.getEmail().sendKeys(Username);
		lp.getPassword().sendKeys(Password);

		log.info(text);
		
		lp.getLogin().click();
		ForgotPassword fp= lp.forgotPassword();
		fp.getEmail().sendKeys("xxx");
		fp.sendMeInstructions().click();
		
		
		
		}

	@AfterTest
	public void teardown()
	{
		
		driver.close();
	
		
	}

	
	@DataProvider
	public Object[][] getData()
	{
		// Row stands for how many different data types test should run
		//coloumn stands for how many values per each test
		
		// Array size is 2
		// 0,1
		Object[][] data=new Object[2][3];
		//0th row
		data[0][0]="nonrestricteduser@qw.com";
		data[0][1]="123456";
		data[0][2]="Restrcited User";
		//1st row
		data[1][0]="restricteduser@qw.com";
		data[1][1]="456788";
		data[1][2]= "Non restricted user";
		
		return data;
		
		
		
		
		
		
	}
	
}
