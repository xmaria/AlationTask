package com.test.utility;


import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class genericUtility {
	
	protected WebDriver driver;
	
	public genericUtility(WebDriver driver) {
		this.driver = driver;
	}
	
	
	/*
	 * Function Name: element_is_present
	 * Description: Check if an element is present in DOM
	 * Parameters: <WebElement>
	 * Return Value: <Boolean>
	 */	
	public boolean element_is_present(By locator)
	{
		try
        {
			driver.findElement(locator);
            return true;
        }
        catch (NoSuchElementException e)
        {
            return false;
        }
	}
	
	

}
