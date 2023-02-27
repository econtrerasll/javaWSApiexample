package com.claro.resttest.SOAP;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

@Configuration
public class SoapClientConfig {
//    @Value("${wsdl.service.url}")

private String soapURL="http://www.dneonline.com/calculator.asmx?wsdl";

    @Bean
    public Jaxb2Marshaller marshaller(){
        Jaxb2Marshaller jaxb2Marshaller = new Jaxb2Marshaller();
        jaxb2Marshaller.setContextPath("com.claro.resttest.SOAP.schema");
        return jaxb2Marshaller;
    }
    @Bean
    public CalculatorClient calculatorClient(Jaxb2Marshaller jaxb2Marshaller){
        CalculatorClient calculatorClient = new CalculatorClient();
        calculatorClient.setDefaultUri(soapURL);
        calculatorClient.setMarshaller(jaxb2Marshaller);
        calculatorClient.setUnmarshaller(jaxb2Marshaller);
        return calculatorClient;
    }
}
