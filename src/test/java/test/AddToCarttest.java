package test;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import base.TestBase;
import pages.CheckoutCompletePage;
import pages.HomePage;
import pages.LoginPage;
import pages.UserInformationPage;
import pages.YourCartPage;

public class AddToCarttest extends TestBase{
	
	LoginPage loginpage;
	HomePage homepage;
	YourCartPage yourcartpage;
	UserInformationPage userinformationpage;
	CheckoutCompletePage checkoutcompletepage;
	SoftAssert softAssert;

	public AddToCarttest() throws IOException {
		super();
		softAssert= new SoftAssert();
	}
	
	@BeforeSuite
	public void setup() throws IOException {
		initialize();
		loginpage = new LoginPage();
		
	}
	
	@Test(priority=1)
	public void validateCartValueShown() throws IOException {
		homepage= loginpage.login("standard_user", "secret_sauce");
		homepage.addItemToCart();
		String value = homepage.getItemCountInCarts();
		System.out.println(value);
		Assert.assertEquals(Integer.parseInt(value), 1);
	}
	
	@Test(priority=2,dependsOnMethods = { "validateCartValueShown" })
	public void validateYourCartPage() throws IOException {
//		homepage= loginpage.login("standard_user", "secret_sauce");
//		homepage.addItemToCart();
		yourcartpage = homepage.goToShoppingCart();
		String itemName = yourcartpage.getInventoryItemName();
		Assert.assertEquals(itemName, "Sauce Labs Backpack");
	}
	
	@Test(priority=3,dependsOnMethods = { "validateYourCartPage" })
	public void validateUserInformationPage() throws IOException {
		userinformationpage =yourcartpage.clickCheckoutButton();
		boolean userinfopagedisplayed = userinformationpage.verifyUserInfromationPageDisplayed();
		Assert.assertEquals(userinfopagedisplayed, true);
//		driver.quit();
	}
	
	
	@AfterSuite
	public void teardown() {
		driver.quit();
		System.out.println("tes");
	}
	
	@AfterTest
	public void teardown2() {
		driver.close();
		System.out.println("tes");
		
	}

}
