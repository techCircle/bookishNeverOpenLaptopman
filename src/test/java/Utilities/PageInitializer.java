package Utilities;

import pages.commonPage;
import pages.homePage;
import pages.productPage;
import pages.shopPage;

public class PageInitializer extends BaseClass {
	
	
	public static commonPage cP;
	public static shopPage sP;
	public static homePage hP;
	public static productPage pP;
		
	
	public static void initialize() {
		cP = new commonPage();
		sP = new shopPage();
		hP = new homePage();
		pP = new productPage();
	}
	
	
	
	
	
	
	
	
	
	
	

}
