package testcases.Functions;

import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.google.common.collect.Table.Cell;

import testcases.Functions.Navigations;
import base.BaseTest;

public class Validations extends BaseTest {
	public static BaseTest bt = new BaseTest();
	
	public void validateDateandTime() throws IOException {
		
		
		/*Getting the String for the time and date */
		String date_validation = driver.findElement(By.xpath(loc.getProperty("date_UI_validation"))).getText();
		String time_validation = driver.findElement(By.xpath(loc.getProperty("time_UI_validation"))).getText();
		
		/*Validation for time and date*/
		if(date_validation.equals(prop.getProperty("date_validation"))) {
			System.out.println("Step 1 date is passed\n");
			System.out.println("Expected Result: "+prop.getProperty("date_validation")+"\n");
			System.out.println("Verification of date is: "+ date_validation);
			
		} else {
			System.out.println("Step #1 date is failed. The actual is: " + date_validation + " and the expected result should be "+prop.getProperty("date_validation"));
			bt.takeScreenshot();
			Assert.assertTrue(false, "The actual is: "+ date_validation+" and the expected result should be "+prop.getProperty("date_validation"));
		}
		
		/*If validation needed to pass the time, but based on what I analyzed, this is a forecast time.*/
		if(time_validation.equalsIgnoreCase(prop.getProperty("time_validation"))) {
			System.out.println("Step 1 time is passed\n");
			System.out.println("Expected Result: "+prop.getProperty("time_validation")+"\n");
			System.out.println("Actual Result: "+ time_validation);
		}

			System.out.println("Verification of time is: " + time_validation);
			
			Reporter.log("Verification of date is: "+date_validation);
			Reporter.log("Verification of time is: "+time_validation);
	}
	
	public void validateColor() throws IOException {
		System.out.println("Validate Color");
		
		/*Sports Tab*/
		driver.findElement(By.xpath(loc.getProperty("Sports_text"))).click();
		WebElement sportstab = driver.findElement(By.xpath(loc.getProperty("Sports_tab")));
		String sportsbuttoncolor = sportstab.getCssValue("background-color");
		System.out.println("The background color of Sports tab is: "+sportsbuttoncolor);
		
		WebElement secondarytab = driver.findElement(By.xpath(loc.getProperty("secondary_bgcolor")));
		String secondarytabcolor = secondarytab.getCssValue("background-color");
		System.out.println("The background color of secondary tab of Sports is: "+secondarytabcolor);
		
		if(sportsbuttoncolor.equals(secondarytabcolor)) {
			System.out.println("Validation color match. The color is "+secondarytabcolor);
			Reporter.log("Validation color match. The color is "+secondarytabcolor);
		} else {
			bt.takeScreenshot();
			Assert.assertTrue(false, "The actual is color from secondary sports tab is: "+ secondarytabcolor +" and the expected color should be "+ secondarytabcolor);
			
		}
	}
	
	public void validateImage() throws IOException, InterruptedException{
		System.out.println("Validate Image");
		String image1 = driver.findElement(By.xpath(loc.getProperty("firstInsideImage"))).getAttribute("src");
		driver.findElement(By.xpath(loc.getProperty("nextbutton"))).click();
		String image2 = driver.findElement(By.xpath(loc.getProperty("secondInsideImage"))).getAttribute("src");
		driver.findElement(By.xpath(loc.getProperty("closeimg"))).click();
		System.out.println(image1);
		System.out.println(image2);
		
		if(image1.equalsIgnoreCase(image2)) { 
			bt.takeScreenshot();
			Assert.assertTrue(false,"The actual is image from second image should not be the same");
		  } else {
		  System.out.println("Image 1 is different from image 2. Validation passed");
		  Reporter.log("Image 1 is different from image 2. Validation passed"); 
		  }
		
		/*Validation for Facebook logo*/
		Actions action = new Actions(driver);
		WebElement facebooklogo = driver.findElement(By.xpath(loc.getProperty("firstImage")));
		action.moveToElement(facebooklogo).perform();
		driver.findElement(By.xpath(loc.getProperty("facebooklogo"))).click();
		Thread.sleep(3000);
		Set<String> windowhandles = driver.getWindowHandles();
		Iterator<String> iterator = windowhandles.iterator();
		System.out.println(windowhandles);
		String parentwindow = iterator.next(); //first iterator of page
		String childwindow = iterator.next(); 
		driver.switchTo().window(childwindow);
	
		driver.findElement(By.xpath(loc.getProperty("facebookcookie"))).click();
		if(driver.findElement(By.xpath(loc.getProperty("facebooksite"))).isDisplayed()) {
			Reporter.log("Facebook Site is successfully opened");
			System.out.println("Facebook Site is successfully opened");
		}
		
	}
	
