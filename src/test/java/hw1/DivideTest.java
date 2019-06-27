package hw1;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class DivideTest extends BaseClass {

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