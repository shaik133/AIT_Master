/**
 * 
 */
package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import actions.Action;
import basePage.BasePage;

/**
 * @author Admin
 *   head: //table[@id='productCartTables']/thead/tr/td
 *   td: //table[@id='productCartTables']/tbody/tr/td[2]
 *   price://table[@id='productCartTables']/tbody/tr/td[2]//following-sibling::td[2]
 */
public class SummaryPage extends BasePage {

	
	public SummaryPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//table[@id='productCartTables']/thead/tr/td")
	List<WebElement> tableHeaders;
	
	By products=By.xpath("//table[@id='productCartTables']/tbody/tr/td["+Action.col+"]");
	By price =By.xpath("//table[@id='productCartTables']/tbody/tr/td[2]//following-sibling::td[2]");
	
	@FindBy(xpath="//table[@id='productCartTables']/tbody/tr/td[2]//following-sibling::td[2]")
	List<WebElement> prices;

	@FindBy(xpath="//input[@class='promoCode']")
	WebElement promoText;
	
	public List<WebElement> products()
	{
		return driver.findElements(products);
	}
	
	public List<WebElement> price()
	{
		return driver.findElements(price);
	}
	
	public void getProducts()
	{
		Action.priceSum(prices);
//		Action.getListProducts(products());
		Action.explicitWaitForEle(promoText);
		Action.sendKeys(promoText, "this is promoCode");
		Action.getColumn();
	}
	
}
