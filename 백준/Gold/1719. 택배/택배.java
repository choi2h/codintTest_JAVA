import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 집하장 개수 200이하
        int m = Integer.parseInt(st.nextToken()); // 집하장 간 경로의 개수 10000 이하

        List<int[]>[] dists = new ArrayList[n+1];
        long[][] dp = new long[n+1][n+1];
        for (int i=1; i<=n; i++) {
            dists[i] = new ArrayList<>();
            Arrays.fill(dp[i], Long.MAX_VALUE);
        }

        for (int i=1; i<=m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            dists[a].add(new int[]{b, c});
            dists[b].add(new int[]{a, c});
        }

        int[][] result = new int[n+1][n+1];
        Queue<Integer> queue = new LinkedList<>();
        for (int i=1; i<=n; i++) {
            queue.add(i);
            dp[i][i] = 0;

            while(!queue.isEmpty()) {
                int cp = queue.poll();

                for (int[] next : dists[cp]) {
                    int np = next[0];
                    int dist = next[1];
                    if (dp[i][np] <= dp[i][cp] + dist) continue;

                    dp[i][np] = dp[i][cp] + dist;
                    result[i][np] = result[i][cp] == 0 ? np : result[i][cp];
                    queue.add(np);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i=1; i<=n; i++) {
            for (int j=1; j<=n; j++) {
                if (i == j) sb.append("-").append(" ");
                else sb.append(result[i][j]).append(" ");
            }

            sb.append("\n");
        }

        System.out.println(sb);
    }

}