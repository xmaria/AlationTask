package com.test.objectRepo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class homePage {

private static WebElement element = null;
	
	public static WebElement amazon_logo(WebDriver driver){
		 
	    element = driver.findElement(By.xpath("//span[contains(@class,'nav-logo-base')]"));
	 
	    return element;
	 
	    }
	
	public static WebElement search_filter_dropdown(WebDriver driver){
		 
	    element = driver.findElement(By.xpath("//span[@class='nav-search-label']"));
	 
	    return element;
	 
	    }
	
	public static WebElement search_filter_option(WebDriver driver,String filterOption){
		 
	    element = driver.findElement(By.xpath("//select[@id='searchDropdownBox']//option[text()='"+filterOption+"']"));
	 
	    return element;
	
	    }
	
	public static WebElement search_box(WebDriver driver){
		 
	    element = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
	 
	    return element;
	
	    }
}
