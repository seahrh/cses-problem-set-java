/*
There are n concert tickets available, each with a certain price.
Then, m customers arrive, **one after another**.
Each customer announces the maximum price he or she is willing to pay for a ticket,
and after this, they will get a ticket with the **nearest possible price**
such that it does not exceed the maximum price.
Input
The first input line contains integers n and m: the number of tickets and the number of customers.
The next line contains n integers h1,h2,…,hn: the price of each ticket.
The last line contains m integers t1,t2,…,tm: the maximum price for each customer.
Output
Print, for each customer, the price that they will pay for their ticket.
After this, the ticket cannot be purchased again.
If a customer cannot get any ticket, print −1.
Constraints
1≤n,m≤2⋅10^5
1≤hi,ti≤10^9
Example
Input:
5 3
5 3 7 8 5
4 8 3
Output:
3
8
-1
See https://cses.fi/problemset/task/1091
SOLUTION
Requirement: Sell the most expensive ticket that meets the customer's budget
Time O((N + M) lg N)
Space O(N): store the ticket prices in a SortedMap where K is the price and V is the count.
*/
package sortingandsearching;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;


public class ConcertTickets {
    static int[] solve(int[] prices, int[] budgets) {
        int[] res = new int[budgets.length];
        Arrays.fill(res, -1);
        TreeMap<Integer, Integer> sortedPrices = new TreeMap<>();
        Integer count;
        for (int p : prices) {
            count = sortedPrices.get(p);
            if (count == null) {
                count = 0;
            }
            sortedPrices.put(p, ++count);
        }
        Map.Entry<Integer, Integer> entry;
        int p;
        for (int i = 0; i < budgets.length; i++) {
            entry = sortedPrices.floorEntry(budgets[i]);
            if (entry == null) {
                continue;
            }
            p = entry.getKey();
            count = entry.getValue();
            res[i] = p;
            if (--count == 0) {
                sortedPrices.remove(p);
            } else {
                sortedPrices.put(p, count);
            }
        }
        return res;
    }

    public static void main(String[] args) throws IOException {
        int[] prices;
        int[] budgets;
        StringTokenizer st;
        int i;
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String line = br.readLine();
            st = new StringTokenizer(line);
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            prices = new int[n];
            budgets = new int[m];
            line = br.readLine();
            st = new StringTokenizer(line);
            i = 0;
            while (st.hasMoreTokens()) {
                prices[i] = Integer.parseInt(st.nextToken());
                i++;
            }
            line = br.readLine();
            st = new StringTokenizer(line);
            i = 0;
            while (st.hasMoreTokens()) {
                budgets[i] = Integer.parseInt(st.nextToken());
                i++;
            }
        }
        for (int pmt : solve(prices, budgets)) {
            System.out.println(pmt);
        }
    }
}
