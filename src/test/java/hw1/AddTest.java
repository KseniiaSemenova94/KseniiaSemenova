package hw1;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class AddTest extends BaseClass {

    // TODO It could be extracted to BaseClass - fixed

    // TODO It could be extracted to BaseClass - fixed
    // TODO Why is it BeforeTest? - changed to BeforeMethod in new class BaseClass
    // I read about the difference between the annotations once again

    @Test(dataProviderClass = DataProviders.class,
            dataProvider = "add-data-set-double")
    public void addTestDouble(double a, double b, double result) {
        double actual = calculator.sum(a, b);
        assertEquals(result, actual);
    }

    @Test(dataProviderClass = DataProviders.class,
            dataProvider = "add-data-set-long")
    public void addTestLong(long a, long b, long result) {
        long actual = calculator.sum(a, b);
        assertEquals(result, actual);
    }

}
