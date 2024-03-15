package pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.BaseClass;

public class homePage {
	
	
	
	
	public homePage() {
		PageFactory.initElements(BaseClass.getDriver(), this);
	}
	
	
	@FindBy(xpath="//*[@class='n2-ss-slider-3']/div")
	public List<WebElement> threeSliders;
	
	
	@FindBy(xpath="//*[@class='themify_builder_sub_row clearfix gutter-default   sub_row_1-0-2']/div")
	public List<WebElement> ThreeArrivals;
	
	
	@FindBy(xpath="//ul[@class='products']/li")
	public List<WebElement> ThreeArrivalsPages;
	
	
	

}
