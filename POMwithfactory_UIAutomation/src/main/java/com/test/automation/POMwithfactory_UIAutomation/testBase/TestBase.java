package com.test.automation.POMwithfactory_UIAutomation.testBase;


import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class TestBase {
	
	public static final Logger log = Logger.getLogger(TestBase.class.getName());
	
	public WebDriver driver;
	String url = "http:///www.automationpractice.com/index.php";
	String browser = "firefox";
	
	public void init(){
		selectBrowser(browser);
		getURL(url);
		String log4jConfPath = "log4j.properties";
		PropertyConfigurator.configure(log4jConfPath);
		
	}
	
	public void selectBrowser(String browser){
		if(browser.equalsIgnoreCase("firefox")){
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "\\drivers\\geckodriver-v0.15.0-win64\\geckodriver.exe");
			driver = new FirefoxDriver();
			log.info("Creating object of " + browser);
		}
		else if (browser.equalsIgnoreCase("chrome")){
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\drivers\\chromedriver_2.29\\chromedriver.exe");
			driver = new ChromeDriver();
			log.info("Creating object of " + browser);
		} else {
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "\\drivers\\geckodriver-v0.15.0-win64\\geckodriver.exe");
			driver = new FirefoxDriver();
			log.info("Creating object of " + browser);
		}
	}
	
	public void getURL(String url){
		driver.get(url);
		log.info("navigating to url :-" + " " +  url);
		driver.manage().window().maximize();
		//driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	}
	
	
	
	

}
