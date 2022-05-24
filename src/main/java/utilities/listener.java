/**
 * 
 */
package utilities;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

import basePage.BasePage;

/**
 * @author Admin
 *
 */
public class listener extends Report implements ITestListener  {

	@Override
	public void onTestStart(ITestResult result) {
		test=extent.createTest(result.getName());
	
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		test=extent.createTest(result.getName());
		test.log(Status.PASS, MarkupHelper.createLabel(result.getName(), ExtentColor.GREEN));
	}

	@Override
	public void onTestFailure(ITestResult result) {
		if(result.getStatus()==ITestResult.FAILURE)
		{
			test=extent.createTest(result.getName());
			test.log(Status.FAIL, MarkupHelper.createLabel(result.getName(), ExtentColor.RED));
			
			try {
				String path=TakeScreenShot.takesScreenshot(BasePage.driver, result.getName());
				test.fail("ScreenShot is"+test.addScreenCaptureFromPath(path));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		test=extent.createTest(result.getName());
		test.log(Status.SKIP, MarkupHelper.createLabel(result.getName(), ExtentColor.ORANGE));
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		test=extent.createTest(result.getName());
		test.log(Status.FAIL, MarkupHelper.createLabel(result.getName(), ExtentColor.AMBER));
		try {
			String path=TakeScreenShot.takesScreenshot(BasePage.driver, result.getName());
			test.fail("ScreenShot is"+test.addScreenCaptureFromPath(path));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



	@Override
	public void onFinish(ITestContext context) {
		extent.flush();
		
	}



	
}
