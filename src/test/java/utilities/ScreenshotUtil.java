package utilities;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import base.BaseTest;

public class ScreenshotUtil extends BaseTest {
	
	public static String screenshotfilename;
	
	public static String getScreenshot() throws IOException {
		
		//create timestamp
				Date getcurrentdate = new Date();
				screenshotfilename = getcurrentdate.toString().replace(" ", "_").replace(":", "-");
				String screenshotpath = ".//screenshot/screenshot_"+screenshotfilename+".png";
				
				File takescreenshots = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
				FileUtils.copyFile(takescreenshots,new File(screenshotpath)); 
				
				return screenshotfilename;
		
	}

}