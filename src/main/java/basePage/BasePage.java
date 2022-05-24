/**
 * 
 */
package basePage;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import utilities.Log4J;
import utilities.Report;

/**
 * @author Admin
 *
 */
public class BasePage extends Log4J {

	public Properties prop;
	public static WebDriver driver;
	
	public BasePage()
	{
		boolean flag=false;
		try
		{
			 prop= new Properties();
			FileInputStream fis= new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\config\\config.properties");
			prop.load(fis);		
			flag=true;
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
			
		}
		finally
		{
			if(flag=true)
			{
				System.out.println("config file is loaded");
			}
			else
			{
				System.out.println("config is failed to load");
			}
		}
		
	}
	@BeforeSuite()
	public void extentInit() throws IOException
	{
		Report.extentReport();
	}
	
	
	
	@AfterSuite
	public void flushReport()
	{
		Report.flushReports();
	}
	
	
	
	
	@BeforeMethod()
	public void initBeforeMethods()
	{
		log();
		Log4J.startTest();
	}
	
	
	public WebDriver launch()
	{
		String browser=prop.getProperty("browser");
		if (browser.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\Documents\\Selenium\\chromeDriver100version\\chromedriver_win32\\chromedriver.exe");
			 driver= new ChromeDriver();
		}
		else
		{
			System.out.println("firfox");
		}
		
		driver.get(prop.getProperty("url1"));
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
//		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(25));
		
		
		
		return driver;	
		
		
	}
	
	
	
	@AfterMethod()
	public void teardown()
	{
//		driver.close();
		Log4J.endTest();
	}
	
	
}
