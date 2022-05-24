/**
 * 
 */
package com.cartpage.qa.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import basePage.BasePage;
import pageObjects.Cart_Page;
import pageObjects.SummaryPage;

/**
 * @author Admin
 *
 */
public class addToCartPageTest extends BasePage  {

	Cart_Page cartpage;
	SummaryPage summaryPage;
	
	public addToCartPageTest()
	{
		super();
	}
	
	
	@BeforeMethod
	public void setup()
	{
		launch();
		 cartpage= new Cart_Page();
	}
	
	
	@Test(priority=1)
	public void getLogoTest()
	{
		
	log.info("verify is GreenCart logo is displayed");	
	boolean flag=cartpage.getLogo();
	Assert.assertTrue(flag);
	}
	
	@Test(priority=2)
	public void additemsToCartTest()
	{
		log.info("Selecting the items and adding to cart");
		summaryPage=cartpage.selectProducts();
		
	}
}
