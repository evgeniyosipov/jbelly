package ru.evgeniyosipov.jbelly;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Properties;

@SpringBootApplication
public class JbellyApplication {

	public static void main(String[] args) {
		SpringApplication application = new SpringApplication(JbellyApplication.class);
		application.setDefaultProperties(checkEnv());
		application.run(args);
	}

	private static Properties checkEnv(){
		Properties properties = new Properties();
		String mysqlHost = System.getenv("JBELLY_MYSQL_HOST");
		String mysqlPort = System.getenv("JBELLY_MYSQL_PORT");
		if(mysqlHost == null || mysqlHost.isEmpty()){
			properties.put("JBELLY_MYSQL_HOST", "localhost");
		}
		if(mysqlPort == null || mysqlPort.isEmpty()){
			properties.put("JBELLY_MYSQL_PORT", "3306");
		}
		return properties;
	}
}
