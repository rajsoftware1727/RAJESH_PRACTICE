package SCREENSHOT;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

 
public class LoggerDemo {
	
	static Logger logger=Logger.getLogger(LoggerDemo.class); //create object of logger class for factory model not use in new keyword

	
	public static void main(String args[])
	{
		//logger basic configuration
		BasicConfigurator.configure();
		
		logger.info("info level");
		logger.warn("warn level");
		logger.fatal("fatal level");
		logger.error("error level");
		logger.debug("debug level");
		
	}

}
