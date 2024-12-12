package utilities;
import java.io.IOException;
import org.testng.annotations.DataProvider;

public class DataProviders 
{
	//data provider 1	
	@DataProvider(name="LoginData")
	public String[][] getData() throws IOException
	{
		String path=".\\testData\\Opencart_Login.xlsx";  //taking xl file from testData
		ExcelUtility xlutil=new ExcelUtility(path);  //creating an object for XLUtility
		
		int totalrows=xlutil.getRowCount("Sheet1");
		int totalcols=xlutil.getCellCount("Sheet1", 1);
		
		String logindata[][]=new String[totalrows][totalcols]; //created for two dimension array which can store values from xl
		
		for(int i=1;i<=totalrows;i++)                          //1  //Read the data from xl storing in two dimensional array
		{
			for(int j=0;j<totalrows;i++)                       //0 i is rows j is column
			{
				logindata[i-1][j]=xlutil.getCellData("Sheet1", i, j);  //1,0
			}
		}
		
		return logindata;  //returning two dimension array	
	}
	
	//data provider 2  //Same class multiple data provider method can be added..but it is used for only one test case.
	  //the same cannot be used for second test case...the data provider for second test case can be done seperately in another class
	//data provider 3
}
