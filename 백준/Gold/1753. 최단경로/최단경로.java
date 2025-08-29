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
        StringTokenizer st = new StringTokenizer(br.readLine());
        int v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());

        int start = Integer.parseInt(br.readLine());
        List<int[]>[] lines = new ArrayList[v+1];
        for(int i = 0; i <= v; i++) {
            lines[i] = new ArrayList<>();
        }

        for(int i=0; i<e; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            lines[a].add(new int[]{b, c});
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        pq.add(new int[]{start, 0});

        int[] dp = new int[v+1];
        Arrays.fill(dp, Integer.MAX_VALUE);

        dp[start] = 0;
        boolean[] visited = new boolean[v+1];
        while(!pq.isEmpty()) {
            int[] cur = pq.poll();

            if(visited[cur[0]]) continue;
            visited[cur[0]] = true;
            for(int[] line : lines[cur[0]]) {
                int next = line[0];
                int cost = cur[1] + line[1];

                if(visited[next] || dp[next] < cost) continue;
                dp[next] = cost;
                pq.add(new int[]{next, cost});
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i=1; i<dp.length; i++) {
            sb.append(dp[i] == Integer.MAX_VALUE ? "INF": dp[i]).append("\n");
        }

        System.out.print(sb);
    }
}