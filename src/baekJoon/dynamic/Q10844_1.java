package baekJoon.dynamic;

import java.util.Scanner;

public class Q10844_1 {
    static int N;
    static long mod = 1000000000;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        long dp[][] = new long[N+1][10];

        /* 첫번째 자릿수는 경우의 수가 하나 뿐임 */
        for(int i=1; i<10; i++) {
            dp[1][i] = 1;
        }


        /* 두번째 자릿수부터 N번째 자릿수까지 탐색 */
        for(int i=2; i<=N; i++) {
            /* 현재 자릿값을 0부터 9까지 탐색*/
            for(int j=0; j<10; j++) {
                // 자릿값이 9라면 이전 자릿값은 8만 가능
                if(j == 9) {
                    dp[i][9] = dp[i-1][8]%mod;
                }
                // 자릿값이 0이라면 이전 자릿값은 1만 가능
                else if(j==0) {
                    dp[i][0] = dp[i-1][1] % mod;
                }
                // 그 외는 현재 자릿값의 -1, +1 가능
                else {
                    dp[i][j] = (dp[i-1][j-1]+ dp[i-1][j+1])%mod;
                }
            }
        }

        long ans = 0;
        for(int i=0; i<10; i++) {
            ans += dp[N][i];
        }

        System.out.println(ans%mod);
    }
}
