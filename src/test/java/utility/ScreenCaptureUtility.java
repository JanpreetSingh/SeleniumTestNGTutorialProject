package utility;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;


public class ScreenCaptureUtility {
	
	public static String captureScreenshot(WebDriver driver, String screenshotName) throws IOException{
		
		String currentPath = System.getProperty("user.dir");
		System.out.println("currentPath --> " + currentPath);
		String filePath = currentPath + "\\screenshots\\" + screenshotName + ".png";
		
		try{			 
				 TakesScreenshot tsh=(TakesScreenshot)driver;
				 
				//Obtain the screenshot into a temporary file that will be deleted once the JVM exits. It is up to users to make a copy of this file.
				 File sourceFile = tsh.getScreenshotAs(OutputType.FILE);
				 File destFile = new File(filePath);
				 
				 FileHandler.copy(sourceFile, destFile);//FileUtils can also be used to copy files. But, first 'org.apache.commons.io.jar' needs to be configured in build path.
				 
				 System.out.println("Screen Shot Taken");
				 
			}catch(Exception e){
				System.out.println("Exception while taking screenshot : "+e.getMessage());
				
			}
		return filePath;
			
	}

}
