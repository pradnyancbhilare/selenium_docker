package com.udemy.selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FlightsDetailsPage {

	//private WebDriver driver;
	private WebDriverWait wait;
	
	@FindBy(name = "passCount")
	private WebElement passengerDD;
	@FindBy(name = "findFlights")
	private WebElement continueBtn;
	
	public FlightsDetailsPage(WebDriver driver) {
		//this.driver = driver;
		this.wait = new WebDriverWait(driver, 30);
		PageFactory.initElements(driver, this);
	}
	
	public void selectPassengers(String count) {
		this.wait.until(ExpectedConditions.elementToBeClickable(this.passengerDD));
		Select select = new Select(this.passengerDD);
		select.selectByValue(count);
	}
	
	public void goToFindFlightsPage() {
		this.continueBtn.click();
	}
	
}
