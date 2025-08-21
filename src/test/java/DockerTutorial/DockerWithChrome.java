package DockerTutorial;

import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

public class DockerWithChrome {

	public static void main(String[] args) {

		String seleniumGridUrl = "http://localhost:4444/wd/hub";

		ChromeOptions options = new ChromeOptions();

		try {
			WebDriver driver = new RemoteWebDriver(new URL(seleniumGridUrl), options);

			driver.get("https://www.google.com/");
			System.out.println("Title: " + driver.getTitle());

			driver.quit();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
