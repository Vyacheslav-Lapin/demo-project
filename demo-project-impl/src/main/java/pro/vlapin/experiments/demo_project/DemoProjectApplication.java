package pro.vlapin.experiments.demo_project;

import lombok.SneakyThrows;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.hateoas.config.EnableHypermediaSupport;
import pro.vlapin.experiments.demo_project.model.JavaConfigBasedSetterPropertiesPlaceholderExample;
import pro.vlapin.experiments.demo_project.model.JavaConfigBasedSetterPropertiesPlaceholderExampleImpl;

import static org.springframework.hateoas.config.EnableHypermediaSupport.HypermediaType.*;

@EnableFeignClients
@SpringBootApplication
@ConfigurationPropertiesScan
@EnableHypermediaSupport(type = HAL)
public class DemoProjectApplication {

	@SneakyThrows
  public static void main(String[] args) {
		SpringApplication.run(DemoProjectApplication.class, args);
	}

	@Bean
	@ConfigurationProperties("my-properties2")
	JavaConfigBasedSetterPropertiesPlaceholderExample mySetterProperties2() {
		return new JavaConfigBasedSetterPropertiesPlaceholderExampleImpl();
	}

}
