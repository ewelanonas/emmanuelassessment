#Author: elanonas@gmail.com
#Keywords Summary : This keyword is to execute scenarios based on cucumber
#Feature: 
# 1. validating time and date
# 2. validating color tabs
# 3. validating article images
# 4. validating article video - possible separate run, since most of the articles don't have videos included
# 5. validating the table

Feature: Validating the assessment for Test1

  Scenario: Validate Time and Date
    Given user on the home website page of https://www.dailymail.co.uk/home/index.html 
    And user checks if it time and date are existing
    When and user validate the time and date are correct
    Then the test is passed
    And user returns back to main site

  Scenario: Validate Color Tabs
    Given I want to validate the color tabs between sports tab and secondary tab
    And I check if it is the same color
    When I validate the color is matched
    Then the test is passed
   
  Scenario: Validate Article Image
    Given I want to validate the Article Image
    And I want to navigate to the first article
    And validate if the article image is matched
    When I validate the image is different from other image
    Then the test is passed

  Scenario: Validate Article Video
    Given I want to validate the video expand feature
    And I validate if the video is existing
    When I validate the video can be expanded
    Then the test is passed

  Scenario: Validate the Tournament Table
    Given I want to validate the tournament table
    And I validate navigate football tab
    When I validate the table is captured
    Then the test is passed
    
