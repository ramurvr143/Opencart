package utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class Dataprovider
{

	@DataProvider(name="logindata")
    public String [][] getData() throws IOException {
        //String path=".\\testData\\Opencart_LoginData.xlsx";//taking xl file from testData
		String path = "/home/engagebay/Desktop/Java/Opencart/testdata/opencartlogin.xlsx";
        Excelfinalutilitie xlutil=new Excelfinalutilitie(path);//creating an object for XLUtility
        
        int totalrows=xlutil.getRowCount("Sheet1");
        int totalcols=xlutil.getCellCount("Sheet1",1);
        
        String logindata[][]=new String[totalrows][totalcols];//created for two dimension array which can store the data
        
        for(int i=1;i<=totalrows;i++) //read the data from xl storing in two dimensional array
        {		
            for(int j=0;j<totalcols;j++) //i is rows j is col
            {
                logindata[i-1][j]=xlutil.getCellData("Sheet1",i,j);
            }
        }
        return logindata;//returning two dimension array
    }
}
