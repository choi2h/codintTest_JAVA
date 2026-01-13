import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st;
        int[][] nodes = new int[n+1][n+1];
        for (int i=1; i<=n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<=n; j++) {
                nodes[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        boolean[] visited = new boolean[n+1];
        int[][] result = new int[n+1][n+1];
        StringBuilder sb = new StringBuilder();
        for (int i=1; i<=n; i++){
            find(i, visited, nodes);

            for (int j=1; j<=n; j++) {
                if (i==j) continue;
                if (visited[j]) {
                    result[i][j] = 1;

                    if (nodes[j][i] == 1) result[i][i] = 1;
                }
            }

            reset(visited);
        }

        for (int i=1; i<=n; i++) {
            for (int j=1; j<=n; j++) {
                sb.append(result[i][j]).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    private static void find(int n, boolean[] visited, int[][] nodes) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        queue.add(n);

        while(!queue.isEmpty()) {
            int cur = queue.poll();

            if (visited[cur]) continue;
            visited[cur] = true;

            for (int i=1; i<nodes.length; i++) {
                if (nodes[cur][i] == 1 && !visited[i]) {
                    queue.add(i);
                }
            }
        }
    }

    private static void reset(boolean[] visited) {
        for(int i=1; i<visited.length; i++) {
            visited[i] = false;
        }
    }
}