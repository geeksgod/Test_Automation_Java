package com.prac.testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.prac.testBase.TestBase;

public class ClickLinkTest extends TestBase{
	@Test
	public void clickLinkTest(){
		log.info("page loaded");
		WebDriverWait wait=new WebDriverWait(driver,10);
		WebElement button=wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(or.getProperty("Guide_CSS"))));
		log.info("clicking the link");
		button.click();
	}
}
