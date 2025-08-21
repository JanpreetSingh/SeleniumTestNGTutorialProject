package DockerTutorial;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Setup_DockerGrid {
	
	
	@BeforeTest
	public void startDockerGrid() throws IOException, InterruptedException {

		Runtime.getRuntime().exec("cmd /c start src\\test\\java\\DockerTutorial\\start_dockergrid.bat");
		Thread.sleep(15000);

	}
	
	@AfterTest
	public void stopDockerGrid() throws IOException, InterruptedException {

		Runtime.getRuntime().exec("cmd /c start src\\test\\java\\DockerTutorial\\stop_dockergrid.bat");
		Thread.sleep(5000);
		
		Runtime.getRuntime().exec("taskkill /f /im cmd.exe");

	}
}
