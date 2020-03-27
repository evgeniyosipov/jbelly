package ru.evgeniyosipov.jbelly;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JbellyApplication {

    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(JbellyApplication.class);
        envInitCheck(application);
        application.run(args);
    }

    static void envInitCheck(SpringApplication application) {
        String mysqlHost = System.getenv("JBELLY_MYSQL_HOST");
        String mysqlPort = System.getenv("JBELLY_MYSQL_PORT");
        if (mysqlHost == null || mysqlHost.isEmpty()) {
            System.setProperty("JBELLY_MYSQL_HOST", "localhost");
        }
        if (mysqlPort == null || mysqlPort.isEmpty()) {
            System.setProperty("JBELLY_MYSQL_PORT", "3306");
        }
    }
}
