package SeleniumTutorial;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

/* Using SOFT ASSERT :- Even if a validation fails, the test execution will not stop 
 * and continues to execute till end and then finally FAIL.
 * assertAll() method always needs to be called at last in the test script.*/


public class D21_SoftAssertTutorial {
	
	@Test
	public void softAssertTest() {
		
		SoftAssert softAssert = new SoftAssert();
		
		System.out.println("softAssertTest STARTED");
		
		softAssert.assertEquals(12, 13);
		
		System.out.println("softAssertTest COMPLETED");
		
		softAssert.assertAll();
		
	}
	
	
	@Test
	public void hardAssertTest() {
		
		System.out.println("hardAssertTest STARTED");
		
		Assert.assertEquals(12, 13);
		
		System.out.println("hardAssertTest COMPLETED");
				
	}
}
