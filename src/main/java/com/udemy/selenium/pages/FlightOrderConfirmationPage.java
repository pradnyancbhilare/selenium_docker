package com.udemy.selenium.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FlightOrderConfirmationPage {
	
	//private WebDriver driver;
	private WebDriverWait wait;
	
	@FindBy(xpath = "//font[contains(text(), 'Confirmation')]")
	private WebElement orderConfirmationNoLbl;
	@FindBy(xpath = "//font[contains(text(), 'USD')]")
	private List<WebElement> flightPriceLbls;
	@FindBy(linkText = "SIGN-OFF")
	private WebElement signOffLink;
	
	public FlightOrderConfirmationPage(WebDriver driver) {
		//this.driver = driver;
		this.wait = new WebDriverWait(driver, 30);
		PageFactory.initElements(driver, this);
	}
	
	public String getConfirmationNumberAndPrice() {
		this.wait.until(ExpectedConditions.visibilityOf(this.orderConfirmationNoLbl));
		System.out.println("The order confirmation number is " + this.orderConfirmationNoLbl.getText());
		System.out.println("The order price is " + this.flightPriceLbls.get(1).getText());
		String price = this.flightPriceLbls.get(1).getText();
		this.signOffLink.click();
		return price;
	}

}
