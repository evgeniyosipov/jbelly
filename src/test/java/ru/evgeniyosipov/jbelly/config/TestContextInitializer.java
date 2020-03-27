package ru.evgeniyosipov.jbelly.config;

import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;

public class TestContextInitializer implements ApplicationContextInitializer<ConfigurableApplicationContext> {

    @Override
    public void initialize(ConfigurableApplicationContext configurableApplicationContext) {
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