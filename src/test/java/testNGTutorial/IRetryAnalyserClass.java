package testNGTutorial;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

/* IRetryAnalyzer re-runs the @Test methods(with retryAnalyzer attribute) if it fails, for the retry limit specified.
 * */

public class IRetryAnalyserClass implements IRetryAnalyzer{
	
	int counter=0;
	int retryLimit=3;
	
	@Override
	public boolean retry(ITestResult result) {
		
		if(counter<retryLimit) {
			counter++;
			return true;
		}
		return false;
	}
	
	

}
