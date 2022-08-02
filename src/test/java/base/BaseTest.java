package base;
import java.io.File;
/*Utilities*/
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;
import java.util.TimeZone;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

/*Selenium Webdriver*/
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
/*TestNG*/
import org.testng.annotations.*;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;
import testcases.Test1;

public class BaseTest {

	/* Class Instantiation and creating new objects*/
	public static WebDriver driver;
	public static Properties prop = new Properties();
	public static Properties loc = new Properties();
	public static Properties p = new Properties();
	public static FileReader fr;
	public static FileReader locator;
	public static FileWriter fw;
	public static WebDriverWait wait;
	public static Calendar calendar = new GregorianCalendar();
	public static Date getcurrentdate = new Date();
	public static Date date = calendar.getTime();
	public static String screenshotfilename = getcurrentdate.toString().replace(" ", "_").replace(":", "-");
	public static String screenshotpath = System.getProperty("user.dir")+"//screenshot/screenshot_"+screenshotfilename+".png";
	public static SimpleDateFormat date1 = new SimpleDateFormat("EEEE, MMM ");
	public static SimpleDateFormat date2 = new SimpleDateFormat("d");
	public static SimpleDateFormat date3 = new SimpleDateFormat("YYYY");
	public static SimpleDateFormat date4 = new SimpleDateFormat("ha");
	public static TimeZone London = TimeZone.getTimeZone("Europe/London");
	public static JavascriptExecutor js = ((JavascriptExecutor) driver);
	public static WebElement element;
	public static File file = new File("report.html");//System.getProperty("user.dir")+prop.getProperty("reportdir")
	public static String value;
	public static String value2;
	public static String value3;

	@BeforeMethod 
	public void setUp() throws IOException {

		if(driver == null) {
			fr = new FileReader(System.getProperty("user.dir")+"\\src\\test\\resources\\configfiles\\config.properties");
			locator = new FileReader(System.getProperty("user.dir")+"\\src\\test\\resources\\configfiles\\locators.properties");

			prop.load(fr);
			loc.load(locator);
		}

		if(prop.getProperty("browser").equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}

		else if(prop.getProperty("browser").equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}

		else if(prop.getProperty("browser").equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
		
		driver.get(prop.getProperty("url"));
		System.out.println("Site accessed");
		driver.manage().window().maximize();
		wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loc.getProperty("information_process_class"))));
		WebElement message = driver.findElement(By.xpath(loc.getProperty("information_process_class")));

		if(message.isDisplayed()) {
			driver.findElement(By.xpath(loc.getProperty("got_it_button"))).click();
		}


	}

	@AfterMethod
	public void tearDown() {

		driver.quit();
		System.out.println("Browser is successfully closed");
	}

	@BeforeTest
	public void verifyDateSetup() throws IOException{
		/*Setup for additional properties*/
		fw = new FileWriter(System.getProperty("user.dir")+"\\src\\test\\resources\\configfiles\\config.properties",true);

		TimeZone.getDefault().useDaylightTime();
		TimeZone.getDefault().inDaylightTime( calendar.getTime() );

		/*Set Timezone*/
		date1.setTimeZone(London);
		date2.setTimeZone(London);
		date3.setTimeZone(London);
		date4.setTimeZone(London);

		/*Month*/
		String month = date1.format(calendar.getTime());

		/*day*/
		int day = Integer.parseInt(date2.format(date));
		String dayStr = day + suffixes[day] + " ";


		/*Year*/
		String year = date3.format(calendar.getTime());


		/*Time AM/PM*/
		calendar.add(Calendar.HOUR, -2);
		String time = date4.format(calendar.getTime());

		String datefinal = month + dayStr + year;

		/*storing*/
		p.setProperty("time_validation", time);
		p.setProperty("date_validation", datefinal);
		p.store(fw, "storing date and time before running");

		System.out.println("Storing date in properties");
	}

	static String[] suffixes =
			//    0     1     2     3     4     5     6     7     8     9
		{ "th", "st", "nd", "rd", "th", "th", "th", "th", "th", "th",
				//    10    11    12    13    14    15    16    17    18    19
				"th", "th", "th", "th", "th", "th", "th", "th", "th", "th",
				//    20    21    22    23    24    25    26    27    28    29
				"th", "st", "nd", "rd", "th", "th", "th", "th", "th", "th",
				//    30    31
				"th", "st" };

	public void takeScreenshot() throws IOException {
		File takescreenshots = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(takescreenshots,new File(screenshotpath));
	}

	public void scrollDown() {
		js.executeScript("window.scrollBy(0,1000)");
	}

	public void setUpForStep4() throws IOException {

		if(driver == null) {
			fr = new FileReader(System.getProperty("user.dir")+"\\src\\test\\resources\\configfiles\\config.properties");
			locator = new FileReader(System.getProperty("user.dir")+"\\src\\test\\resources\\configfiles\\locators.properties");

			prop.load(fr);
			loc.load(locator);
		}

		if(prop.getProperty("browser").equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}

		else if(prop.getProperty("browser").equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}

		else if(prop.getProperty("browser").equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}

		driver.get(prop.getProperty("urlvid"));
		System.out.println("Site accessed");
		driver.manage().window().maximize();
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loc.getProperty("information_process_class"))));
		WebElement message = driver.findElement(By.xpath(loc.getProperty("information_process_class")));

		if(message.isDisplayed()) {
			driver.findElement(By.xpath(loc.getProperty("got_it_button"))).click();
		}
	}
}

