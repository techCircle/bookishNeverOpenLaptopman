package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import Utilities.RetryAnalyzer;
import Utilities.commonMethods;

public class homePageTest extends commonMethods {


	@Test(retryAnalyzer = RetryAnalyzer.class)
	public void homePageWithThreeSlidersOnly() throws InterruptedException {
		cP.selectMainNavOption("shop");
		commonMethods.click(sP.homeButton);
		Assert.assertTrue(hP.threeSliders.size() == 3);
		//
	}
	
	
	@Test(retryAnalyzer = RetryAnalyzer.class)
	public void testingRetry() {
			Assert.assertTrue(true);
	}

	@Test
	public void homePageWithThreeArrivalsOnlyTest() {
		cP.selectMainNavOption("shop");
		commonMethods.click(sP.homeButton);
		Assert.assertTrue(hP.ThreeArrivals.size() == 3);	
	}
	
	
	@Test
	public void  homePageImagesInArrivalsShouldNavigate() {

		commonMethods.scrollToElement(hP.ThreeArrivalsPages.get(0));
		commonMethods.click(hP.ThreeArrivalsPages.get(0));
		commonMethods.paolaWait(4);
		pP.addToBasketButton.click();
		Assert.assertTrue(pP.commerceMessage.getText().contains("has been added to your basket"));
		commonMethods.click(sP.homeButton);
		
	//7) Now click the image in the Arrivals
	//8) Test whether it is navigating to next page where the user can add that book into his basket.
	//9) Image should be clickable and shoul navigate to next page where user can add that book to his basket
	}
	
	
	
}
