package com.orangehrm.hybridframe_2021.testcases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.orangehrm.hybridframe_2021.pageobjet.DashboardPage;
import com.orangehrm.hybridframe_2021.pageobjet.LoginPage;
import com.orangehrm.hybridframe_2021.testbase.TestBase;

public class DashboardTC extends TestBase {

	@Test
	public void logoutOrangeHrmTC01() {

		LoginPage lp = new LoginPage(driver);
		lp.setUserName("Admin");
		lp.setPassword("admin123");
		DashboardPage hp = lp.clickOnLoginBtn();
		//a[@class='firstLevelMenu']/b[text()='Dashboard']
		if (driver.findElement(By.xpath("//a[@id='menu_dashboard_index']")).isDisplayed()) {
			Assert.assertTrue(true);
			hp.logoutOrangeHRM();
		} else {
			Assert.assertTrue(false, "Dashboard page title not contains Orange text");
		}
	}
}
