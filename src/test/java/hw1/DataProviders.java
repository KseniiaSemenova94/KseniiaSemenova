package hw1;

import org.testng.annotations.DataProvider;

public class DataProviders {

    //  TODO Why do you choose this set of data?
    @DataProvider(name = "add-data-set-double")
    public Object[][] addTestDoubleDataSet() {
        return new Object[][]{
                {84.555, 15.445, 100},
                {74.5258699999, 25.000000256, 99.5258702559},
                {0, 0, 0},
                {0.0001, -0.005, -0.0049}
        };
    }

    @DataProvider(name = "add-data-set-long")
    public Object[][] addTestLongDataSet() {
        return new Object[][]{
                {2, 2, 4},
                {258884693, 5866669333575L, 5866928218268L},
                {0, 0, 0},
                {58246, 478888888123569L, 478888888181815L}
        };
    }

    @DataProvider(name = "subtract-data-set-double")
    public Object[][] subtractDoubleTestDataSet() {
        return new Object[][]{
                {84.555, 15.445, 69.11000000000001},
                {74.5258699999, 25.000000256, 49.525869743899996},
                {0, 0, 0},
                {0.0001, -0.005, 0.0051}
        };
    }

    @DataProvider(name = "subtract-data-set-long")
    public Object[][] subtractLongDoubleTestDataSet() {
        return new Object[][]{
                {2, 2, 0},
                {258884693, 5866669333575L, -5866410448882L},
                {0, 0, 0},
                {58246, 478888888123569L, -478888888065323L}
        };
    }

    @DataProvider(name = "multiply-data-set-double")
    public Object[][] multiplyDoubleTestDataSet() {
        return new Object[][]{
                {84.555, 15.445, 1305.0},
                {74.5258699999, 25.000000256, 1863.0},
                {0, 0, 0},
                {0.0001, -0.005, -1.0},
                {100000000000000L, 100000000000000000L, 1.0E31}
        };
    }

    @DataProvider(name = "multiply-data-set-long")
    public Object[][] multiplyLongDoubleTestDataSet() {
        return new Object[][]{
                {2, 2, 4},
                {258884693, 5866669, 1518790802997617L},
                {0, 0, 0},
                {58246, 478888888123569L, -9000125969773703258L}
        };
    }

    @DataProvider(name = "divide-data-set-double")
    public Object[][] divideDoubleTestDataSet() {
        return new Object[][]{
                {0, 1, 0},
                {1, 0, Double.POSITIVE_INFINITY},
                {84.555, 15.445, 5.474587245063128},
                {74.5258699999, 25.000000256, 2.9810347694702037},
                {1, 1, 1},
                {0.0001, -0.005, -0.02},
                {100000000000000L, 100000000000000000L, 0.001}
        };
    }

    @DataProvider(name = "divide-data-set-long")
    public Object[][] divideLongDoubleTestDataSet() {
        return new Object[][]{
                {2, 2, 1},
                {258884693, 5866669, 44},
                {1, 1, 1},
                {58246, 478888888123569L, 0}
        };
    }

}
