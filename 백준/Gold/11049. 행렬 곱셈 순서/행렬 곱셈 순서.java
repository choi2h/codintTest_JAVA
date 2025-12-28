import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] nums = new int[N][2];
        StringTokenizer st;
        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            nums[i][0] = Integer.parseInt(st.nextToken());
            nums[i][1] = Integer.parseInt(st.nextToken());
        }

        int[][] dp = new int[N][N];
        for (int x=N-2; x>=0; x--) {
            for (int y=x+1; y<N; y++) {
                int minValue = Integer.MAX_VALUE;
                for(int i=y-1; i>=x; i--) {
                    minValue = Math.min(minValue, dp[x][i] + dp[i+1][y] +
                            nums[x][0]*nums[i][1]*nums[y][1]);
                }

                dp[x][y] = minValue;
            }
        }

        System.out.print(dp[0][N-1]);
    }
}
