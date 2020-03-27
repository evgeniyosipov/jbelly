package ru.evgeniyosipov.jbelly.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.core.env.Environment;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import ru.evgeniyosipov.jbelly.config.TestContextInitializer;

import static org.junit.Assert.assertEquals;

@ContextConfiguration(initializers = TestContextInitializer.class)
@RunWith(SpringRunner.class)
@SpringBootTest
public class JasyptServiceTests {
    @Autowired
    private ApplicationContext appContext;

    @Test
    public void whenDecryptedPasswordNeededThenGetFromService() {
        Environment environment = appContext.getBean(Environment.class);
        JasyptService service = appContext.getBean(JasyptService.class);
        if (service.getDataSourcePasswordUsingEnvironment(environment) != null && service.getDataSourcePassword().startsWith("ENC(")) {
            // Remove your real password after test :)
            assertEquals("YOurDECRYPTedPassw0rd", service.getDataSourcePassword());
            assertEquals(
                    "YOurDECRYPTedPassw0rd",
                    service.getDataSourcePasswordUsingEnvironment(environment));
        }
    }
}