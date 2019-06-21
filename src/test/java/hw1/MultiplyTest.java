package hw1;

import com.epam.tat.module4.Calculator;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class MultiplyTest {

    // TODO It could be extracted to BaseClass
    private Calculator calculator;

    // TODO It could be extracted to BaseClass
    // TODO Why is it BeforeTest?
    @BeforeTest
    public void beforeTest() {
        calculator = new Calculator();
    }

    @Test(dataProviderClass = DataProviders.class,
            dataProvider = "multiply-data-set-double")
    public void multiplyTestDouble(double a, double b, double result) {
        double actual = calculator.mult(a, b);
        assertEquals(result, actual);
    }

    @Test(dataProviderClass = DataProviders.class,
            dataProvider = "multiply-data-set-long")
    public void multiplyTestLong(long a, long b, long result) {
        long actual = calculator.mult(a, b);
        assertEquals(result, actual);
    }

}
