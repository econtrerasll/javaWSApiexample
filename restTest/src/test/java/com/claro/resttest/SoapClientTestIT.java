package com.claro.resttest;


import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.equalTo;

import java.io.IOException;


public class SoapClientTestIT {

    @Test
    public void testStatusYResultado() throws IOException {
        Integer n1 = 5;
        Integer n2 = 7;
        String expResult = "12";
        HttpUriRequest request = new HttpGet("http://localhost:8080/suma/" + n1 + "/" + n2);

        HttpResponse httpResponse = (HttpResponse) HttpClientBuilder.create().build().execute(request);
        String result = EntityUtils.toString(httpResponse.getEntity());
        assertThat(httpResponse.getStatusLine().getStatusCode(), equalTo(HttpStatus.SC_OK));
        assertThat(result, equalTo(expResult));
    }

    @Test
    public void solo1Param() throws IOException {
        Integer n1 = 5;
        String n2 = "5s";
        HttpUriRequest request = new HttpGet("http://localhost:8080/suma/" + n1 + "/" + n2);

        HttpResponse httpResponse = (HttpResponse) HttpClientBuilder.create().build().execute(request);

        assertThat(httpResponse.getStatusLine().getStatusCode(), equalTo(HttpStatus.SC_BAD_REQUEST));

    }
}

