package SeleniumTutorial;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.ProfilesIni;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

/*MutableCapabilities class has these subclasses:
 * ChromeOptions, FirefoxOptions, InternetExplorerOptions, DesiredCapabilities etc.
*/

public class D22_UntrustedCertificateTutorial {
	
	@Test
	public void handleUntrustedCertificate_ChromeTest() {
		
		/*DesiredCapabilities capabilities = new DesiredCapabilities();
		 *capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		*/
		
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.setAcceptInsecureCerts(true);
		chromeOptions.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		
		System.setProperty("webdriver.chrome.driver","F:\\workspaceSelenium\\Day1\\chromeDriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver(chromeOptions);
		
		driver.get("https://www.cacert.org/");
		
	}
	
	
	@Test
	public void handleUntrustedCertificate_FirefoxTest() {
		
		ProfilesIni profilesIni = new ProfilesIni();
		FirefoxProfile firefoxProfile = profilesIni.getProfile("profile1");
		
		FirefoxOptions firefoxOptions = new FirefoxOptions();
		firefoxOptions.setProfile(firefoxProfile);
		
		firefoxOptions.setAcceptInsecureCerts(true);		
		
		System.setProperty("webdriver.gecko.driver","F:\\workspaceSelenium\\Day1\\firefoxDriver\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver(firefoxOptions);
		driver.get("https://www.cacert.org/");
		
	}
	
}
