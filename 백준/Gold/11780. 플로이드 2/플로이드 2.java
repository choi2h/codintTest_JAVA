import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
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
        List<Integer>[][] routes = new ArrayList[n+1][n+1];
        int[][] dp = new int[n + 1][n + 1];
        for (int i = 0; i <= n; i++) {
            buses[i] = new ArrayList<>();
            Arrays.fill(dp[i], Integer.MAX_VALUE);

            for(int j = 0; j <= n; j++) {
                routes[i][j] = new ArrayList<>();
            }
        }

        StringTokenizer st;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            buses[a].add(new int[]{b, c});
        }

        PriorityQueue<Route> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.cost));
        boolean[] visited = new boolean[n + 1];
        for (int i = 1; i <= n; i++) {
            pq.add(new Route(i, 0));

            while(!pq.isEmpty()) {
                Route route = pq.poll();
                int curNode = route.cur;
                int curCost = route.cost;

                if(visited[curNode]) continue;
                visited[curNode] = true;
                for(int[] bus : buses[curNode]) {
                    int next = bus[0];
                    int cost = curCost+bus[1];

                    if(next == i || visited[next] || dp[i][next] <= cost) continue;
                    dp[i][next] = cost;
                    routes[i][next] = new ArrayList<>(route.nodes);
                    pq.add(new Route(next, cost, routes[i][next]));
                }
            }

            Arrays.fill(visited, false);
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

        for(int i=1; i<=n; i++) {
            for(int j=1; j<=n; j++) {
                List<Integer> route = routes[i][j];
                if(route.isEmpty()) sb.append("0");
                else {
                    sb.append(route.size()).append(" ");
                    for(int node : route) {
                        sb.append(node).append(" ");
                    }
                }
                sb.append("\n");
            }
        }

        System.out.print(sb);
    }

    static class Route {
        final int cur;
        final int cost;
        final List<Integer> nodes;

        public Route(int cur, int cost) {
            this.cur = cur;
            this.cost = cost;
            this.nodes = new ArrayList<>();
            nodes.add(cur);
        }

        public Route(int cur, int cost, List<Integer> nodes) {
            this.cur = cur;
            this.cost = cost;
            this.nodes = nodes;
            nodes.add(cur);
        }
    }
}