package com.orangehrm.hybridframe_2021.testcases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.orangehrm.hybridframe_2021.pageobjet.DashboardPage;
import com.orangehrm.hybridframe_2021.pageobjet.LoginPage;
import com.orangehrm.hybridframe_2021.testbase.TestBase;

public class LoginDDTC01 extends TestBase {

	@Test
	public void loginToOrangeHrmTC01() throws InterruptedException {
		LoginPage lp = new LoginPage(driver);
		
//		String uname = excelDataProvider.getStringCellData("login", 1, 0);
//		String pwd = excelDataProvider.getStringCellData("login", 1, 1);
		
		String uname = excelDataProvider.getStringCellData(0, 1, 0);
		String pwd = excelDataProvider.getStringCellData(0, 1, 1);
		
		lp.setUserName(uname);
		lp.setPassword(pwd);
		
		DashboardPage dp = lp.clickOnLoginBtn();
		
		if(driver.findElement(By.xpath("//a[@id='menu_dashboard_index']")).isDisplayed()) {
			Assert.assertTrue(true);
			Thread.sleep(3000);
			dp.logoutOrangeHRM();
		}
		else {
			Assert.assertTrue(false, "Dashboard page title not contains Orange text");
		}
	}
}
