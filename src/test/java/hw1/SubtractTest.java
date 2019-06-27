package hw1;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class SubtractTest extends BaseClass {

    @Test(dataProviderClass = DataProviders.class,
            dataProvider = "subtract-data-set-double")
    public void subtractTestDouble(double a, double b, double result) {
        double actual = calculator.sub(a, b);
        assertEquals(result, actual);
    }

    @Test(dataProviderClass = DataProviders.class,
            dataProvider = "subtract-data-set-long")
    public void subtractTestLong(long a, long b, long result) {
        long actual = calculator.sub(a, b);
        assertEquals(result, actual);
    }

}