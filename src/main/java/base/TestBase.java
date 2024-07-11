package base;

import java.io.File;
import java.io.FileInputStream;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utility.WebEventListener;

import io.github.bonigarcia.wdm.WebDriverManager;


public class TestBase {
	
	public static WebDriver driver;
	public static Properties prop;
	public static EventFiringWebDriver e_driver;
	public static WebEventListener eventListiner;
	public static WebDriverWait wait;
	
	
	public TestBase() throws IOException {
		File file = new File("./properties/files/ListStopWords.txt");  
		FileInputStream configfile = new FileInputStream(".\\src\\main\\java\\config\\config.properties");
		
		
		prop = new Properties();
		prop.load(configfile);
		System.out.println("properties file loaded");
		
		
	}
	
	
	public static void initialize() throws IOException {
		
		String url = prop.getProperty("url");
		String browserName = prop.getProperty("browser");
		if (browserName.equalsIgnoreCase("chrome")){
//			String driverpath= "C:\\Users\\mg22250\OneDrive - Deere & Co\\Desktop\\Common\\Workspace\\javaSelenium\\ecommerce\\drivers\\chromedriver.exe";
//			System.setProperty("webdriver.chrome.driver", driverpath);
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			
//			e_driver = new EventFiringWebDriver(driver);
//			eventListiner = new WebEventListener();
//			e_driver.register(eventListiner);
//			driver=e_driver;
			
			driver.get(url);
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			
			
		}
	}
	
	public static void enterValueInTextBox(WebElement elementName, String text) {
		
		wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.elementToBeClickable(elementName)).sendKeys(text);
		
	}
	
	public static void clickOnElement(WebElement elementName) {
		
		wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.elementToBeClickable(elementName)).click();;
	}
	
	public boolean checkElementIsDisplayed(WebElement elementName) {
		
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		return wait.until(ExpectedConditions.visibilityOf(elementName)).isDisplayed();
		
	}
	
	public String getWebElementText(WebElement elementName) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		return wait.until(ExpectedConditions.elementToBeClickable(elementName)).getText();
		
	}
	

}
