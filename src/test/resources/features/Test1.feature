#Author: elanonas@gmail.com
#Keywords Summary : This keyword is to execute scenarios based on cucumber
#Feature:
# 1. validating time and date
Feature: Validating the assessment for Test1

  Scenario: Validate Time and Date
    Given User on the home website page of https://www.dailymail.co.uk/home/index.html
    When User validate the time and date are correct
    Then the test is passed

  Scenario: Validate Color Tabs
    Given User on the home website page of https://www.dailymail.co.uk/home/index.html
    And Navigate to sports tab
    When User validates the color is matched
    Then the test is passed

  	Scenario: Validate Image of the Article
    Given User on the home website page of https://www.dailymail.co.uk/home/index.html
    And Navigate to sports tab
    And User will navigate to football tab
    And User will go to first article
    And User will click the first image and check the images
    When User validate the image is different from other image
    Then the test is passed
    
    Scenario: Validate Expand Feature of Article Video
    Given User will direct go to the article with video
    And User will go to first video with expand feature
    When User validate the video can be expanded
    Then the test is passed
    
    Scenario: Validate the Tournament Table
    Given User on the home website page of https://www.dailymail.co.uk/home/index.html
    And User will navigate to Sports tab to football tab
    When User validates and captures the table
    Then the test is passed