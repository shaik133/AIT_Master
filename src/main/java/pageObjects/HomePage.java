/**
 * 
 */
package pageObjects;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import actions.Action;
import basePage.BasePage;

/**
 * @author Admin
 *
 *///div[@class='tableFixHead']//table[@id='product']//parent::tbody//tr//td[4]
public class HomePage extends BasePage {

	public HomePage()
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//img[@class='logoClass']")
	WebElement logo;
	
	@FindBy(css="input[value='radio1']")
	WebElement radioClick;
	
	
	@FindBy(id="autocomplete")
	WebElement autosuggest;
	
	
	@FindBy(xpath="//ul[contains(@id,'ui-id-1')]/li[@class='ui-menu-item']")
	List <WebElement> sutosuggestList;
	
	
	
	@FindBy(id="dropdown-class-example")
	WebElement selectDD;
	
	
	@FindBy(id="checkBoxOption2")
	WebElement CheckBoxoption;
	
	@FindBy(id="openwindow")
	WebElement newWindow;
	
	
	@FindBy(xpath="//button[text()='NO THANKS']")
	WebElement popup;
	
	@FindBy(xpath="//button[text()='NO THANKS']")
	List<WebElement> popup1;
	
	
	@FindBy(id="opentab")
	WebElement NewTabBtn;
	
	@FindBy(id="name")
	WebElement alertName;
	
	@FindBy(id="alertbtn")
	WebElement alertBtn;
	
	@FindBy(xpath="//table[@id='product' and @name='courses']//parent::tbody//td[text()='Learn JMETER from Scratch - (Performance + Load) Testing Tool']//following-sibling::td")
	WebElement webTableText;
	
	@FindBy(xpath="//table[@id='product' and @name='courses']//parent::tbody//tr//td[3]")
	List<WebElement> productPrice;
	
	@FindBy(id="hide-textbox")
	WebElement hideBoxBtn;
	
	@FindBy(id="show-textbox")
	WebElement showboxBtn;
	
	@FindBy(id="displayed-text")
	WebElement displayBox;
	
	@FindBy(xpath="//table[@id='product']//parent::tbody//td[text()='Cricketer']//preceding-sibling::td")
	WebElement fixesWebtable;
	
	@FindBy(xpath="//div[@class='tableFixHead']//table[@id='product']//parent::tbody//tr//td[4]")
	List<WebElement> amounts;
	
	@FindBy(xpath="//div[@class='totalAmount']")
	WebElement totalAmount;
	
	@FindBy(id="mousehover")
	WebElement mousehover;
	
	@FindBy(xpath="//div[@class='mouse-hover-content']//a[text()='Top']")
	WebElement hoverTop;
	
	
	@FindBy(id="courses-iframe")
	WebElement frame;
	
	@FindBy(xpath="//div[@class='pull-left']//h2")
	WebElement getTextFreame;
	
	
	@FindBy(id="gf-BIG")
	WebElement footer;
	
	
	
	
	
	public boolean getLogo()
	{
		return Action.isDisplayed(logo);
	}
	
	public String getUrl()
	{
		return driver.getCurrentUrl();
	}
	
	public String getTitle()
	{
		return Action.getTitle();
	}
	
	public void radioClick()
	{
		Action.click(radioClick);
	}
	
	public void autosuggest()
	{
//		Action.explicitWait(sutosuggestList);
		Action.autoSuggestSelect(autosuggest, sutosuggestList, prop.getProperty("text"), prop.getProperty("text1"));
	}
	
	public void selectDd()
	{
		Action.select(selectDD, "option1");;
	}
	
	public void checkBoxOpt()
	{
		Action.click(CheckBoxoption);
	}
	
	public void clickNewWindow()
	{
		Action.switchWindow(newWindow);
		Action.getUrl();
		Action.switchPopup(popup1, popup);
		Action.switchToDefaultWindow();
	}
	
	public void clickNewTab()
	{
		Action.newTab(NewTabBtn);
		Action.getUrl();
		Action.getTitle();
	}
	
	public void alert() throws InterruptedException
	{
		Action.sendKeys(alertName, prop.getProperty("alertText"));
		Action.click(alertBtn);
		Thread.sleep(5000);
		Action.switchToAlert();
	}
	
	public void getWebTableText()
	{
		 Action.getText(webTableText);
		 Action.priceSum(productPrice);
	}
	
public boolean displayBox()
{
	Action.click(hideBoxBtn);
	 Action.isDisplayed(displayBox);
	
	Action.click(showboxBtn);
	Action.explicitWaitForEle(displayBox);
	return Action.isDisplayed(displayBox);
}


public int dynamicIndexingOfamountWebTable()
{
	Action.getText(fixesWebtable);
	return Action.priceSum(amounts);
}

public int actualAmont()
{
	return Action.split(totalAmount);
}


public void mouseHover()
{
	Action.windowScrollBy();
	Action.mouseHover(mousehover);
	Action.explicitWaitForEle(hoverTop);
	Action.click(hoverTop);
}

public String switchToFrame()
{
	Action.switchToFrame(frame);
	return Action.getText(getTextFreame);
}


public void invokeLink()
{
	Action.invokeEachlink(footer);
}

public void brokenLink() throws MalformedURLException, IOException
{
	Action.brokenLink(footer);
}

}
