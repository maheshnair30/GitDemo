package resources;

import java.io.IOException;

import org.testng.annotations.DataProvider;

import exceptions.DataSheetException;
import utilities.DataSheet;



public class TestDataProvider {

	
	@DataProvider(name = "dataSheet")
	public Object[][] getTestDataFromExcel(String externalSheetPath,
			String sheetName,String user) throws BiffException,  IOException,
			 DataSheetException {
		Object[][] dataMap = (Object[][]) null;
		DataSheet dataSheetObj = new DataSheet();
		String fileName = "/InputSheet_"+ user + ".xls" ;
		dataMap = dataSheetObj.readFromSheet(externalSheetPath + fileName, sheetName);	
		return dataMap;
	}
	
}
