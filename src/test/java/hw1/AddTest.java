package hw1;

import com.epam.tat.module4.Calculator;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class AddTest {

    @DataProvider(name = "data-set")
    public Object[][] addTestDataSet() {
        return new Object[][] {
                {2, 2, 4},
                {1, 10, 11},
                {0.0001, 0.005, 0.0051}
        };
    }

    @Test(dataProvider = "data-set")
    public void addTest1(double a, double b, double result) {
        Calculator calculator = new Calculator();
        double actual = calculator.sum(a, b);
        assertEquals(result, actual);
    }

}
