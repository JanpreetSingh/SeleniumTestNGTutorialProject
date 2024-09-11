package testNGTutorial;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

/* IAnnotationTransformer re-runs all the @Test methods for the classes specified in TestNG.xml file if it fails, for the retry limit specified.
 * */

public class IAnnotationTransformerTest {
	
	@Test
	public void dummyFailTest1(){
		System.out.println("Test1 Dummy Fail");
		Assert.assertTrue(false);
	}
	
	
	@Test
	public void dummyFailTest2(){
		System.out.println("Test2 Dummy Fail");
		Assert.assertTrue(false);
}
	
	/*  Add LISTENER in TestNG XML File
	 * 	
	 * <?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE suite SYSTEM "http://testng.org/testng-1.0.dtd">
<suite name="IAnnotationTransformerTestSuite">
    
    <listeners>        
        <listener class-name="testNGTutorial.IAnnotationTransformerClass" />
    </listeners>
    
  <test name="IAnnotationTransformerTestTest">
    <classes>
      <class name="testNGTutorial.IAnnotationTransformerTest"/>
    </classes>
  </test> <!-- Test -->
</suite> <!-- Suite -->

*/ 
}




























