package com.udemy.selenium.base;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.udemy.selenium.gogoduck.tests.SearchTest;

public class BaseTest {
	
	protected WebDriver driver;
	
	@BeforeTest
	public void setupDriver(ITestContext ctx) throws MalformedURLException {
		// Browser => Chrome or Firefox
		// HUB_HOST => locahost / 10.0.1.3 / hostname
		
		String host = "localhost";
		DesiredCapabilities dc;
		
		if(System.getProperty("BROWSER") != null && 
				System.getProperty("BROWSER").equalsIgnoreCase("firefox")) {
			
			dc = DesiredCapabilities.firefox();
		}else {
			dc = DesiredCapabilities.chrome();
		}
		
		if(System.getProperty("HUB_HOST") != null) {
			host = System.getProperty("HUB_HOST");
		}
		
		String completeUrl = "http://" + host + ":4444/wd/hub";
		String testName = ctx.getCurrentXmlTest().getName();
		dc.setCapability("name", testName);
		this.driver = new RemoteWebDriver(new URL(completeUrl), dc);
		
		//System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver");
		//this.driver = new ChromeDriver();		
	}
	
	@AfterTest
	public void tearDownTest() {
		System.out.println(SearchTest.class.getSimpleName() + " Completed");
		this.driver.quit();
	}

}
