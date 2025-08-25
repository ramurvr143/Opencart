package sampledatadriven;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class writedata {

	public static void main(String[] args) throws IOException {
		FileOutputStream outfile =new FileOutputStream(System.getProperty("user.dir")+"//testdata//dataout.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheet = workbook.createSheet("data");
		
		XSSFRow row1 =sheet.createRow(0);
		row1.createCell(0).setCellValue("King");
		row1.createCell(1).setCellValue(143);
		row1.createCell(2).setCellValue("priya");
		
		XSSFRow row2 = sheet.createRow(1);
		row2.createCell(0).setCellValue("Queen");
		row2.createCell(1).setCellValue(1432);
		row2.createCell(2).setCellValue("priya");

		workbook.write(outfile);
		workbook.close();
		outfile.close();
		System.out.println("file is cretaed");
		
	}

}

