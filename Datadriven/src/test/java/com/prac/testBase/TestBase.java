package com.prac.testBase;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.prac.utilities.ExcelReader;
import com.prac.utilities.ExtendManger;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class TestBase {
	public static WebDriver driver;
	public static FileInputStream fis;
	public static Properties config = new Properties();
	public static Properties or = new Properties();
	public static Logger log = Logger.getLogger("devpionyLogger");
	public static ExtentReports rep= ExtendManger.getInstance();
	public static ExtentTest test;
	public static ExcelReader excel = new ExcelReader(System.getProperty("user.dir")+"\\src\\test\\resources\\excel\\testdata.xlsx");
	@BeforeSuite
	public void setUp() throws IOException, InterruptedException{
		if (driver==null) {
			log.info("loading properties......");
			fis=new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\properties\\Or.properties");
			or.load(fis);
			fis=new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\properties\\Config.properties");
			config.load(fis);
			log.info("loaded sucessfully");
			if(config.getProperty("browser").equals("chrome")) {
				log.info("Initializing the chrome driver.......");
				System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\src\\test\\resources\\executables\\chromedriver.exe");
				driver=new ChromeDriver();
				log.info("driver Initilization completed");
			}else {
				log.info("Initializing the firefox driver.......");
				System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir")+"\\src\\test\\resources\\executables\\geckodriver.exe");
				driver=new FirefoxDriver();
				log.info("driver Initilization completed");
			}
			

		}
		log.info("opening home page completed");
		driver.get(config.getProperty("homepage"));
		Thread.sleep(200);
	}
	public void type(String locator,String value) {
		driver.findElement(By.cssSelector(or.getProperty(locator))).sendKeys(value);
	}
	
	public void click(String locator) {
		driver.findElement(By.cssSelector(or.getProperty(locator))).click();
	}
	@AfterSuite
	public void teardown() {
		if(driver!= null) {
			driver.quit();
		}
		log.info("closing the browser");
	}
}
