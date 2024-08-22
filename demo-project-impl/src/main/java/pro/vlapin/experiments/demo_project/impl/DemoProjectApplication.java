package pro.vlapin.experiments.demo_project.impl;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.experimental.ExtensionMethod;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.hateoas.config.EnableHypermediaSupport;
import pro.vlapin.experiments.demo_project.impl.dao.CatRepository;
import pro.vlapin.experiments.demo_project.impl.model.Cat;
import pro.vlapin.experiments.demo_project.impl.model.JavaConfigBasedSetterPropertiesPlaceholderExample;
import pro.vlapin.experiments.demo_project.impl.model.JavaConfigBasedSetterPropertiesPlaceholderExampleImpl;

import java.util.Arrays;

import static org.springframework.hateoas.config.EnableHypermediaSupport.HypermediaType.*;

@EnableFeignClients
@SpringBootApplication
@RequiredArgsConstructor
@ConfigurationPropertiesScan
@EnableHypermediaSupport(type = HAL)
@ExtensionMethod(value = Arrays.class,
                 suppressBaseMethods = false)
@ComponentScan(includeFilters = @Filter(Aspect.class))
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

  @Bean
  ApplicationRunner runner(CatRepository catRepository) {
    return __ -> "Барсик, Мурзик, Матроскин".split(", ").stream()
                                            .map(Cat::new)
                                            .forEach(catRepository::save);
  }

}
