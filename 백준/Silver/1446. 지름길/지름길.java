import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());

        int[][] roads = new int[N][3];
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            roads[i][0] = Integer.parseInt(st.nextToken());
            roads[i][1] = Integer.parseInt(st.nextToken());
            roads[i][2] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(roads, Comparator.comparingInt(o -> o[0]));
        int idx = 0;
        int[] dp = new int[D+1];
        for (int i=0; i<=D; i++) {
            dp[i] = i;
        }

        for (int i=0; i<D; i++) {
            dp[i+1] = Math.min(dp[i]+1, dp[i+1]);

            while (idx < N && roads[idx][0] == i) {
                if (roads[idx][1] > D) {
                    idx ++;
                    continue;
                }

                int end = roads[idx][1];
                int length = roads[idx][2];

                dp[end] = Math.min(dp[i] + length, dp[end]);
                idx++;
            }
        }

        System.out.println(dp[D]);
    }
}