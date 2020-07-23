package com.prac.rough;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class tests {

	public static void main(String[] args) throws IOException {
		WebDriver driver;
		FileInputStream fis;
		Properties config = new Properties();
		Properties or = new Properties();
		fis=new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\properties\\Or.properties");
		or.load(fis);
		fis=new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\properties\\Config.properties");
		config.load(fis);
		System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\src\\test\\resources\\executables\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.get(config.getProperty("homepage"));
	}

}
