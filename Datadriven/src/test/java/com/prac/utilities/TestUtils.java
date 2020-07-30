package com.prac.utilities;


import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.DataProvider;

import com.prac.testBase.TestBase;

public class TestUtils extends TestBase{
	public static String path;
	public static String Name;
	public static void takeScreenShot() throws IOException {
		
		System.out.println("screenshot");
		log.info("taking screen shot");
		File srcDir=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		Date d =new Date();
		Name="error"+d.toString().replace(":","_").replace(" ","_")+".jpg";
		FileUtils.copyFile(srcDir,new File(System.getProperty("user.dir")+"\\target\\surefire-reports\\html\\"+Name));
		
		
	}
	@DataProvider(name="queries")
	public Object[][] getQueries(Method test){
		String sheetName=test.getName();
		int col = excel.getColumnCount(sheetName);
		int row = excel.getRowCount(sheetName);
		Object[][] data = new Object[row-1][col];
		for(int rownum=2; rownum <= row;rownum++) {
			for(int colnum=0; colnum < col;colnum++) {
				data[rownum-2][colnum]=excel.getCellData(sheetName, colnum, rownum);
			}
		}
		return data;
		
	}

}
