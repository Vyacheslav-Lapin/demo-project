package pro.vlapin.experiments.demo_project.impl;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

@Import(TestcontainersConfiguration.class)
@SpringBootTest
class DemoProjectApplicationTests {

  @Test
  @SuppressWarnings("java:S1186")
  void contextLoads() {
  }

}
