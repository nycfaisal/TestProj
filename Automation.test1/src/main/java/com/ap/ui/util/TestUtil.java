package com.ap.ui.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.ap.ui.base.TestBase;

public class TestUtil extends TestBase {
	
	public static long page_load = 10;
	public static long implicit_wait = 10;
	
	//read all the information in excell sheet
	
	public static String XL_SHEET_PATH = "path of the xl sheet";
			
	static Workbook book;
	static Sheet sheet;
	static JavascriptExecutor js;
	
	public static Object[][] getTestData(String sheetName)
	{
	FileInputStream file = 	null;// if the Excel sheet doesn't have value then don't perform the action. thats what null does
	try
	{
		file = new FileInputStream(XL_SHEET_PATH);
	}catch (FileNotFoundException e)
	{
		e.printStackTrace();
	}try
	{
		book = WorkbookFactory.create(file);//throwing try catch exception so that we don't have to throw exception in method
		}catch (InvalidFormatException e){
			e.printStackTrace();
		}catch (IOException e){
			e.printStackTrace();
		}
	sheet = book.getSheet(sheetName);
	Object [][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
	for (int i = 0; i<sheet.getLastRowNum(); i++)
	{
		for (int j=0; j<sheet.getRow(0).getLastCellNum(); j++)
		{
		data[i][j]=sheet.getRow(i+1).getCell(j).toString();	
		}
	}
	return data;
	}

	public static void takeScreenshotAt() throws IOException
	{
		File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String currentDirect = System.getProperty("user.dir");// user dir is always my computer
		FileUtils.copyFile(srcFile, new File(currentDirect + "/screenshot/" + System.currentTimeMillis() + ".png"));
	}
	
	//when there is error message, the script should handle it. jqueries 
	public static void runTimeInfo(String messageType, String message) throws InterruptedException
	//purpose behind this to capture everything during execution of my script
	{
		js = (JavascriptExecutor) driver;
		
		js.executeScript("if (!window.JQuery){" 
				+ "var jquery = document.createElement('script');jquery.type ='text/javascript';"
				+ "jquery.src = 'https://ajax.googleapis.com/ajax/libs/jquery/2.0.2/jquery.min.js';"
				+ "document.getElementsByTagName('head')[0].appendChild(jquery);" + "}");
			Thread.sleep(6000);
			
			js.executeScript("$.getScript('https://the-internet.herokuapp.com/js/vendor/jquery.growl.js')");
					js.executeAsyncScript("$('head').append('<link rel=\"stylesheet\" " 
							+ "herf\"https://the-internet.herokuapp.com/css/jquery.growl.css\" " + "type=\"text/css\" />');");
		Thread.sleep(6000);
		
		js.executeScript("$ growl({ title: 'GET' , message: '/'});");
		 
		if (messageType.equals("error"))
		{
		js.executeScript("$growl.error({ title: 'ERROR' message: '"+message+"'});");	
		}else if (messageType.equals("info"))
		{
			js.executeScript("$growl.error({ title: 'Notice' message: 'your notice message will appear here'});");	
		}else if (messageType.equals("warning"))
		{
			js.executeScript("$growl.warning({ title: 'Warning!!' message: 'your warning message will appear here'});");	
		}else
			System.out.println("Show NO Error Message");
		Thread.sleep(6000);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
