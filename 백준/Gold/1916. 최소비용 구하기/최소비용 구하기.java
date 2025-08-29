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
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        List<int[]>[] arr = new ArrayList[n+1];
        for(int i=0; i<=n; i++) {
            arr[i] = new ArrayList<>();
        }

        StringTokenizer st;
        for (int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());
            arr[a].add(new int[]{b, z});
        }

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        int[] dp = new int[n+1];
        Arrays.fill(dp, Integer.MAX_VALUE);

        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[n+1];
        q.add(start);
        dp[start] = 0;
        while(!q.isEmpty()) {
            int cur = q.poll();
            int curCost = dp[cur];

            if(visited[cur]) continue;
            visited[cur] = true;
            for(int[] bus : arr[cur]) {
                int next = bus[0];
                int cost = bus[1];

                if(dp[next] > curCost+cost) {
                    if(cur != end) q.add(next);
                    dp[next] = curCost+cost;
                    visited[next] = false;
                }
            }
        }

        System.out.print(dp[end]);
    }
}