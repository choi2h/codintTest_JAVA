package baekJoon.dynamic;

import java.util.Scanner;

public class Q2193 {

    // n [자리수][index]
    // index 0 : 0으로 시작하는 경우의 수
    // index 1 : 1로 시작하는 경우의 수
    static long[][] dp;

    static long solution(int n) {
        dp = new long[n+1][2];

        dp[1][0] = 1;
        dp[1][1] = 1;

        for(int i=2; i<=n; i++) {
            dp[i][0] = dp[i-1][0] + dp[i-1][1];
            dp[i][1] = dp[i-1][0];
        }

        return dp[n][1];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        long answer = solution(n);
        System.out.println(answer);
    }
}
