package sampledatadriven;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

//ExcelFile --Workbook --Sheet --Row --Cells
public class Readingdata {

	public static void main(String[] args) throws IOException {
		
		//FileInputStream file = new FileInputStream("/home/engagebay/Desktop/Java/Opencart/testdata/datadriven.xlsx");
		
		FileInputStream file = new FileInputStream(System.getProperty("user.dir")+"//testdata//datadriven.xlsx");
		XSSFWorkbook workbook1 = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook1.getSheet("sheet1");
		//XSSFSheet sheet = workbook.getSheetAt(0);
		int rowcount = sheet.getLastRowNum();
		int cellcount =sheet.getRow(1).getLastCellNum();
		System.out.println(rowcount);
		System.out.println(cellcount);
		
		
		for(int r =0;r<=rowcount;r++) 
		{
			
			XSSFRow currentrow = sheet.getRow(r);
			
			for(int c=0;c<cellcount;c++) 
			{
				XSSFCell currentcell = currentrow.getCell(c);
				System.out.print(currentcell.toString()+"\t");
			}
			System.out.println();
		}
		
		workbook1.close();
		file.close();
		
			}
	

}
