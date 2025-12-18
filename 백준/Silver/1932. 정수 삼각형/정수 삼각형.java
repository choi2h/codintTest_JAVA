import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[][] nums = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j <= i; j++) {
                nums[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] dp = new int[N][N];
        dp[0][0] = nums[0][0];
        for (int i = 1; i < N; i++) {
            for (int j = 0; j <= i; j++) {
                if (j==0) {
                    dp[i][j] = dp[i-1][j] + nums[i][j];
                } else if (j == i) {
                    dp[i][j] = dp[i-1][j-1] + nums[i][j];
                } else {
                    dp[i][j] = Math.max(dp[i-1][j-1], dp[i-1][j]) + nums[i][j];
                }
            }
        }

        int answer = 0;
        for (int i = 0; i < N; i++) {
            answer = Math.max(answer, dp[N-1][i]);
        }

        System.out.println(answer);
    }

}
