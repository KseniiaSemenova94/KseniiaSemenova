package hw1;

import com.epam.tat.module4.Calculator;
import org.testng.annotations.BeforeMethod;

public class BaseClass {

    protected Calculator calculator;

    @BeforeMethod
    public void beforeTest() {
        calculator = new Calculator();
    }

}
