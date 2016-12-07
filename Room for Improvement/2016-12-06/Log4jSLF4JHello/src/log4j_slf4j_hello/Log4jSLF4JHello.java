package log4j_slf4j_hello;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Log4jSLF4JHello {
	private static Logger slf4jLogger = LoggerFactory.getLogger(Log4jSLF4JHello.class);
	
	public void sayHello(String name) {
        slf4jLogger.info("Hi, {}", name);
        slf4jLogger.info("Welcome to the HelloWorld example of Log4j using SLF4J");
    }
	
	public static void main(String[] args) {
		Log4jSLF4JHello slf4jHello = new Log4jSLF4JHello();
        slf4jHello.sayHello("Lucas");

	}

}
