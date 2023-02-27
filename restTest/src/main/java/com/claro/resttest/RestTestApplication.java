package com.claro.resttest;

import com.claro.resttest.SOAP.CalculatorClient;
import com.claro.resttest.SOAP.SoapClientConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableWebMvc
@EnableSwagger2
@SpringBootApplication
public class RestTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestTestApplication.class, args);
	}

}
