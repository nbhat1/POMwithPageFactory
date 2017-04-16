package com.test.automation.POMwithfactory_UIAutomation.uiActions;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.test.automation.POMwithfactory_UIAutomation.testBase.TestBase;

public class HomePage {
	
	public static final Logger log = Logger.getLogger(HomePage.class.getName());
	WebDriver driver;
	
	public HomePage(WebDriver driver){
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//*[@id='header']/div[2]/div/div/nav/div[1]/a")
	WebElement signIn;
	
	@FindBy(xpath="//*[@id='email']")
	WebElement userName;
	
	@FindBy(xpath="//*[@id='passwd']")
	WebElement password;
	
	@FindBy(xpath="//*[@id='SubmitLogin']")
	WebElement submitButton;
	
	@FindBy(xpath=".//*[@class='alert alert-danger']/ol/li")
	WebElement authenticationFailedMessage;
	
	
	public void loginToApplication(String email , String Password) throws InterruptedException{
		signIn.click();
		log.info("clicked on signin link and object is :-" + signIn.toString());
		Thread.sleep(2000L);
		userName.sendKeys(email);
		log.info("Entered email address as " + email + "and objects is :-" + userName.toString());
		password.sendKeys(Password);
		log.info("Entered password as " + Password + "and objects is :-" + password.toString());
		submitButton.click();
		log.info("Signin Button clicked & obect is :-" + submitButton.toString());
		Thread.sleep(2000L);
		
	}
	
	public String invalidLoginText(){
		log.info("Error message is :-" + authenticationFailedMessage.getText());
		return authenticationFailedMessage.getText();
	}

}
