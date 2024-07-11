package pages;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;

public class YourCartPage extends TestBase{

	@FindBy(xpath="//span[contains(text(),'Your Cart')]")
	WebElement yourCartPage;
		
	@FindBy(id ="checkout")
	WebElement checkoutButton;
	
	@FindBy(className ="inventory_item_name")
	WebElement inventoryItemName;
	
	

	public YourCartPage() throws IOException {
		PageFactory.initElements(driver, this);
	}
	
	
	public String getInventoryItemName() {
		String ItemName = inventoryItemName.getText();
		return ItemName;
	}
	
	public UserInformationPage clickCheckoutButton() throws IOException {
		this.clickOnElement(checkoutButton);
		return new UserInformationPage();
		
	}
	
	
	

}
