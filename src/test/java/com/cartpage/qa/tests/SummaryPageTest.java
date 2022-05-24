/**
 * 
 */
package com.cartpage.qa.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import basePage.BasePage;
import pageObjects.Cart_Page;
import pageObjects.SummaryPage;

/**
 * @author Admin
 *
 */
public class SummaryPageTest extends BasePage{

	Cart_Page cartpage;
	SummaryPage summaryPage;
	
	public SummaryPageTest()
	{
		super();
	}
	
	
	@BeforeMethod
	public void setup()
	{
		launch();
		 cartpage= new Cart_Page();
		 
		log.info("Selecting the items and adding to cart");
		summaryPage=cartpage.selectProducts();
	}
	
	@Test
	public void getProductsTest()
	{
		summaryPage.getProducts();
	}
}
