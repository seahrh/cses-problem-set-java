package dynamicprogramming;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class DiceCombinationsTest {

    public static class StaticProvider {

        @SuppressWarnings("InnerClassMayBeStatic")
        class TestCase {
            int expected;
            int n;

            TestCase(int expected, int n) {
                this.expected = expected;
                this.n = n;
            }
        }

        @DataProvider(name = "data")
        Object[] data() {
            return new TestCase[]{
                    new TestCase(1, 1),
                    new TestCase(2, 2),
                    new TestCase(4, 3),
                    new TestCase(8, 4),
                    new TestCase(16, 5),
                    new TestCase(32, 6),
                    new TestCase(63, 7),
                    new TestCase(125, 8),
                    new TestCase(248, 9),
            };
        }
    }

    @Test(dataProvider = "data", dataProviderClass = StaticProvider.class)
    public void test_case_1(StaticProvider.TestCase tc) {
        Assert.assertEquals(DiceCombinations.solve(tc.n), tc.expected);
    }
}
