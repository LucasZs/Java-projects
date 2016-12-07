package slf4j_hello;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SLF4JHello {
	private final Logger SLF4jLOGGER = LoggerFactory.getLogger(SLF4JHello.class);
	
	public void sayHello(String name) {
        SLF4jLOGGER.info("Hi, {}", name);
        SLF4jLOGGER.info("Welcome to the HelloWorld example of SLF4J");
    }
	public static void main(String[] args) {
		SLF4JHello slf4jHello = new SLF4JHello();
        slf4jHello.sayHello("Lucas");

	}
}
