package utility;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ConfigReader {
	
	Properties prop;
	
	public ConfigReader(){
		
		
		try {
			
			File src = new File("./Configuration/Config.property");
			
			FileInputStream fis = new FileInputStream(src);
			
			prop = new Properties();
			prop.load(fis);
			
		} catch (Exception e) {
			
			System.out.println("Exception is == "+ e.getMessage());
		}
	}
	
	public String getChromePath(){
		
		String chromePath = prop.getProperty("ChromeDriver");
		return chromePath;
	}
	
	public String getapplicationURL(){
		
		String url = prop.getProperty("URL");
		return url;
	}
	
	
	public String getWordpressUrl(){
		
		String url = prop.getProperty("WordpressUrl");
		return url;
	}
	
	
	public String getTestExcelFilePath(){
		
		String excelPath = prop.getProperty("TestDataExcelFile");
		return excelPath;
	}
	

}












































