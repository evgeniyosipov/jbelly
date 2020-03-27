package ru.evgeniyosipov.jbelly;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import ru.evgeniyosipov.jbelly.config.TestContextInitializer;

@ContextConfiguration(initializers = TestContextInitializer.class)
@RunWith(SpringRunner.class)
@SpringBootTest
public class JbellyApplicationTests {

    @Test
    public void contextLoads() {
    }
}
