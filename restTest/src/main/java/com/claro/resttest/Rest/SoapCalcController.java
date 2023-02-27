package com.claro.resttest.Rest;

import com.claro.resttest.SOAP.CalculatorClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/suma")
public class SoapCalcController {
    @Autowired
    CalculatorClient client;

    @GetMapping("/{numero1}/{numero2}")
    public ResponseEntity<Integer> sumarNumeros(@PathVariable("numero1") Integer numero1, @PathVariable("numero2") Integer numero2) {
        int result;
        result = client.getCalculatorResponse(numero1, numero2).getAddResult();
        return ResponseEntity.ok(result);
    }
}