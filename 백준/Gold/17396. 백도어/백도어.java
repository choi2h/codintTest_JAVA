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
        int N = Integer.parseInt(st.nextToken()); // 분기점의 수
        int M = Integer.parseInt(st.nextToken()); // 분기점들을 잇는 길의 수

        boolean[] look = new boolean[N]; // 0이 안보이는 것 1 이 보이는 것
        st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++) {
            look[i] = Integer.parseInt(st.nextToken()) == 1;
        } // 0 = 0 / n-1 = 1

        List<int[]>[] paths = new ArrayList[N+1];
        for (int i=0; i<N; i++) {
            paths[i] = new ArrayList<>();
        }

        for (int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            paths[a].add(new int[]{b, c});
            paths[b].add(new int[]{a, c});
        }

        long[] dp = new long[N];
        Arrays.fill(dp, Long.MAX_VALUE);
        PriorityQueue<PathInfo> queue = new PriorityQueue<>(Comparator.comparingLong(a -> a.time));
        queue.add(new PathInfo(0, 0));
        dp[0] = 0;
        while(!queue.isEmpty()) {
            PathInfo curInfo = queue.poll();
            int cur = curInfo.cur;
            long time = curInfo.time;

            if (cur == N-1) break;
            if (dp[cur] < time) continue;

            for (int[] next : paths[cur]) {
                int np = next[0];
                int t = next[1];
                if ((np < N-1 && look[np]) || dp[np] <= time+t) continue;

                dp[np] = time+t;
                queue.add(new PathInfo(np, time+t));
            }
        }

        System.out.println(dp[N-1] == Long.MAX_VALUE ? -1 : dp[N-1]);
    }

    private static class PathInfo {
        int cur;
        long time;

        public PathInfo(int cur, long time) {
            this.cur = cur;
            this.time = time;
        }
    }
}