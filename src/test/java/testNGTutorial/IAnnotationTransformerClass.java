package testNGTutorial;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;

/* IAnnotationTransformer re-runs all the @Test methods for the classes specified in TestNG.xml file if it fails, for the retry limit specified.
 * */

public class IAnnotationTransformerClass implements IAnnotationTransformer{

	@Override
	public void transform(ITestAnnotation annotation, Class testClass,
			Constructor testConstructor, Method testMethod) {

		annotation.setRetryAnalyzer(testNGTutorial.IRetryAnalyserClass.class);
		
	}

}
