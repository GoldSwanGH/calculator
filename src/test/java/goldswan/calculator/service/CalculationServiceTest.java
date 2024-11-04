package goldswan.calculator.service;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CalculationServiceTest {

    private final CalculationService service = new CalculationService();

    @Test
    public void testAdd() {
        assertEquals(5, service.add(2, 3));
    }

    @Test
    public void testSubtract() {
        assertEquals(1, service.subtract(3, 2));
    }

    @Test
    public void testMultiply() {
        assertEquals(6, service.multiply(2, 3));
    }

    @Test
    public void testDivide() {
        assertEquals(2, service.divide(6, 3));
    }

    @Test
    public void testDivideByZero() {
        Exception exception = assertThrows(ArithmeticException.class, () -> service.divide(6, 0));
        assertEquals("Division by zero is not allowed.", exception.getMessage());
    }
}

