import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        List<int[]>[] buses = new ArrayList[n + 1];
        int[][] dp = new int[n + 1][n + 1];
        for (int i = 0; i <= n; i++) {
            buses[i] = new ArrayList<>();
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }

        StringTokenizer st;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            buses[a].add(new int[]{b, c});
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        for (int i = 1; i <= n; i++) {
            boolean[] visited = new boolean[n + 1];
            pq.add(new int[]{i, 0});
            while (!pq.isEmpty()) {
                int[] cur = pq.poll();
                int node = cur[0];
                int cost = cur[1];

                if (visited[node]) continue;
                visited[node] = true;
                for (int[] bus : buses[node]) {
                    int next = bus[0];
                    int nextCost = cost + bus[1];

                    if(next == i || visited[next]) continue;
                    dp[i][next] = Math.min(dp[i][next], nextCost);
                    pq.add(new int[]{next, nextCost});
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i=1; i<=n; i++) {
            int[] costs = dp[i];
            for(int j=1; j<=n; j++) {
                int cost = costs[j];
                sb.append(cost == Integer.MAX_VALUE ? 0 : cost).append(" ");
            }
            sb.append("\n");
        }

        System.out.print(sb);
    }
}