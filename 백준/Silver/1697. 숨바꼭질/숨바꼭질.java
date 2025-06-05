import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    private static final int[] move_point = {-1, 1, 2};

    public int solution(int n, int k) {
        int[] dp = new int[100001];
        bfs(dp, n);

        return dp[k];
    }

    private void dfs(int[] dp, int cur) {
        if(cur < 0 || cur >= dp.length) return;

        for(int m : move_point) {
            int next = m > 1 ? cur*m : cur+m;
            if(next < 0 || next >= dp.length || (dp[next] > 0 && dp[next] <= dp[cur]+1)) continue;
            dp[next] = dp[cur] + 1;
            dfs(dp, next);
        }
    }

    private void bfs(int[] dp, int n) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(n);

        while(!queue.isEmpty()) {
            int cur = queue.poll();
            if(cur < 0 || cur >= dp.length) continue;
            for(int m : move_point) {
                int next = m > 1 ? cur*m : cur+m;
                if(next < 0 || next >= dp.length || next == n || (dp[next] > 0 && dp[next] <= dp[cur]+1)) continue;
                dp[next] = dp[cur] + 1;
                queue.add(next);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int k = Integer.parseInt(input[1]);
        Main main = new Main();
        int result = main.solution(n, k);
        System.out.println(result);
    }
}