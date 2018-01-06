package com.test.pages;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.test.objectRepo.homePage;

public class homePageValidations {
	
	protected WebDriver driver;
	protected WebDriverWait wait;
	
	
	public homePageValidations(WebDriver driver) {
		this.driver = driver;
	}
	
	
	/*
	 * Function Name: check_logo
	 * Description: Check amazon header is displayed and retrieve it
	 * Parameters: none
	 * Return Value: <String> Header text
	 */	
	public String check_logo(){
		return homePage.amazon_logo(driver).getText();
			
	}
	
	
	/*
	 * Function Name: click_object_in_homePage
	 * Description: Click an element on homepage
	 * Parameters: <String> Element to be clicked
	 * Return Value: None
	 */
	public void click_object_in_homePage(String objectName) throws Exception{
		WebElement locator;
		
		switch(objectName)
		{
		case "SearchBox Filter":
			locator= homePage.search_filter_dropdown(driver);
			break;
			
		case "Books":
			locator= homePage.search_filter_option(driver, objectName);
			break;
			
		default:
			System.out.println("Invalid object to be verified");
			throw new Exception("Invalid to be verified");
		}
		
       wait= new WebDriverWait(driver,30);
		
		wait.until(ExpectedConditions.visibilityOf(locator));
		locator.click();	
		
	}
	
	
	/*
	 * Function Name: enter_data_in_searchBox
	 * Description: Enter data in amazon searchbox and press enter
	 * Parameters: <String> Data to be entered
	 * Return Value: None
	 */
	public void enter_data_in_searchBox(String data){
		homePage.search_box(driver).sendKeys(data);
		homePage.search_box(driver).sendKeys(Keys.ENTER);
	}
	

}
