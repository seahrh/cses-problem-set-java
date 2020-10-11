/*
Your task is to count the number of ways to construct sum n by throwing a dice one or more times.
Each throw produces an outcome between 1 and 6.
For example, if n=3, there are 4 ways:
1+1+1
1+2
2+1
3
Input
The only input line has an integer n.
Output
Print the number of ways modulo 10^9+7.
Constraints
1≤n≤10^6
Example
Input:
3
Output:
4


SOLUTION
Bottom up DP approach: adding a die roll to previous entries
f[x] = f[x-1] + f[x-2] + f[x-3] + f[x-4] + f[x-5] + f[x-6]
Time O(N)
Space O(N): memo array
 */
package dynamicprogramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class DiceCombinations {
    static int solve(int n) {
        int mod = (int) Math.pow(10, 9) + 7;
        int[] mem = new int[n + 1];
        Arrays.fill(mem, 0);
        mem[0] = 1;
        for (int i = 0; i < n + 1; i++) {
            for (int j = 1; j < 7; j++) {
                if (i - j >= 0) {
                    mem[i] += mem[i - j];
                    mem[i] = mem[i] % mod;
                }
            }
        }
        return mem[n];
    }

    public static void main(String[] args) throws IOException {
        int n;
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            n = Integer.parseInt(reader.readLine());
        }
        System.out.println(solve(n));
    }
}
