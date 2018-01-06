package com.test.objectRepo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class searchResult {
	
	private static WebElement element = null;
	private static By locator = null;
	
	public static WebElement first_result_item(WebDriver driver){
		 
	    element = driver.findElement(By.xpath("//div[@id='atfResults']//li[1]"));
	 
	    return element;
	 
	    }
	
	public static WebElement book_title(WebDriver driver){
		 
	    element = driver.findElement(By.xpath("//div[@id='atfResults']//li[1]//h2"));
	 
	    return element;
	 
	    }
	
	public static WebElement book_publicationDate(WebDriver driver){
		 
	    element = driver.findElement(By.xpath("//div[@id='atfResults']//li[1]//h2//parent::a//following-sibling::span[string-length(text()) > 0]"));
	 
	    return element;
	 
	    }
	public static WebElement book_author(WebDriver driver){
		 
	    element = driver.findElement(By.xpath("//div[@id='atfResults']//li[1]//span[text()='by ']//following-sibling::span"));
	 
	    return element;
	 
	    }
	
	public static By book_primeEligible(){
		 
	    locator = By.xpath("//div[@id='atfResults']//li[1]//i[contains(@class,'a-icon-prime')]");
	 
	    return locator;
	 
	    }
	
	public static By book_kindleEdition(){
		 
	    locator = By.xpath("//div[@id='atfResults']//li[1]//a[@title='Kindle Edition']//parent::div//following-sibling::div[1]");
	 
	    return locator;
	 
	    }
	
	public static By book_hardCover(){
		 
	    locator = By.xpath("//div[@id='atfResults']//li[1]//a[@title='Hardcover']//parent::div//following-sibling::div[1]");
	 
	    return locator;
	 
	    }
	
	public static By book_paperBack(){
	    locator = By.xpath("//div[@id='atfResults']//li[1]//a[@title='Paperback']//parent::div//following-sibling::div[1]");
	 
	    return locator;
		 
	    }
	
	public static WebElement book_priceWholeNumber(WebElement parent){
		 
	    element = parent.findElement(By.xpath("//span[@class='sx-price-whole']"));
	 
	    return element;
	 
	    }
	
	public static WebElement book_priceFractionNumber(WebElement parent){
		 
	    element = parent.findElement(By.xpath("//sup[@class='sx-price-fractional']"));
	 
	    return element;
	 
	    }
	
	public static By book_customerRating(){
		 
	    locator = By.xpath("//div[@id='atfResults']//li[1]//i[contains(@class,'a-icon-star')]/span");
	 
	    return locator;
	 
	    }
	
	public static By book_customerRating_popOver(){
		 
	    locator = By.xpath("//div[@class='a-popover-content']//span[contains(@class,'a-color-secondary')]");
	
	    		return locator;
	}
	
	public static By book_nofReviews(){
		 
	    locator = By.xpath("//div[@id='atfResults']//li[1]//i[contains(@class,'a-icon-star')]//ancestor::div[1]/a");
	 
	    return locator;
	 
	    }
	
	
	
	

}
