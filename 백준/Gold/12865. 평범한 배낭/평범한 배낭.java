import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int solution(int n, int maxWeight, int[][] stuffs) {
        int[][] dp = new int[n + 1][maxWeight + 1];

        for (int k = 1; k <= maxWeight; k++) { 
            for (int i = 1; i <= n; i++) { 
                dp[i][k] = dp[i - 1][k];
                if (k >= stuffs[i][0]) {
                    dp[i][k] = Math.max(dp[i - 1][k], stuffs[i][1] + dp[i - 1][k - stuffs[i][0]]);
                }
            }
        }
        return dp[n][maxWeight];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] values = bf.readLine().split(" ");
        int n = Integer.parseInt(values[0]);
        int maxWeight = Integer.parseInt(values[1]);

        int[][] stuffs = new int[n+1][2];
        for(int i=1; i<=n; i++) {
            String[] line = bf.readLine().split(" ");
            stuffs[i][0] = Integer.parseInt(line[0]);
            stuffs[i][1] = Integer.parseInt(line[1]);
        }

        int result = solution(n, maxWeight, stuffs);
        System.out.println(result);
    }
}
