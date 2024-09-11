package utility;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class Log4jUtility {
	
	public static Logger createLogger(Class<?> class_name){
		
		Logger logger = Logger.getLogger(class_name); 
		PropertyConfigurator.configure("./resources/log4j.properties");// Path of log4j.properties file.
		
		return logger;
	}

}
