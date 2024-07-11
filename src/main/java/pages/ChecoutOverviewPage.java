package pages;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;

public class ChecoutOverviewPage extends TestBase{
	
	
	@FindBy(xpath="//span[contains(text(),'Checkout: Overview')]")
	WebElement checkoutOverview;
	
	@FindBy(id ="finish")
	WebElement finishButton;

	public ChecoutOverviewPage() throws IOException {
		PageFactory.initElements(driver, this);
	}
	
	public CheckoutCompletePage clickFinishButton() throws IOException {
		this.clickOnElement(finishButton);
		return new CheckoutCompletePage();
	}
	
	public boolean verifyCheckoutOverviewPageDisplayed() {
		return this.checkElementIsDisplayed(checkoutOverview);
	}
	
	

}
