import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        List<Integer>[] nodes = new ArrayList[N+1];
        for (int i=1; i<N+1; i++) {
            nodes[i] = new ArrayList<>();
        }

        StringTokenizer st;
        for (int i=0; i<N-1; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            nodes[s].add(e);
            nodes[e].add(s);
        }

        int[][] dp = new int[N+1][2];
        boolean[] visited = new boolean[N+1];
        find(nodes, 1, dp, visited);

        System.out.print(Math.min(dp[1][0], dp[1][1]));
    }

    private static void find(List<Integer>[] nodes, int cur, int[][] dp, boolean[] visited) {
        visited[cur] = true;
        dp[cur][0] = 1;

        for (int node: nodes[cur]) {
            if (!visited[node]) {
                find(nodes, node, dp, visited);
                dp[cur][0] += Math.min(dp[node][0], dp[node][1]);
                dp[cur][1] += dp[node][0];
            }
        }
    }
}