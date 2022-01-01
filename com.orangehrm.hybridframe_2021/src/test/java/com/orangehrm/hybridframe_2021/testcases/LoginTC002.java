package com.orangehrm.hybridframe_2021.testcases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.orangehrm.hybridframe_2021.pageobjet.LoginPage;
import com.orangehrm.hybridframe_2021.testbase.TestBase;

public class LoginTC002 extends TestBase {

	@Test(dataProvider = "getTestData")
	public void validateLoginFunctionality(Object uname, Object pwd) {
		String un = uname.toString();
		String pw = pwd.toString();

		System.out.println(un + "  " + pw);

		LoginPage lp = new LoginPage(driver);
		lp.setUserName(un);
		lp.setPassword(pw);

		lp.clickOnLoginBtn();

		if (driver.getPageSource().contains("Dashboard")) {
			Assert.assertTrue(true);
		} else if (driver.getPageSource().contains("LOGIN Panel")) {

			String invalidCredentials = driver.findElement(By.xpath("//span[text()='Invalid credentials']")).getText();
			Assert.assertTrue(false, invalidCredentials);
		}
	}

	@DataProvider
	public Object[][] getTestData() {
		// Object[][] data = excelDataProvider.getExcelData("Sheet2");
		return excelDataProvider.getExcelData("Sheet2");
	}
}
