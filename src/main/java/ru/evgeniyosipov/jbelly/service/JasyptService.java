package ru.evgeniyosipov.jbelly.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

@Service("jasyptService")
public class JasyptService {
    @Value("${spring.datasource.password}")
    private String dataSourcePassword;

    public String getDataSourcePassword() {
        return dataSourcePassword;
    }

    public String getDataSourcePasswordUsingEnvironment(Environment environment) {
        return environment.getProperty("spring.datasource.password");
    }
}
