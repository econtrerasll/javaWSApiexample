package com.claro.resttest.SOAP;


import com.claro.resttest.SOAP.schema.Add;
import com.claro.resttest.SOAP.schema.AddResponse;
import org.springframework.ws.WebServiceMessage;
import org.springframework.ws.client.core.WebServiceMessageCallback;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.SoapMessage;

import javax.xml.transform.TransformerException;
import java.io.IOException;

public class CalculatorClient extends WebServiceGatewaySupport {
    public AddResponse getCalculatorResponse(int n1, int n2) {
        Add calculatorRequest = new Add();
        calculatorRequest.setIntA(n1);
        calculatorRequest.setIntB(n2);
//        return (AddResponse) getWebServiceTemplate().marshalSendAndReceive(calculatorRequest);
        AddResponse response = (AddResponse) getWebServiceTemplate().marshalSendAndReceive("http://www.dneonline.com/calculator.asmx", calculatorRequest, new WebServiceMessageCallback() {
            @Override
            public void doWithMessage(WebServiceMessage webServiceMessage) throws IOException, TransformerException {
                ((SoapMessage)webServiceMessage).setSoapAction("http://tempuri.org/Add");
            }
        });
        return response;
    }
}
