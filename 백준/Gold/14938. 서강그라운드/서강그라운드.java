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

    private static Queue<int[]> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer sb = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(sb.nextToken()); // 지역 개수
        int m = Integer.parseInt(sb.nextToken()); // 수색 범위
        int r = Integer.parseInt(sb.nextToken()); // 길의 개수

        int[] items = new int[n+1];
        sb = new StringTokenizer(br.readLine());
        for (int i=1; i<=n; i++) {
            items[i] = Integer.parseInt(sb.nextToken());
        }

        List<int[]>[] roads = new ArrayList[n+1];
        for (int i=1; i<=n; i++) {
            roads[i] = new ArrayList<>();
        }

        for (int i=1; i<=r; i++) {
            sb = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(sb.nextToken());
            int b = Integer.parseInt(sb.nextToken());
            int l = Integer.parseInt(sb.nextToken());

            roads[a].add(new int[]{b, l});
            roads[b].add(new int[]{a, l});
        }

        int maxValue = 16*n;
        int[] dp = new int[n+1];
        boolean[] visited = new boolean[n+1];
        int answer = 0;
        for (int i=1; i<=n; i++) {
            Arrays.fill(dp, maxValue);
            answer = Math.max(answer, getCnt(items, roads, i, m, visited, dp));
            Arrays.fill(visited, false);
        }

        System.out.println(answer);
    }

    private static int getCnt(int[] items, List<int[]>[] roads, int s, int m, boolean[] visited, int[] dp) {
        int cnt = items[s];

        dp[s] = 0;
        queue.add(new int[]{s, 0});
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int cp = cur[0];
            int dist = cur[1];

            for (int[] road : roads[cp]) {
                int np = road[0];
                int nextDist = road[1] + dist;
                if (dp[np] < nextDist || nextDist > m) continue;

                if (!visited[np]) {
                    cnt += items[np];
                    visited[np] = true;
                }

                if (road[1] + dist < m) {
                    queue.add(new int[]{np, nextDist});
                }
            }
        }

        return cnt;
    }

}