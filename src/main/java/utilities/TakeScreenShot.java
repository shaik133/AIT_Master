/**
 * 
 */
package utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;



/**
 * @author Admin
 *
 */
public class TakeScreenShot  {

	
	public static String takesScreenshot(WebDriver driver, String Testname) throws IOException
	{
		String timestamp= new SimpleDateFormat("yyyy.MM.dd.hh.mm.ss").format(new Date());
		String path=System.getProperty("user.dir")+"\\Screenshots\\"+Testname+"_"+timestamp+".png";
		
		TakesScreenshot ss= (TakesScreenshot)driver;
		File src=ss.getScreenshotAs(OutputType.FILE);
		String dst= path;
		FileUtils.copyFile(src, new File (dst));
		return dst;
	}
}
