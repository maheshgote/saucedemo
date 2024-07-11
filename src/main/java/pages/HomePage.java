package pages;
import pages.YourCartPage;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;

public class HomePage extends TestBase {
	
	@FindBy(className="app_logo")
	WebElement logo;
	
	@FindBy(id ="add-to-cart-sauce-labs-backpack")
	WebElement SauceLabsBackpackAddtoCartButton;
	
	@FindBy(linkText ="shopping_cart_link")
	WebElement shoppingCart;
	
	@FindBy(className ="shopping_cart_badge")
	private WebElement shoppingCartBadge;
	

	public HomePage() throws IOException {
		PageFactory.initElements(driver, this);
	}
	
	public void addItemToCart() {
		this.clickOnElement(SauceLabsBackpackAddtoCartButton);
	}
	
	public String getItemCountInCarts() {
		return this.getWebElementText(shoppingCartBadge);
	}
	
	public YourCartPage goToShoppingCart() throws IOException {
		this.clickOnElement(shoppingCartBadge);
		return new YourCartPage();
	}
	
	public boolean checkHomepageDisplayed() {
		return this.checkElementIsDisplayed(logo);
	}
	
	

}
