# emmanuelassessment
This is for DMG Media Automation Assessment

1. Combo framework used:
  - Cucumber JVM (for Test 1)
  - TestNG (Test 1 and Test 2)
  - Selenium Webdriver
  - Maven dependencies
  
2. OOP approach used:
 - Inheritance
 - For future enhancement (Aplogies for not applying, since I'm still new with Cucumber and time constraints given) - Encapsulation and Abstraction

### PRE-REQUISITE ###
 - Eclipse IDE
  - need to install plugins (Help > Install New Software)
   - Enter the update site URL in "Work with :" field:
    I. TestNG: https://testng.org/testng-eclipse-update-site
    II. Cucumber: https://cucumber.github.io/cucumber-eclipse/update-site
 - Maven and JRE (I used Java 16) should be installed in the asset 
 - Maven dependencies are already in the project. I'll explain the details after the instruction of "How to Run the Test"
 
### HOW TO RUN THE TEST ###
1. TestNG for Test1 and Test2 (TestNG needs to be installed)
 - go to testng.xml > right click > Run As > TestNG Suite
 - Note: Step 4 is enabled=false, since I already mentioned to Tashan, that most of the articles doesn't have video feature similar with the aseesement page.
 - in order to enable it, simple change to enabled = true, then make false to all of the methods under src/test/java > testcases > Test1
 - Reports generated under test-outputs > index.html
 - for Test1.validateTable() html report located at the project folder saying "report.html"
 
2. TestNG for Test2 Only
 - src/test/java > testcases > Test2
 - then right click > Run As > TestNG Test to perform
 Note: this is also includes negative testing, which is expected to be passed, if the expected code will be displayed
 - Reports generated only on Logs
 
 3. Run as Cucumber JVM (I only include Test1 only, since the data used for Test2 is integrated with TestNG DataProvider, but I'll check also if we could integrate with Cucumber.
  - src/test/java > testcases > Test Runner
  - right click > Run As > JUnit
  - Note: for Step 5, I misinstruct the html report, later found out that I can integrate it with Cucumber, for now, I just created a html report for extent reports (Apologies)
  - Reports generated under src/test/resource > reports > HtmlReports > index.html

### Dependencies ###
 Maven Dependencies used:
 - selenium java 4.3
 - testng 6.14.3 (for Test Listeners to function, that's why I don't use the latest one)
 - log4j for proper report
 - apache poi - required for TDD
  - xmlbeans
  - apache commons
 - bonigarcia for webdrivers dependencies
 - aventstack extent reports
 - cucumber java 5.7
 - junit 5.7
 - cucumber junit 5.7
 - rest assured - for api automation
 - json-simple, to make for rest assured more simplified when it comes for hashmaps of objects
 
### Source ###
 1. src/test/java
    a. base
      1. BaseTest - contains the setup and teardown for the test cases given
      2. TestListeners - contains the report needs to have for testng in order to generate in the report
    b. features
      1. Test1feature - contains the script based on the Cucumber feature
    c. testcases
      1. Test1 - main of test1 test case
      2. Test2 - main of test2 test case
      3. TestRunner - main of running the cucumber for test1
    d. testcases.functions
      1. Navigations - contain methods where navigation action are called
      2. Validations - contain methods where validation process action are called
    e. utilities
      1. ReadXLSData - contains process of TDD to read data from excel file
      2. ScreenshotUtil - contains process of Screenshot
 2. src/test/resources
  a. configfiles
    1. config.properties - configuration properties are stored
    2. locator.properties - locators of xpaths and other elements stored
  b. features
    1. Test1.feature - this is where cucumber feature is stored
  c. reports
    1. HtmlReports - this is where cucumber report is stored
  d. testdata
    1. TestData.xlsx - this is where testdata is stored and being read by Test2 (API)
 3. Screenshot - being stored if the if one of the testcases failed
 4. report.html - Step5 (Validate the tournament table) report generation
  
