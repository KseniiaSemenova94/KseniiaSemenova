package hw1;

import com.epam.tat.module4.Calculator;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class AddTest {

    private Calculator calculator;

    @BeforeTest
    public void beforeTest() {
        calculator = new Calculator();
    }

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
