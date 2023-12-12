package baekJoon.dynamic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q24416 {

    int[] dp = new int[41];
    int recursionCount = 0;

    public String solution(int n) {
        int recursionResult = recursion(n);
        System.out.println("Recursion result = " + recursionResult);

        int dynamicCount = dymanic(n);

        return recursionCount + " " + dynamicCount;
    }

    private int recursion (int n) {
        if (n == 1 || n == 2) {
            recursionCount++;
            return 1;
        }

        return recursion(n - 1) + recursion(n - 2);
    }

    private int dymanic (int n) {
        int count=0;

        dp[1] = 1;
        dp[2] = 1;
        for(int i=3; i<=n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
            count++;
        }

        System.out.println("Dynamic result=" + dp[n]);

        return count;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Q24416 q = new Q24416();
        String result = q.solution(n);
        System.out.println("Answer = " + result);
    }
}
