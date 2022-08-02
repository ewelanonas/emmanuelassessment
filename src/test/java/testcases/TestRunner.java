package testcases;
import org.junit.runner.RunWith;

import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.*;

@RunWith(Cucumber.class)
@CucumberOptions(
		features="src/test/resources/features", 
		glue= {"features"},
		monochrome = true,
		plugin = {"pretty","html:src/test/resources/reports/HtmlReports"})
public class TestRunner {

}
