package com.test.scenarios;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.test.base.TestBaseSetup;
import com.test.pages.homePageValidations;
import com.test.pages.searchResultValidations;

public class verifyAmazonSearchResult extends TestBaseSetup{
	
private WebDriver driver;
	
	@BeforeClass
	public void setUp() {
		driver=getDriver();
	}
	
	@Test
	public void verifyHomePageAndSearch() throws Exception{
		System.out.println("Home page test...");
		homePageValidations homePage = new homePageValidations(driver); //Object to access homePageValidation functions
		searchResultValidations searchResult= new searchResultValidations(driver); //Object to access searchResultValidation functions
		
		Assert.assertEquals(homePage.check_logo(), "Amazon");
		homePage.click_object_in_homePage("SearchBox Filter");
		homePage.click_object_in_homePage("Books");
		homePage.enter_data_in_searchBox("data catalog");
		searchResult.check_search_result_isDisplayed();
		searchResult.get_book_title();
		searchResult.get_book_publicationDate();
		searchResult.get_book_author();
		searchResult.get_book_price_for_different_editions();
		searchResult.check_if_prime_eligible();
		searchResult.check_customer_rating();
		searchResult.no_of_customer_reviews();
		searchResult.storeDataToExcel();
		
		
	}

}
