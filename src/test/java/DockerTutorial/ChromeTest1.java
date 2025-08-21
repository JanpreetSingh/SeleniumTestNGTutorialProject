package DockerTutorial;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class ChromeTest1 {
	
	@Test
	public void test1() throws MalformedURLException {

		String seleniumGridUrl = "http://localhost:4444/wd/hub";

		ChromeOptions options = new ChromeOptions();

			WebDriver driver = new RemoteWebDriver(new URL(seleniumGridUrl), options);

			driver.get("https://www.google.com/");
			System.out.println("Title: " + driver.getTitle());

			driver.quit();

	}
}
