package pro.vlapin.experiments.demo_project.impl;

import org.springframework.boot.SpringApplication;

public class TestDemoProjectApplication {

	public static void main(String[] args) {
		SpringApplication.from(DemoProjectApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
