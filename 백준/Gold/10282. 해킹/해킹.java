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

    private static Queue<Integer> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        while (t-->0) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken()); // 컴퓨터 개수
            int d = Integer.parseInt(st.nextToken()); // 의존성 개수
            int c = Integer.parseInt(st.nextToken()); // 해킹컴 번호

            List<int[]>[] connected = new ArrayList[n+1];
            for (int i=1; i<=n; i++) {
                connected[i] = new ArrayList<>();
            }

            for (int i=0; i<d; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int s = Integer.parseInt(st.nextToken());

                connected[b].add(new int[]{a, s});
            }

            int[] dp = new int[n+1];
            Arrays.fill(dp, -1);
            checkMinTime(dp, connected, c);

            int max = 0, cnt = 0;
            for (int j=1; j<=n; j++) {
                if (dp[j] == -1) continue;
                cnt++;
                max = Math.max(max, dp[j]);
            }

            sb.append(cnt).append(" ").append(max).append("\n");
        }

        System.out.print(sb);
    }

    private static void checkMinTime(int[] dp, List<int[]>[] connected, int start) {
        dp[start] = 0;

        queue.add(start);
        while (!queue.isEmpty()) {
            int cur = queue.poll();

            for (int[] next : connected[cur]) {
                int np = next[0];
                int time = next[1];

                if (dp[np] > -1 && dp[np] <= dp[cur]+time) continue;
                dp[np] = dp[cur]+time;
                queue.add(np);
            }
        }
    }
}