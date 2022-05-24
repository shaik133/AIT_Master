/**
 * 
 */
package actions;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import basePage.BasePage;

/**
 * @author Admin
 *
 */
public class Action extends BasePage{

	/*--------------- GET THE TITLE OF THE PAGE----------- */
	public static int col;	
	
	
	
	public static String getTitle()
	{
		String title= driver.getTitle();
		System.out.println("Title of the Page is: "+title);
		return title;
	}
	
	
	/*--------------------GET TEXT----------------*/
	
	public static String getText(WebElement ele)
	{
		String textName= ele.getText();
		System.out.println("The retrived text is : "+textName);
		return textName;
	}
	
/*  ----------	SEND KEYS ------------	*/	
	public static boolean sendKeys(WebElement ele, String text)
	{
		boolean flag= false;
		try
		{
			ele.clear();
			ele.sendKeys(text);
			flag=true;
			return flag;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return flag;
		}
		finally
		{
			if(flag=true)
			{
				System.out.println(text+" sent");
			}
			else
			{
				System.out.println(text+" failed to send");
			}
		}
		
	}
	
	/*----------- click----------*/
	
	public static boolean click(WebElement ele)
	{
		boolean flag=false;
		
		try {
		ele.click();
		flag=true;
		 if(flag=true)
		 {
			 System.out.println(ele+" is clicked");
		 }
		
		 else
		 {
			 System.out.println(ele+" is failed to  clicked");
		 }
		return flag;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return flag;
		}

		
		
	}
	
	/*------------ is Displayed -----------*/
	
	public static boolean isDisplayed(WebElement ele)
	{
		
		boolean flag=ele.isDisplayed();
		if(flag==true)
		{
			System.out.println(ele+" is displayed");
		}
		else
		{
			System.out.println(ele+" is not displayed");
		}
		return flag;
		
	}
	
	/*--------------- SELECT STATEMENT BY VALUE---------*/
	
	public static void select(WebElement ele,String value)
	{
		Select option = new Select(ele);
		option.selectByValue(value);
	}
	
	/* ---------- SWITCH TO FRAME --------------*/
	
	public static void switchToFrame(WebElement ele)
	{
		driver.switchTo().frame(ele);
	}

