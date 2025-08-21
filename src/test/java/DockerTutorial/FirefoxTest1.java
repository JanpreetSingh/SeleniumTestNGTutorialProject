package DockerTutorial;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class FirefoxTest1 {
	
	@Test
	public void test() throws MalformedURLException {

		String seleniumGridUrl = "http://localhost:4444/wd/hub";

		FirefoxOptions options = new FirefoxOptions();

			WebDriver driver = new RemoteWebDriver(new URL(seleniumGridUrl), options);

			driver.get("https://www.motorola.in/");
			System.out.println("Title: " + driver.getTitle());

			driver.quit();

	}
}
