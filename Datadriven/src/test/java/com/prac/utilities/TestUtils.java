package com.prac.utilities;


import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;


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

}
