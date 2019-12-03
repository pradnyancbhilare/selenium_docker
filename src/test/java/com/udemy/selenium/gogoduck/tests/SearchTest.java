package com.udemy.selenium.gogoduck.tests;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.udemy.selenium.base.BaseTest;
import com.udemy.selenium.gogoduck.pages.GoToVideos;
import com.udemy.selenium.gogoduck.pages.SearchPage;

public class SearchTest extends BaseTest{

	@Test
	@Parameters({"searchText"})
	public void searchPage(String searchText) {
		SearchPage searchPage = new SearchPage(this.driver);
		searchPage.goTo();
		searchPage.searchText(searchText);
	}
	
	@Test(dependsOnMethods = "searchPage")
	public void searchResultPage() {
		GoToVideos videos = new GoToVideos(this.driver);
		videos.goToVideos();
		int noOfVideos = videos.printResult();
		Assert.assertTrue(noOfVideos > 0);
	}

}
