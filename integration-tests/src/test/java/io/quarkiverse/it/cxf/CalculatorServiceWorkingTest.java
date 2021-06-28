package io.quarkiverse.it.cxf;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.tempuri.CalculatorSoap;

import io.quarkus.test.junit.QuarkusTest;

/**
 * This is an example how to circumvent the limitations presented in {@link CalculatorServiceTest}, BUT:
 * <ul>
 * <li>the setup is hideous ({@code new *Service()}, manual {@code mock(XYZ.class)})
 * <li>testing a bit more than one service would require a lot of manual wiring
 * </ul>
 *
 * @author mickroll
 */
@QuarkusTest
class CalculatorServiceWorkingTest {

    CalculatorService underTest;

    CalculatorSoap calculatorWSMock = mock(CalculatorSoap.class);

    @BeforeEach
    void setup() {
        underTest = new CalculatorService();
        underTest.calculatorWS = calculatorWSMock; // manual wiring, this gets large and complicated in the real world
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
