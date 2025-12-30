import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Arrays;


public class Main {

    private static final int INF = 5_000_001;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());

            int[][][] dp = new int[N][N][2];
            for (int i=0; i<N; i++) {
                int cost = Integer.parseInt(st.nextToken());
                dp[i][i][0] = cost;
            }

            for (int x=N-2; x>=0; x--) {
                for (int y=x+1; y<N; y++) {
                    dp[x][y][0] = dp[x][x][0] + dp[x+1][y][0];
                    for (int i=1; y-i>=x; i++) {
                        int sum = dp[x][y-i][1] + dp[y-i+1][y][1] + dp[x][y][0];
                        dp[x][y][1] = dp[x][y][1] == 0 || dp[x][y][1] > sum ? sum : dp[x][y][1];
                    }
                }
            }

            sb.append(dp[0][N-1][1]).append("\n");
        }

        System.out.println(sb);
    }
}