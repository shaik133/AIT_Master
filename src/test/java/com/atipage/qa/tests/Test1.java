/**
 * 
 */
package com.atipage.qa.tests;



import java.io.IOException;
import java.net.MalformedURLException;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import basePage.BasePage;
import pageObjects.HomePage;
import utilities.Log4J;


/**
 * @author Admin
 *
 */
public class Test1 extends BasePage{

	HomePage homePage;

	
	public Test1()
	{
		
		super();
	}
	
	@BeforeMethod
	public void setup()
	{
		launch();
		homePage= new HomePage();
	}
	

	@Test(priority=1)
	public void getLogoTest()
	{
		log.info("Validating the logo");
		boolean value=homePage.getLogo();
		Assert.assertTrue(value);
		
		log.info("Veify Title of the page");
		String title= homePage.getUrl();
		Assert.assertEquals(title, "Practice Page");	
		
	}
	
	@Test(priority=2)
	public void firstRowTest()
	{
		log.info("Click radio btn");
		homePage.radioClick();
		
		log.info("Selecting the options from autosuggest dropdown");
		homePage.autosuggest();
		
		log.info("Selecting the options from static dropdown");
		homePage.selectDd();
		
		log.info("check the check box");
		homePage.checkBoxOpt();
	}
	
	@Test(priority=3)
	public void switchWindowTest()
	{
		log.info("opening new Window screen");
		homePage.clickNewWindow();
	}
	
	@Test(priority=4)
	public void switchToNewTabTest()
	{
		log.info("opening new tab window");
		homePage.clickNewWindow();
		
		log.info("Verifying Title of the page");
		String title=homePage.getTitle();
		Assert.assertEquals(title, "QA Click Academy | Selenium,Jmeter,SoapUI,Appium,Database testing,QA Training Academy");
		
	}
	
	@Test(priority=5)
	public void alertHandleTest() throws InterruptedException
	{
		
		homePage.alert();
		log.error("alert failed to submit");
	}
	
	@Test(priority=6)
	public void getWebTableTextTest()
	{
		log.info("get text from the webtable");
		homePage.getWebTableText();
	}
	
	
	@Test(priority=7)
	public void displayBoxTest()
	{
		log.info("dsiplay box is enabled");
		boolean flag=homePage.displayBox();
		Assert.assertTrue(flag);
	}
	
	@Test(priority=8)
	public void dynamicIndexingOfamountWebTableTest()
	{
		log.info("Validaing the total sum of prices calculated with actual sum");
		int actualSum=homePage.dynamicIndexingOfamountWebTable();
		int expectedSum=homePage.actualAmont();
		Assert.assertEquals(actualSum, expectedSum);
	}
	
	@Test(priority=9)
	public void mouseHoverTest()
	{
		log.info("hover over btn");
		homePage.mouseHover();
	}
	
	@Test(priority=10)
	public void switchToFrameTest()
	{
		log.info("Switching to frame");
		String text=homePage.switchToFrame();
		Assert.assertEquals(text, "Featured Courses");
	}
	
	@Test(priority=11)
	public void invokeLinkTest()
	{
		log.info("Invoking all the footer links available");
		homePage.invokeLink();
	}
	
	@Test(priority=12)
	public void brokenLinkTest() throws MalformedURLException, IOException
	{
		
		log.info("Validating the broken links if any");
		homePage.brokenLink();
		
	}
}
