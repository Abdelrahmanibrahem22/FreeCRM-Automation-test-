package com.freecrm.testcases;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Method;

import javax.print.attribute.standard.OutputDeviceAssigned;

import org.apache.commons.io.FileUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.formula.functions.Count;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ReadExcel {

	public String[][] read_sheet() throws InvalidFormatException, IOException{
		File f=new File(".\\Test_data\\test.xlsx");
		XSSFWorkbook wb = new XSSFWorkbook(f);
		XSSFSheet sht=wb.getSheet("Sheet1");
		int number_of_rows=sht.getPhysicalNumberOfRows();
		int number_of_colums=sht.getRow(0).getLastCellNum();
		String[][] myarray = new String[number_of_rows][number_of_colums];
		for(int i=0; i<number_of_rows;i++) {
			
			for(int j=0; j<number_of_colums;j++) {
				
				XSSFRow row=sht.getRow(i);
				myarray[i][j]=row.getCell(j).getStringCellValue();
				
			}	
			
		}
		return myarray;
		
	}
	
	
	
	
	public static String getdata ( int x,int y) throws FileNotFoundException, IOException {
		File f=new File("D:\\\\test.xlsx");
		FileInputStream fis=new FileInputStream(f);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sht=wb.getSheet("Sheet1");
		String testdata=sht.getRow(x).getCell(y).getStringCellValue();
		wb.close();
		return testdata;
		}
	public static int count() throws IOException
	{
	File f=new File("D:\\test.xlsx");
	FileInputStream fis=new FileInputStream(f);
	XSSFWorkbook wb = new XSSFWorkbook(fis);
	XSSFSheet sht=wb.getSheet("Sheet1");
	int count=sht.getPhysicalNumberOfRows();
	wb.close();
	return count;
	}
	
}
