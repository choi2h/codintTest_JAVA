import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        long[] floors = new long[n];
        for(int i=0; i<n; i++) {
            floors[i] = Long.parseLong(br.readLine());
        }

        if (n <= 2) {
            if (n == 1) System.out.print(floors[0]);
            else if (n == 2) System.out.print(floors[0] + floors[1]);
            return;
        }

        // 최댓값 구하기
        long[][] dp = new long[n][2];
        dp[0][0] = floors[0];
        dp[0][1] = floors[0];
        dp[1][0] = floors[1];
        dp[1][1] = floors[0] + floors[1];
        for(int i=2; i<n; i++) {
            // 0 - 이전 층을 안 밟았을 때
            dp[i][0] = Math.max(dp[i-2][0], dp[i-2][1]) + floors[i];
            // 1 - 이전 층을 밟을 때
            dp[i][1] = dp[i-1][0] + floors[i];
        }

        System.out.print(Math.max(dp[n-1][0], dp[n-1][1]));
    }
    
}