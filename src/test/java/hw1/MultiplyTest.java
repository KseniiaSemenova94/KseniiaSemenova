package hw1;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class MultiplyTest extends BaseClass {

    // TODO It could be extracted to BaseClass - fixed

    // TODO It could be extracted to BaseClass - fixed
    // TODO Why is it BeforeTest? - changed to BeforeMethod in new class BaseClass

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