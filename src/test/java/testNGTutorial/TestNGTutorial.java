package testNGTutorial;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

/* If we don�t mention any priority, testng will execute the @Test methods based on alphabetical order of their method names
 * irrespective of their place of implementation in the code.
 * 
 * Number 0 has the highest priority(it�ll be executed first).
 * 
 * Testng considers the alphabetical order of the method names whose priority is same.
 * 
 * If TestClass has prioritized and non-prioritized test methods, latter will be run first and then prioritized methods.  
 */

public class TestNGTutorial {
	
	WebDriver driver;
	
	@BeforeClass
	public void setUp() {
		
		System.setProperty("webdriver.chrome.driver","F:\\workspaceSelenium\\Day1\\chromeDriver\\chromedriver.exe");
		driver = new ChromeDriver();
	}
	
	
	/* "groups" attribute brings methods in the same group in the Testng Report.
	 */
	@Test(groups="SmokeTest")
	public void c_method() {
		System.out.println("C");
	}
	
	@Test(groups="SmokeTest")
	public void d_method() {
		System.out.println("D");
	}
	
	/* Number 0 has the highest priority(it�ll be executed first).
	 */
	@Test(priority=0, groups="Prioritized")
	public void b_method() {
		System.out.println("B");
	}
	
	@Test(priority=1, groups="Prioritized")
	public void a_method() {
		System.out.println("A");
	}
	
	@Test()
	public void e_method() {
		System.out.println("E");
		Assert.assertTrue(false);
	}
	
	/* This method will be skipped if "e_method" fails.
	 */
	@Test(dependsOnMethods="e_method")
	public void f_method() {
		System.out.println("F");
	}
	
	/* This method will be invoked multiple times.
	 */
	@Test(invocationCount=3)
	public void g_method() {
		System.out.println(" g_method() invoked multiple times G");
	}
	
	/* This method will handle the specified Exception and will not FAIL if the specified exception occurs.
	 */
	@Test(expectedExceptions=NoSuchElementException.class)
	public void i_method() {
		
		System.out.println("i_method()");
		driver.get("https://www.google.com/");
		driver.findElement(By.name("apple"));
	}
	
	
	@Test(priority=100)
	@Parameters({"url", "searchText"})
	public void parameters_method(String url, @Optional("Default Value for the parameter") String text) {
		/* @Optional is used when a parameter is not defined in TESTNG XML file.
		 * In such case it takes the value specified in @Optional attribute as default value */
		System.out.println("parameters_method()");		
		driver.get(url);
		driver.findElement(By.xpath("//input[@type='text' and @name='q']")).sendKeys(text);
	}
}
/* Refer TestNGTutorialSuite.xml file for parameters and their values.
*/
























