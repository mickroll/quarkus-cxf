package io.quarkiverse.it.cxf;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import org.tempuri.CalculatorSoap;

import io.quarkiverse.cxf.annotation.CXFClient;

@ApplicationScoped
public class CalculatorService {

    @Inject
    @CXFClient
    CalculatorSoap calculatorWS;

    public int subtract(final int a, final int b) {
        return calculatorWS.subtract(a, b);
    }

    public int divide(final int a, final int b) {
        return calculatorWS.divide(a, b);
    }

    public int add(final int a, final int b) {
        return calculatorWS.add(a, b);
    }

    public int multiply(final int a, final int b) {
        return calculatorWS.multiply(a, b);
    }
}
