import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[][] stuffs = new int[N][2];
        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            stuffs[i][0] = Integer.parseInt(st.nextToken());
            stuffs[i][1] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[K+1];
        for (int i=0; i<N; i++) {
            int[] tmp = new int[K+1];
            int w = stuffs[i][0];
            for (int j=0; j<=K; j++) {
                if (j < w) tmp[j] = dp[j];
                else tmp[j] = Math.max(dp[j], dp[j-w] + stuffs[i][1]);
            }

            dp = tmp;
        }

        int max = 0;
        for (int i=1; i<=K; i++) {
            max = Math.max(dp[i], max);
        }

        System.out.println(max);
    }
}