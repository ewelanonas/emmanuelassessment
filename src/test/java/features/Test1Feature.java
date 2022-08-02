package features;

import java.io.IOException;

import io.cucumber.java.en.*;
import testcases.Test1;
import testcases.Functions.*;

public class Test1Feature extends Test1{

	Test1 t1 = new Test1();
	Navigations n = new Navigations();
	Validations v = new Validations();

	@Given("User on the home website page of https:\\/\\/www.dailymail.co.uk\\/home\\/index.html")
	public void user_on_the_home_website_page_of_https_www_dailymail_co_uk_home_index_html() throws IOException {
		System.out.println("Opening the browser and accessing the site");
		t1.setUp();
	}

	@When("User validate the time and date are correct")
	public void and_user_validate_the_time_and_date_are_correct() throws IOException {
		// Write code here that turns the phrase above into concrete actions
		System.out.println("Validating the time and date");
		v.validateDateandTime();
	}

	@Then("the test is passed")
	public void the_test_is_passed() {
		// Write code here that turns the phrase above into concrete actions
		t1.tearDown();
		System.out.println("Validation is passed");
	}

	@And("Navigate to sports tab")
	public void navigate_to_sports_tab() {

		System.out.println("Navigated to sports tab");
	}

	@When("User validates the color is matched")
	public void user_validates_the_color_is_matched() throws IOException {
		System.out.println("Validating the color");
		v.validateColor();
		System.out.println("Validated");
	}
	
	@And("User will navigate to football tab")
	public void user_will_navigate_to_football_tab() {
		System.out.println("Navigate to Football tab");
	}
	@And ("User will go to first article")
	public void user_will_go_to_first_article() {
		System.out.println("Navigate to Article Page");
	}
	@And("User will click the first image and check the images")
	public void user_will_click_the_first_image_and_check_the_images() throws IOException {
		n.navigateToArticleImage();
		System.out.println("Navigated to Article Image");
	}
	
	@When("User validate the image is different from other image")
	public void user_validate_the_image_is_different_from_other_image() throws IOException, InterruptedException {
		System.out.println("Validating the Image");
		v.validateImage();
		System.out.println("Validated");
	}
	
	@Given("User will direct go to the article with video")
	public void user_will_direct_go_to_the_article_with_video() throws IOException {
		System.out.println("Opening the browser and Directing to the Article with Video");
		t1.setUpForStep4();
	}
	@And("User will go to first video with expand feature")
	public void user_will_go_to_first_video_with_expand_feature() {
		System.out.println("Article with Video accessed");
	}
	
	@When("User validate the video can be expanded")
	public void user_validate_the_video_can_be_expanded() throws IOException {
		v.validateExpandVideo();
	}
	
	@And("User will navigate to Sports tab to football tab")
	public void user_will_navigate_to_Sports_tab_to_football_tab() {
		System.out.println("Navigating to football article page");
		n.navigateToFootball();
		System.out.println("Navigated to football page");
	}
	
	@When("User validates and captures the table")
	public void user_validates_and_captures_the_table() throws IOException {
		System.out.println("Validating to table");
		v.validateTable();
		System.out.println("Validated");
	}
}
