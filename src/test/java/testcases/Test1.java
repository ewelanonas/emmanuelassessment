package testcases;


import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.*;

import base.BaseTest;
import testcases.Functions.Navigations;
import testcases.Functions.Validations;

@Test
public class Test1 extends BaseTest{
	public static Navigations n = new Navigations();
	public static Validations v = new Validations();
	
	
	@Test (priority = 1,enabled = true ,description="This method is to verify the time and date")
	public void verifyData() throws IOException {
		System.out.println("initiate number 1");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loc.getProperty("date_UI_validation"))));
		
		v.validateDateandTime();
	}
	
	@Test (priority = 2,enabled= true ,description="This is to verify the color between primary tab and secodary tab",dependsOnMethods = "verifyData")
	public static void verifyColor() throws IOException {
		System.out.println("initiate number 2");
		
		v.validateColor();
		
	}
	
	@Test (priority = 3,enabled= true ,description="This is to verify the function of the image feature in the article")
	public static void verifyImageButtons() throws IOException, InterruptedException {
		System.out.println("initiate number 3");
		
		/*creating object*/
		
		
		/*Sports Tab to Article*/
		n.navigateToArticleImage();
		
		/*Image validation*/
		v.validateImage();
		
	}
	
	@Test (priority = 4,enabled= false ,description="This is to verify the function of the video expansion in the article")
	public static void verifyExpandVideo() throws IOException {
		System.out.println("initiate number 4");
		
		/* Sports Tab to Article - note: since there's no video in the first article, I'll try simulate similar with the assessment */
		//n.navigateToArticleImage();
		v.validateExpandVideo();
		
	}
	
	@Test (priority = 5,enabled= true ,description="This is to verify the table and parametized through the report")
	public static void verifyTable() throws IOException {
		System.out.println("initiate number 5");
		
		/*Navigate to Article*/
		n.navigateToFootball();
		/*Validate the table*/
		v.validateTable();
		
		
	}
	
	

}
