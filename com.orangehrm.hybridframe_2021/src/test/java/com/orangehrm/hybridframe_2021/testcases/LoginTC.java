package com.orangehrm.hybridframe_2021.testcases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.orangehrm.hybridframe_2021.pageobjet.LoginPage;
import com.orangehrm.hybridframe_2021.testbase.TestBase;

public class LoginTC extends TestBase {

//	@Test
//	public void loginToOrangeHrmTC001()  {
//
//		LoginPage lp =new LoginPage(driver);//		
//		lp.setUserName("Admin");
//		lp.setPassword("admin123");
//		lp.clickOnLoginBtn();
//		
//		if(driver.findElement(By.xpath("//a[@id='menu_dashboard_index']")).isDisplayed()) {
//			Assert.assertTrue(true);
//		}
//		else {
//			Assert.assertTrue(false, "Dashboard page title not contains Orange text");
//		}
//				
//	}

	@Test
	public void loginToOrangeHrmTC002() {

		LoginPage lp = new LoginPage(driver);
		lp.setUserName(configDataProvider.getUserName());
		lp.setPassword(configDataProvider.getPwd());

//		lp.setUserName(configDataProvider.getValue("username"));
//		lp.setPassword(configDataProvider.getValue("password"));

		lp.clickOnLoginBtn();

		if (driver.getPageSource().contains("Dashboard")) {
			extentTest = extentReport.createTest("Login Test");
			Assert.assertTrue(true);
			extentTest.info("Login success with given test data");
		}
		else if (driver.getPageSource().contains("LOGIN Panel")) {
			extentTest = extentReport.createTest("Login Test");
			String invalidCredentials = driver.findElement(By.xpath("//span[text()='Invalid credentials']")).getText();
			extentTest.info("Login failed with given test data");
			Assert.assertTrue(false, invalidCredentials);
		}
	}
}
