package com.test.base;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Parameters;
import org.openqa.selenium.chrome.ChromeDriver;


public class TestBaseSetup {
	
	private WebDriver driver;
	
	static String driverPath = "src/chromedriver";

			public WebDriver getDriver() {
				return driver;
			}

			private void setDriver(String browserType, String appURL) {
				switch (browserType) {
				case "chrome":
					driver = initChromeDriver(appURL);
					break;
				case "firefox":
					driver = initFirefoxDriver(appURL);
					break;
				default:
					System.out.println("browser : " + browserType
							+ " is invalid, Launching Firefox as browser of choice..");
					driver = initFirefoxDriver(appURL);
				}
			}

			private static WebDriver initChromeDriver(String appURL) {
				System.out.println("Launching google chrome with new profile..");
				System.setProperty("webdriver.chrome.driver", driverPath);
				WebDriver driver = new ChromeDriver();
				driver.manage().window().maximize();
				driver.navigate().to(appURL);
				return driver;
			}

			private static WebDriver initFirefoxDriver(String appURL) {
				System.out.println("Launching Firefox browser..");
				WebDriver driver = new FirefoxDriver();
				driver.manage().window().maximize();
				driver.navigate().to(appURL);
				return driver;
			}

			@Parameters({ "browserType", "appURL" })
			@BeforeClass
			public void initializeTestBaseSetup(String browserType, String appURL) {
				try {
					setDriver(browserType, appURL);

				} catch (Exception e) {
					System.out.println("Error....." + e.getStackTrace());
				}
			}
			
			@AfterClass
			public void tearDown() {
				driver.quit();
			}
		}