	/*------------ Alert handle--------*/
	
public static void switchToAlert()
{
	Alert alert=driver.switchTo().alert();
	String text=alert.getText();
	System.out.println(text);
	alert.accept();
	
}

/*--------- EXPLICITE WAIT FOR ALERTS---------*/
public static void explicitWaitAlerts()
{
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	wait.until(ExpectedConditions.alertIsPresent());
	
}

/*--------- EXPLICITE WAIT ---------*/
public static void explicitWait(List<WebElement> ele)
{
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	wait.until(ExpectedConditions.visibilityOfAllElements(ele));
	
}

/*--------- EXPLICITE WAIT FOR ELEMENT ---------*/
public static void explicitWaitForEle(WebElement ele)
{
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	wait.until(ExpectedConditions.visibilityOf(ele));
	
}
/*------------- Auto Suggestion ------------*/
public static void autoSuggestSelect(WebElement ele, List<WebElement> ele1, String text,String text1)
{
	
	ele.sendKeys(text);

	List<WebElement>options= ele1;
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	wait.until(ExpectedConditions.visibilityOfAllElements(ele1));
	for(int i=0; i<options.size();i++)
	{
		if(options.get(i).getText().equalsIgnoreCase(text1))
		{
			options.get(i).click();
			break;
			}
	}

}

/* 	------------ GET WINDOW HANDLES -----------------*/

public static void switchWindow(WebElement ele)
{
	ele.click();
	Set<String> windows= driver.getWindowHandles();
	Iterator<String> it=windows.iterator();
	String parentWindow=it.next();
	String childWindow=it.next();
	driver.switchTo().window(childWindow);
}

/*------------ SWITCH TO DEFAULT WINDOW----------*/
public static void switchToDefaultWindow()
{
	driver.switchTo().defaultContent();
}

/*----------------- GET CURRENT URL--------------*/

public static void getUrl()
{
	String url=driver.getCurrentUrl();
	System.out.println("Current URl is: "+ url);
}

/*----------------- SWITCH POP UP ----------*/
public static void switchPopup(List<WebElement> ele, WebElement ele1)
{
	List<WebElement> pop=ele;
	if(pop.size()>0)
	{
		ele1.click();
	}
	
}

/*-----------------OPEN NEW WINDOW TAB-------*/
public static void newTab(WebElement ele)
{
	ele.click();
	
	driver.switchTo().newWindow(WindowType.TAB);
	Set<String> windows=driver.getWindowHandles();
	Iterator<String> it=windows.iterator();
	String parentWindow=it.next();
	String childWindow=it.next();
	driver.switchTo().window(childWindow);
}

/*------------------- Calculate SUM OF PRICE----------------*/
public static int priceSum(List<WebElement> ele)

{
	List<WebElement> prices= ele;
	int sum=0;
	
	for ( int i=0; i<prices.size();i++)
	{
		int price=Integer.parseInt(prices.get(i).getText());
		sum=sum+price;
	}
	System.out.println("Sum of product is: "+sum);
	return sum;
}


/*------------ GET COLUMN OF THE TABLES----------*/
//public static int column=0;
public static int getColumn()
{
	List<WebElement> list = driver.findElements(By.xpath("//table[@id='productCartTables']/thead/tr/td"));
	int columnIndex=0;
	ArrayList<String> lists= new ArrayList<String>();
	for(int i=0;i<list.size();i++)
	{
		
		String text=list.get(i).getText();
		System.out.println(text);	
		lists.add(text);
		columnIndex++;
	}
	return columnIndex;
}

/*--------------- Split method------------*/
public static int split(WebElement ele)
{
	String text= ele.getText().split(":")[1].trim();
	int finalAmount=Integer.parseInt(text);
	System.out.println("Final split amount is: "+finalAmount);
	return finalAmount;
}

/*-------------------AJAX ACTIONS---------*/
public static void mouseHover(WebElement ele)
{
	Actions act = new Actions(driver);
	 act.moveToElement(ele).build().perform();
}


/*--------------------JAVAACRIPT EXECUTOR FOR SCROLLING WINDOW------------*/

public static void windowScrollBy()
{
	JavascriptExecutor js = (JavascriptExecutor)driver;
	js.executeScript("window.scrollBy(0,950)");
}

/*--------------------- CLICK EACH LINK IN NEW TAB------------*/
public static void invokeEachlink(WebElement ele)
{
	WebElement footerDriver= ele;
	List<WebElement>links=footerDriver.findElements(By.tagName("a"));
	for(int i=0;i<links.size();i++)
	{
		
		String key=Keys.chord(Keys.CONTROL,Keys.ENTER);
		links.get(i).sendKeys(key);
	}
}

/* --------------- VALIDATE BROKEN LINKS--------*/
public static void brokenLink(WebElement ele) throws MalformedURLException, IOException
{
	WebElement footerDriver= ele;
	List<WebElement>links=footerDriver.findElements(By.tagName("a"));
	SoftAssert sa= new SoftAssert();
	for(WebElement link:links)
	{
		String url=link.getAttribute("href");
		HttpURLConnection conn= (HttpURLConnection) new URL(url).openConnection();
		conn.setRequestMethod("HEAD");
		conn.connect();
		int responseCod=conn.getResponseCode();
		sa.assertTrue(responseCod<400, "The broken link is: "+link.getText()+" with status code: "+responseCod);
	}
	sa.assertAll();
}

/*=============================== CART PAGE ACTIONS ====================================*/


/*------------------------------ ADD TO CART BTN CLICK -------------------*/

public static void cartAdd(List<WebElement> ele, List<WebElement> ele2, List<WebElement> ele1)
{
	String vegName[] = {"Brocolli","Cauliflower","Cucumber","Beans"};
	int j=0;
	List<WebElement> products =ele;
	for(int i=0;i<products.size();i++)
	{
	String	finalProductstring=products.get(i).getText().split("-")[0].trim();
	List<String> list= Arrays.asList(vegName);
	int h=0;
	if(list.contains(finalProductstring))
	{
		for(int k=0;k<2;k++)
		{
			ele2.get(i).click();
			h++;
			if(h==vegName.length)
			{
				break;
			}
		}
		ele1.get(i).click();
		j++;
		if(j==vegName.length)
		{
			break;
		}
	}
	
	}
}














}









//List<WebElement> products =ele1;
//for(WebElement product:products)
//{
//	String prod=product.getText();
//	List<WebElement> prices =ele2;
//	for(WebElement price:prices )
//	{
//		int pri=Integer.parseInt(price.getText());
//		HashMap<String,Integer> hm= new HashMap<String,Integer>();
//		hm.put(prod, pri);
//	Iterator<Entry<String,Integer>>it=	hm.entrySet().iterator();
//	while(it.hasNext())
//	{
//		Map.Entry<String, Integer> entry=it.next();
//		System.out.println("product: "+entry.getKey()+"price: "+entry.getValue());
//	}
//		
//	}
//	
//		
//	}









