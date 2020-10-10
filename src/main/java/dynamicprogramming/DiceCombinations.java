package dynamicprogramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class DiceCombinations {
    private static int solve(int n) {
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
