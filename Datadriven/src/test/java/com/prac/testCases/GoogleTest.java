package com.prac.testCases;

import org.testng.annotations.Test;


import com.prac.testBase.TestBase;
import com.prac.utilities.TestUtils;

public class GoogleTest extends TestBase {
		@Test(dataProviderClass=TestUtils.class,dataProvider="queries")
		public void googleTest(String Query) {
			driver.get("https://www.google.com/");
			type("textBox_CSS",Query);
			click("searchBtn_CSS");
		}
}
