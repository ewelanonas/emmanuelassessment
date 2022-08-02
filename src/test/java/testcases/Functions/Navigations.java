package testcases.Functions;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.Reporter;

import base.BaseTest;

public class Navigations extends BaseTest {
	public static BaseTest bt = new BaseTest();
	public static Navigations n = new Navigations();
	
	public void navigateToArticleImage() throws IOException{
		n.navigateToArticle();
		((JavascriptExecutor) driver).executeScript("window.scrollBy(0,1500)");
		System.out.println("Navigate to Article Image");
		
		try {
			WebElement articleimg = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loc.getProperty("firstImage"))));
			
			if(articleimg.isDisplayed()) {
				driver.findElement(By.xpath(loc.getProperty("firstImage"))).click();
				System.out.println("Article's first image successfully accessed.");
				Reporter.log("Article's first image successfully accessed.");
			}
		} catch (Exception e) {
			bt.takeScreenshot();
			Assert.assertTrue(false, "Article image not found. Kindly check the article manually, since it wasn't existing in the UI");
			
		}
				
	}
	
	public void navigateToArticle() {
		n.navigateToFootball();
		System.out.println("Navigate to Article");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loc.getProperty("firstarticle"))));
		driver.findElement(By.xpath(loc.getProperty("firstarticle"))).click();
		System.out.println("Navigate to the article successfully");
	}
	
	public void navigateToFootball() {
		System.out.println("Navigate to Football");
		driver.findElement(By.xpath(loc.getProperty("Sports_text"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loc.getProperty("Football_text"))));
		driver.findElement(By.xpath(loc.getProperty("Football_text"))).click();
	}

}
