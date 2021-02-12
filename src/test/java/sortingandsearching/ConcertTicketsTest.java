package sortingandsearching;


import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class ConcertTicketsTest {

    public static class StaticProvider {

        @SuppressWarnings("InnerClassMayBeStatic")
        class TestCase {
            int[] expected;
            int[] prices;
            int[] budgets;

            TestCase(int[] expected, int[] prices, int[] budgets) {
                this.expected = expected;
                this.prices = prices;
                this.budgets = budgets;
            }
        }

        @DataProvider(name = "test_one_ticket_only")
        Object[] test_one_ticket_only() {
            return new TestCase[]{
                    new TestCase(new int[]{4}, new int[]{4}, new int[]{4}),
                    new TestCase(new int[]{-1}, new int[]{5}, new int[]{4}),
                    new TestCase(new int[]{4, -1}, new int[]{4}, new int[]{4, 4}),
                    new TestCase(new int[]{-1, 4}, new int[]{4}, new int[]{3, 4})
            };
        }

        @DataProvider(name = "test_case_1")
        Object[] test_case_1() {
            return new TestCase[]{
                    new TestCase(new int[]{3, 8, -1}, new int[]{5, 3, 7, 8, 5}, new int[]{4, 8, 3}),
                    new TestCase(new int[]{5, 8, 3, 7, 5}, new int[]{5, 3, 7, 8, 5}, new int[]{6, 8, 3, 8, 7}),
                    new TestCase(new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 1}),
                    new TestCase(new int[]{9, 3, 3, 6, 2, 9, -1, -1, -1, -1}, new int[]{9, 3, 9, 6, 6, 8, 6, 2, 6, 3}, new int[]{9, 5, 4, 6, 3, 9, 3, 3, 5, 2})
            };
        }
    }

    @Test(dataProvider = "test_one_ticket_only", dataProviderClass = StaticProvider.class)
    public void test_one_ticket_only(StaticProvider.TestCase tc) {
        Assert.assertEquals(ConcertTickets.solve(tc.prices, tc.budgets), tc.expected);
    }

    @Test(dataProvider = "test_case_1", dataProviderClass = StaticProvider.class)
    public void test_case_1(StaticProvider.TestCase tc) {
        Assert.assertEquals(ConcertTickets.solve(tc.prices, tc.budgets), tc.expected);
    }
}
