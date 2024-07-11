package pages;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;

public class CheckoutCompletePage extends TestBase{
	
	@FindBy(xpath="//span[contains(text(),'Checkout: Complete!')]")
	WebElement checkoutComplete;
	
	@FindBy(xpath="//h2[text()=\"Thank you for your order!\"]")
	WebElement thankYouForOrder;
	

	public CheckoutCompletePage() throws IOException {
		PageFactory.initElements(driver, this);
	}
	
	public String verifyCheckoutCompletePageDisplayed() {
//		return this.checkElementIsDisplayed(thankYouForOrder);
		return this.getWebElementText(thankYouForOrder);
		
	}

}
