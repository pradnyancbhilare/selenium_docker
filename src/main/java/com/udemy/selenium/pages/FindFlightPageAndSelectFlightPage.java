package com.udemy.selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FindFlightPageAndSelectFlightPage {

	//private WebDriver driver;
	private WebDriverWait wait;
	
	@FindBy(name = "reserveFlights")
	private WebElement reserveFlightsBtn;
	
	public FindFlightPageAndSelectFlightPage(WebDriver driver) {
		//this.driver = driver;
		this.wait = new WebDriverWait(driver, 30);
		PageFactory.initElements(driver, this);
	}
	
	public void submitFindFlightPage() {
		this.wait.until(ExpectedConditions.elementToBeClickable(this.reserveFlightsBtn));
		this.reserveFlightsBtn.click();
	}

}
