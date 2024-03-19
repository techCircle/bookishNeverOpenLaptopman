package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.BaseClass;

public class productPage {
	
	
	public productPage() {
		PageFactory.initElements(BaseClass.getDriver(), this);
	}
	
	
	@FindBy(xpath="//button[@class='single_add_to_cart_button button alt']")
	public WebElement addToBasketButton;
	
	
	@FindBy(xpath="//div[@class='woocommerce-message']")
	public WebElement commerceMessage;

}
