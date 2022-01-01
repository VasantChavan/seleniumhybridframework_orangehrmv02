package com.orangehrm.hybridframe_2021.utility;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Helper {

	// alert, drop down, handle iframe, authi window , bootstrap
	// capture screenshot,
	public static String captureScreenshots(WebDriver driver) {

		String screenshotpath = System.getProperty("user.dir") + "//Screenshots//Orangehrm_" + getCurrentDateTime()
				+ ".png";
		try {
			File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(source, new File(screenshotpath));
			System.out.println("Screenshot captured successfully  ");
			return screenshotpath;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

	public static String getCurrentDateTime() {
		DateFormat customDateTime = new SimpleDateFormat("MM_dd_yyyy_HH_mm_ss");
		Date currentDate = new Date();
		// System.out.println(currentDate);
		String dateFormat = customDateTime.format(currentDate);

		// System.out.println(dateFormat);

		return dateFormat;
	}

}
