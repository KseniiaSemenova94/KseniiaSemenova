package hw1;

import org.testng.annotations.DataProvider;

public class DataProviders {

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
                {84.555, 15.445, 69.11},
                {74.5258699999, 25.000000256, 49.5258697439},
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
                {84.555, 15.445, 1305.951975},
                {74.5258699999, 25.000000256, 1863.1467690761227199744},
                {0, 0, 0},
                {0.0001, -0.005, -0.0000005},
                {100000000000000D, 100000000000000000D, 10000000000000000000000000000000D}
        };
    }

    @DataProvider(name = "multiply-data-set-long")
    public Object[][] multiplyLongDoubleTestDataSet() {
        return new Object[][]{
                {2, 2, 4},
                {258884693, 5866669, 1518790802997617L},
                {0, 0, 0},
                {58246, 478888123569L, 27893317645399974L}
        };
    }

    @DataProvider(name = "divide-data-set-double")
    public Object[][] divideDoubleTestDataSet() {
        return new Object[][]{
                {0, 1, 0},
                {84.555, 15.445, 5.47458724506312722563936549045},
                {74.5258699999, 25.000000256, 2.9810347694702039606251114431989},
                {1, 1, 1},
                {0.0001, -0.005, -0.02},
                {100000000000000L, 100000000000000000L, 0.001}
        };
    }

    @DataProvider(name = "divide-data-set-long")
    public Object[][] divideLongDoubleTestDataSet() {
        return new Object[][]{
                {2, 2, 1},
                {258884693, 5866669, 44.128055119523532007686133306652},
                {1, 1, 1},
                {58246, 478888888123569L, 1.2162737838462985276114753726371e-10}
        };
    }

}