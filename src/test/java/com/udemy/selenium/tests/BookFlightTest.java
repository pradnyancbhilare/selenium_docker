package com.udemy.selenium.tests;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.udemy.selenium.base.BaseTest;
import com.udemy.selenium.pages.BuyFlightPage;
import com.udemy.selenium.pages.FindFlightPageAndSelectFlightPage;
import com.udemy.selenium.pages.FlightOrderConfirmationPage;
import com.udemy.selenium.pages.FlightsDetailsPage;
import com.udemy.selenium.pages.NewToursRegistrationPage;
import com.udemy.selenium.pages.RegistrationConfirmationPage;

public class BookFlightTest extends BaseTest{
	
	@Test
	public void registrationPage() {
		NewToursRegistrationPage registrationPage = new NewToursRegistrationPage(this.driver);
		registrationPage.goTo();
		registrationPage.enterUserDetails("selenium", "docker");
		registrationPage.enterUserCredentials("selenium", "docker");
		registrationPage.submitRegistrationPage();
	}
	
	@Test(dependsOnMethods = "registrationPage")
	public void registrationConfirmationPage() {
		RegistrationConfirmationPage regConfirmationPage = new RegistrationConfirmationPage(this.driver);
		regConfirmationPage.goToFlightDetailsPage();
	}
	
	@Test(dependsOnMethods = "registrationConfirmationPage")
	@Parameters("numberOfPassengers")
	public void flightDetailsPage(String numberOfPassengers) {
		FlightsDetailsPage flightDetailsPage = new FlightsDetailsPage(this.driver);
		flightDetailsPage.selectPassengers(numberOfPassengers);
		flightDetailsPage.goToFindFlightsPage();		
	}
	
	@Test(dependsOnMethods = "flightDetailsPage")
	public void findFlightPage() {
		FindFlightPageAndSelectFlightPage selectFightPage = new FindFlightPageAndSelectFlightPage(this.driver);
		selectFightPage.submitFindFlightPage();
	}
	
	@Test(dependsOnMethods = "findFlightPage")
	public void buyFlightPage() {
		BuyFlightPage buyFightPage = new BuyFlightPage(this.driver);
		buyFightPage.goToFlightConfirmationPage();
	}
	
	@Test(dependsOnMethods = "buyFlightPage")
	public void flightConfirmationPage() {
		FlightOrderConfirmationPage confirmationPage = new FlightOrderConfirmationPage(this.driver);
		String price = confirmationPage.getConfirmationNumberAndPrice();
		Assert.assertNotNull(price);
	}	

}
