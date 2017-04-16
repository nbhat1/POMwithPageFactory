package com.test.automation.POMwithfactory_UIAutomation.homePage;


import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.test.automation.POMwithfactory_UIAutomation.testBase.TestBase;
import com.test.automation.POMwithfactory_UIAutomation.uiActions.HomePage;

public class TC001_VerifyLoginWithInvalidData extends TestBase {
	

	HomePage homePage;
	
	@BeforeTest
	public void setUp(){
       init();
	}
	
	@Test
	public void verifyLoginWithInvalidData() throws InterruptedException{
		log.info("========================== Starting verifyLoginWithInvalidData test =========================");
		homePage = new HomePage(driver);
		homePage.loginToApplication("test@gmail.com", "Password");
		//Assert.assertEquals(driver.findElement(By.xpath(".//*[@id='center_column']/div[1]/ol/li")).getText(), "Authentication failed.");
		Assert.assertEquals(homePage.invalidLoginText(), "Authentication failed.");
		log.info("======================= Finished verifyLoginWithInvalidData test =============================");
		
	}
	
	@AfterClass
	public void endTest(){
		driver.quit();
		
	}
}