	public void validateExpandVideo() throws IOException {
		System.out.println("Validate Video");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loc.getProperty("videoscreen"))));
		WebElement video = driver.findElement(By.xpath(loc.getProperty("videoscreen")));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", video);
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loc.getProperty("expandvideo"))));
		WebElement expand = driver.findElement(By.xpath(loc.getProperty("expandvideo")));
		
		if(expand.isDisplayed()) {
			expand.click();
			System.out.println("video is expanded successfully");
			expand.click();
			Reporter.log("video is expanded successfully");
		} else {
			bt.takeScreenshot();
			Assert.assertTrue(false,"the video was not expanded. kindly check");
		}
	}
	
	public void validateTable() throws IOException {
		System.out.println("Validating the Table");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loc.getProperty("tournamentTableclass"))));
		WebElement tableclass = driver.findElement(By.xpath(loc.getProperty("tournamentTableclass")));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", tableclass);
		
		
		/*get row*/
		List<WebElement> rows = driver.findElements(By.xpath(loc.getProperty("tournamentTableElementRow")));
		System.out.println(rows.size());
		int rowsize = rows.size();
		
		/*get col*/
		List<WebElement> columns = driver.findElements(By.xpath(loc.getProperty("tournamentTableElementCol")));
		System.out.println(columns.size());
		int columnsize = columns.size();
		
		/*displaying the table through HTML (Extent Results) */
		ExtentReports er = new ExtentReports();
		ExtentSparkReporter spark = new ExtentSparkReporter(file);
		ExtentTest validate;
		
		er.attachReporter(spark); 
		
		validate = er.createTest("Validate the Table from the UI");
		validate.log(Status.INFO, " Pos "+" | "+"   Team   "+" | "+" PTS ");
		/*processing and validating tables in the ui*/
		for(int row=1; row <= rowsize; row++) {
//			for(int col=1; col <= columnsize; col++) {
//				value = driver.findElement(By.xpath(loc.getProperty("tournamentTableElement")+"/tr["+row+"]/td["+col+"]")).getText();
//				value2 = driver.findElement(By.xpath(loc.getProperty("tournamentTableElement")+"/tr["+row+"]/td["+col+"]")).getText();
//				value3 = driver.findElement(By.xpath(loc.getProperty("tournamentTableElement")+"/tr["+row+"]/td["+col+"]")).getText();
//				if(col == 1) {
//				System.out.print(value);
//				}
//				if(col == 4) {
//				System.out.print(value2);
//				}
//				if(col == 5) {
//				System.out.print(value3);
//				break;}				
//			}
			value = driver.findElement(By.xpath(loc.getProperty("tournamentTableElement")+"/tr["+row+"]/td[1]")).getText();
			value2 = driver.findElement(By.xpath(loc.getProperty("tournamentTableElement")+"/tr["+row+"]/td[4]")).getText();
			value3 = driver.findElement(By.xpath(loc.getProperty("tournamentTableElement")+"/tr["+row+"]/td[5]")).getText();
			validate.log(Status.INFO, value +" | "+ value2 +" | "+ value3);
			System.out.println();
		}
		validate.log(Status.PASS, "Table is sucessfully validated");
		er.flush();
		Desktop.getDesktop().browse(new File("report.html").toURI());
	}
}
