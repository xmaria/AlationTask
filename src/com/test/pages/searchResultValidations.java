package com.test.pages;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.test.objectRepo.searchResult;
import com.test.utility.genericUtility;
import com.test.utility.exportDataToExcel;

public class searchResultValidations {
	
	protected WebDriver driver;
	protected WebDriverWait wait;
	protected Map<String, Object[]> data = new TreeMap<String, Object[]>(); //This data needs to be written (Object[])
	
	
	
	public searchResultValidations(WebDriver driver) {
		this.driver = driver;
	}
	
	
	/*
	 * Function Name: check_search_result_isDisplayed
	 * Description: Check First result result is visible
	 * Parameters: none
	 * Return Value: none
	 */	
	public void check_search_result_isDisplayed(){
		wait= new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOf(searchResult.first_result_item(driver)));
		
	}
	
	
	/*
	 * Function Name: get_book_price_for_different_editions
	 * Description: Get book price different editions and record it
	 * Parameters: none
	 * Return Value: none
	 */	
	public void get_book_price_for_different_editions(){
		genericUtility util= new genericUtility(driver);
		String kindleEditionPrice=null, hardCoverPrice=null, PaperBackPrice=null;
		
		if(util.element_is_present(searchResult.book_kindleEdition())){
			WebElement kindle= driver.findElement(searchResult.book_kindleEdition());
			
			String wholePrice= searchResult.book_priceWholeNumber(kindle).getText();
			String fractionPrice= searchResult.book_priceFractionNumber(kindle).getText();
			
			kindleEditionPrice="$"+wholePrice+"."+fractionPrice;
			System.out.println("kindleEditionPrice-"+kindleEditionPrice);
			data.put("6", new Object[]{"KindleEditionPrice",kindleEditionPrice});
		}
		
		if(util.element_is_present(searchResult.book_hardCover())){
			WebElement hardCover= driver.findElement(searchResult.book_hardCover());
			
			String wholePrice= searchResult.book_priceWholeNumber(hardCover).getText();
			String fractionPrice= searchResult.book_priceFractionNumber(hardCover).getText();
			
			hardCoverPrice="$"+wholePrice+"."+fractionPrice;
			System.out.println("hardCoverPrice-"+hardCoverPrice);
			data.put("4", new Object[]{"HardCoverPrice", hardCoverPrice});
		
		}
		
		if(util.element_is_present(searchResult.book_paperBack())){
			WebElement paperBack= driver.findElement(searchResult.book_hardCover());
			
			String wholePrice= searchResult.book_priceWholeNumber(paperBack).getText();
			String fractionPrice= searchResult.book_priceFractionNumber(paperBack).getText();
			
			PaperBackPrice="$"+wholePrice+"."+fractionPrice;
			System.out.println("PaperBackPrice-"+PaperBackPrice);
			data.put("5", new Object[]{"PaperBackPrice", PaperBackPrice});
		}
		
				
	}
	
	
	/*
	 * Function Name: get_book_title
	 * Description: Get title of the book and record it
	 * Parameters: none
	 * Return Value: none
	 */
	public void get_book_title(){
		String title = searchResult.book_title(driver).getText();
		System.out.println("title-"+title);
		data.put("2", new Object[]{"Book Title",title});
	}
	
	
	/*
	 * Function Name: get_book_author
	 * Description: Get author of the book and record it
	 * Parameters: none
	 * Return Value: none
	 */
	public void get_book_author(){
		String author = searchResult.book_author(driver).getText();
		System.out.println("author-"+author);
		data.put("3", new Object[]{"Author",author});
	}
	
	
	/*
	 * Function Name: get_book_publicationDate
	 * Description: Get publication date of the book and record it
	 * Parameters: none
	 * Return Value: none
	 */
	public void get_book_publicationDate(){
		String publicationDate = searchResult.book_publicationDate(driver).getText();
		System.out.println("publicationDate-"+publicationDate);
		data.put("7", new Object[]{"Publication Date",publicationDate});
	}
	
	
	/*
	 * Function Name: check_if_prime_eligible
	 * Description: Check if book is prime eligible
	 * Parameters: none
	 * Return Value: none
	 */
	public void check_if_prime_eligible(){
		genericUtility util= new genericUtility(driver);
		String primeEligible;
		if(util.element_is_present(searchResult.book_primeEligible())){
			driver.findElement(searchResult.book_primeEligible()).isDisplayed();
			primeEligible="Yes";
		}
		else
			primeEligible="No";
		System.out.println("primeEligible-"+primeEligible);
		data.put("10", new Object[]{"Book is Prime eligible",primeEligible});
	}
	
	
	/*
	 * Function Name: check_customer_rating
	 * Description: Record the customer rating for the book if available
	 * Parameters: none
	 * Return Value: none
	 */
	public void check_customer_rating(){
		genericUtility util= new genericUtility(driver);
		String rating;
		Actions action = new Actions(driver);
		wait= new WebDriverWait(driver,30);
		if(util.element_is_present(searchResult.book_customerRating())){
			action.moveToElement(driver.findElement(searchResult.book_customerRating())).click().build().perform();
			
			rating= wait.until(ExpectedConditions.visibilityOf(driver.findElement(searchResult.book_customerRating_popOver()))).getText();
			
			System.out.println("rating-"+rating);
			data.put("8", new Object[]{"Rating",rating});
		}
	}
		

	/*
	 * Function Name: no_of_customer_reviews
	 * Description: Record the total no of customer reviews for the book if available
	 * Parameters: none
	 * Return Value: none
	 */
	public void no_of_customer_reviews(){
			genericUtility util= new genericUtility(driver);
			String noCusRev;
			if(util.element_is_present(searchResult.book_nofReviews())){
				noCusRev= driver.findElement(searchResult.book_nofReviews()).getText();
				System.out.println("noCusRev-"+noCusRev);
				data.put("9", new Object[]{"No of customer reviews",noCusRev});
			}
		
	}
	
	
	/*
	 * Function Name: storeDataToExcel
	 * Description: Calls writeToExcel() to write all the retrieved data into an excel file
	 * Parameters: none
	 * Return Value: none
	 */
	public void storeDataToExcel() throws FileNotFoundException, IOException{
		exportDataToExcel output= new exportDataToExcel();
		data.put("1", new Object[]{"FIELD", "VALUE"});
		output.writeToExcel(data);
	}
	
	

}
