package testNGTutorial;

import org.testng.SkipException;
import org.testng.annotations.Test;

public class SkippingTest {
	
	@Test
	public void testskip() {
	
		throw new SkipException("Throwing exception for some reason");
	}

}
