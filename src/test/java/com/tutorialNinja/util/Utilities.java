package com.tutorialNinja.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;
import java.util.Random;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import io.netty.util.internal.ThreadLocalRandom;

public class Utilities {
	
	public static final int IMPLICIT_WAIT_TIME=10;
	public static final int PAGE_LOAD_TIME=5;
	
	public static String getEmailWithTimeStamp() {
		Date date=new Date();
		
		String timestamp=date.toString().replace(" ","_").replace(":","_");
		String emailTimeStamp="nanda"+timestamp+"@gmail.com";
		return emailTimeStamp;
	}



	  public static String getRandomString() {

	    // create a string of all characters
	    String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

	    // create random string builder
	    StringBuilder sb = new StringBuilder();

	    // create an object of Random class
	    Random random = new Random();

	    // specify length of random string
	    int length = 7;

	    for(int i = 0; i < length; i++) {

	      // generate random index number
	      int index = random.nextInt(alphabet.length());

	      // get character specified by index
	      // from the string
	      char randomChar = alphabet.charAt(index);

	      // append the character to string builder
	      sb.append(randomChar);
	    }

	    String randomString = sb.toString();
	    
	    return randomString;

	  }
	  
	  public static int getRandomNumber() {
		  int rand_int1 = ThreadLocalRandom.current().nextInt()+2;
		  return rand_int1;
	  }
	
	public static Object[][] getExcelData(String sheetName) {
		FileInputStream fisExcel = null;
		XSSFWorkbook workBook=null;
		try {
			fisExcel = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\com\\tutorialsNinja\\testData\\allData.xlsx");
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		try {
			workBook = new XSSFWorkbook(fisExcel);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		XSSFSheet sheet = workBook.getSheet(sheetName);
		int rowsCount=sheet.getLastRowNum();
		int columnCount=sheet.getRow(0).getLastCellNum();
		Object[][] data=new Object[rowsCount][columnCount];
		for(int i=0;i<rowsCount;i++) {
			XSSFRow row = sheet.getRow(i+1);
			for(int j=0;j<columnCount;j++) {
				XSSFCell cell = row.getCell(j);
				CellType cellType = cell.getCellType();
				
				switch(cellType) {
					
				case STRING:
					data[i][j]=cell.getStringCellValue();
					break;
				case NUMERIC:
					data[i][j]=Integer.toString((int)cell.getNumericCellValue());
					break;
				
					
				}
			}
		}
		return data;
		
	}

}
