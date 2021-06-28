package io.quarkiverse.it.cxf;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.doReturn;

import javax.inject.Inject;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.tempuri.CalculatorSoap;

import io.quarkus.test.junit.QuarkusTest;
import io.quarkus.test.junit.mockito.InjectMock;

@QuarkusTest
class CalculatorServiceTest {

    @Inject
    CalculatorService underTest;

    @InjectMock
    CalculatorSoap calculatorWSMock;

    @BeforeEach
    void setup() {
        doReturn(23).when(calculatorWSMock).subtract(anyInt(), anyInt());
        doReturn(23).when(calculatorWSMock).divide(anyInt(), anyInt());
        doReturn(23).when(calculatorWSMock).add(anyInt(), anyInt());
        doReturn(23).when(calculatorWSMock).multiply(anyInt(), anyInt());
    }
    @Test
    void testMultiply() {
        Assertions.assertEquals(23, underTest.multiply(13, 17));
    }

    @Test
    void testAdd() {
        Assertions.assertEquals(23, underTest.add(19, 23));
    }
}
