import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        List<int[]>[] arr = new ArrayList[n+1];
        for(int i = 0; i<=n; i++) {
            arr[i] = new ArrayList<>();
        }

        StringTokenizer st;
        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            arr[a].add(new int[]{b,c});
        }

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        Queue<Integer> q = new LinkedList<>();
        q.add(start);

        History[] dp = new History[n+1];
        History history = new History(0, new ArrayList<>());
        history.move(start);
        dp[start] = history;

        boolean[] visited = new boolean[n+1];
        while(!q.isEmpty()) {
            int curNode = q.poll();
            if(visited[curNode]) continue;
            visited[curNode] = true;

            int curCost = dp[curNode].cost;
            for(int[] bus : arr[curNode]) {
                int next = bus[0];
                int cost = bus[1];

                if(dp[next] == null || dp[next].cost > curCost+cost) {
                    dp[next] = new History(curCost+cost, new ArrayList<>(dp[curNode].visited));
                    dp[next].move(next);

                    if(next == end) continue;
                    q.add(next);
                    visited[next] = false;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(dp[end].cost).append("\n");
        sb.append(dp[end].visited.size()).append("\n");
        for(int i : dp[end].visited) {
            sb.append(i).append(" ");
        }

        System.out.println(sb);
    }

    private static class History {
        int cur;
        int cost;
        List<Integer> visited;

        public History(int cost, List<Integer> visited) {
            this.cost = cost;
            this.visited = visited;
        }

        public void move(int cur) {
            this.cur = cur;
            visited.add(cur);
        }
    }
}