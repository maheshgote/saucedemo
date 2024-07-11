package test;

import java.io.IOException;

import java.util.HashMap;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.TestBase;
import pages.HomePage;
import pages.LoginPage;
import pages.UserInformationPage;
import pages.YourCartPage;
import pages.CheckoutCompletePage;
import pages.ChecoutOverviewPage;
import org.testng.asserts.SoftAssert;
public class CheckoutOverviewtest extends TestBase{
	
	LoginPage loginpage;
	HomePage homepage;
	YourCartPage yourcartpage;
	ChecoutOverviewPage checkoutoverviewpage;
	UserInformationPage userinformationpage;
	CheckoutCompletePage checkoutcompletepage;
	SoftAssert softAssert;
	

	public CheckoutOverviewtest() throws IOException {
		super();
		softAssert= new SoftAssert();
		// TODO Auto-generated constructor stub
	}
	
	
//	@BeforeSuite
//	public void setup() throws IOException {
//		initialize();
//		loginpage = new LoginPage();
//		
//	}
	
	@BeforeMethod
	public void setup() throws IOException {
		initialize();
		loginpage = new LoginPage();
		
	}
	
	@Test
	public void validatecheckout() throws IOException {
		homepage= loginpage.login("standard_user", "secret_sauce");
		homepage.addItemToCart();
		softAssert.assertTrue(homepage.checkHomepageDisplayed());
		yourcartpage = homepage.goToShoppingCart();
		userinformationpage =yourcartpage.clickCheckoutButton();
		userinformationpage.fillUserInformation("sachin", "Tendulkar", "5545");
		checkoutoverviewpage = userinformationpage.clickContinueButton();
		checkoutcompletepage = checkoutoverviewpage.clickFinishButton();
		System.out.println("checkout comple is passed");
		String successful = checkoutcompletepage.verifyCheckoutCompletePageDisplayed();
		Assert.assertEquals(successful, "Thank you for your order!");
//		Assert.assertEquals(successful, true);
	}
	
//	@Test(dataProvider = "data")
//	public void validateLoginForDifferentUsers(String username, String password) throws IOException {
//		homepage= loginpage.login(username, password);
//		Assert.assertTrue(homepage.checkHomepageDisplayed());
//		homepage.addItemToCart();
//		yourcartpage = homepage.goToShoppingCart();
//		userinformationpage =yourcartpage.clickCheckoutButton();
//		userinformationpage.fillUserInformation("sachin", "Tendulkar", "5545");
//		checkoutoverviewpage = userinformationpage.clickContinueButton();
//		checkoutcompletepage = checkoutoverviewpage.clickFinishButton();
//		boolean successful = checkoutcompletepage.verifyCheckoutCompletePageDisplayed();
//		Assert.assertEquals(successful, true);
//	}
//	
//	@DataProvider(name = "data")
//	public Object[][] dataSupplier() throws IOException{
//		return new Object[][] {
//			   { "standard_user", "secret_sauce" },
//			   { "locked_out_user", "secret_sauce"},
//			   { "problem_user", "secret_sauce"},
//			   { "performance_glitch_user", "secret_sauce"}
//			 };
//
//	}
	
	
	
//	@AfterSuite
//	public void teardown() {
//		driver.quit();
//	}
	
	@AfterMethod
	public void teardown() throws InterruptedException {
		Thread.sleep(5000);
		driver.close();
	}
	
	

}
