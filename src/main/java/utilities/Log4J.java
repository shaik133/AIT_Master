/**
 * 
 */
package utilities;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

/**
 * @author Admin
 *
 */
public class Log4J {

	public static Logger log;
	
	public  void log()
	{
		 log= LogManager.getLogger(getClass());
		PropertyConfigurator.configure("log4j.properties");
	}
	
	public static  void startTest()
	{
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		System.out.println("");
		log.info("===================== Start Test ================");
		System.out.println("");
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		
	}
	
	public static void endTest()
	{

		System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
		System.out.println("");
		log.info("==================== End Test =============");
		System.out.println("");
		System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
		System.out.println("");
		System.out.println("");
	}
}
