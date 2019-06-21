package hw1;

import com.epam.tat.module4.Calculator;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertThrows;

public class DivideTest {
    private Calculator calculator;

    @BeforeTest
    public void beforeTest() {
        calculator = new Calculator();
    }

    @Test(dataProviderClass = DataProviders.class,
            dataProvider = "divide-data-set-double")
    public void divideTestDouble(double a, double b, double result) {
        double actual = calculator.div(a, b);
        assertEquals(result, actual);
    }

    @Test(dataProviderClass = DataProviders.class,
            dataProvider = "divide-data-set-long")
    public void divideTestLong(long a, long b, long result) {
        long actual = calculator.div(a, b);
        assertEquals(result, actual);
    }

    @Test(expectedExceptions = NumberFormatException.class)
    public void divideTestZero() throws  NumberFormatException{
        calculator.div(1, 0);
    }

}
