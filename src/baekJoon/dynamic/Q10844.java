package baekJoon.dynamic;

import java.util.Scanner;

// 18404112
// 677110544
public class Q10844 {

    static long[][] dp;
    static int mod = 1000000000;

    static int solution(int n) {
        dp = new long[n+1][10];

        for(int i=0; i<10; i++) {
            dp[1][i] = 1;
        }

        for(int i=2; i<=n; i++) {
            for(int j=0; j<10; j++) {
                if(j == 9) {
                    dp[i][j] = dp[i-1][j-1];
                } else if( j== 0) {
                    dp[i][j] = dp[i-1][j+1];
                } else {
                    dp[i][j] = dp[i-1][j-1] + dp[i-1][j+1];
                }

                dp[i][j] = dp[i][j] % mod;
            }
        }

        int answer = 0;
        for(int i=1; i<10; i++) {
            answer += dp[n][i];
        }

        return answer%mod;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());

        int answer = solution(n);
        System.out.println(answer);
    }
}
