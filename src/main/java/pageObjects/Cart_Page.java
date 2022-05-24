/**
 * 
 */
package pageObjects;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import actions.Action;
import basePage.BasePage;

/**
 * @author Admin
 *
 */
public class Cart_Page extends BasePage{

	public Cart_Page()
	{
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath="//div[@class='brand greenLogo']")
	WebElement cartLogo;
	
	@FindBy(xpath="//h4[@class='product-name']")
	List<WebElement> products;
	
	@FindBy(xpath="//div[@class='product-action']//button")
	List<WebElement> CartBtn;
	
	@FindBy(xpath="//a[@class='increment']")
	List<WebElement> incrementBtn;
	
	
	@FindBy(xpath="//a[@class='cart-icon']//img")
	WebElement cartIconBtn;
	
	@FindBy(xpath="//div[@class='action-block']/button[text()='PROCEED TO CHECKOUT']")
	WebElement checkoutBtn;
	
	public boolean getLogo()
	{
		return Action.isDisplayed(cartLogo);
	}
	
	
	public SummaryPage selectProducts()
	{
		Action.cartAdd(products, incrementBtn, CartBtn);
		Action.click(cartIconBtn);
		Action.explicitWaitForEle(checkoutBtn);
		Action.click(checkoutBtn);
		return new SummaryPage();
	}
	
	
}
