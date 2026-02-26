import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);
        if (N >= M) {
            System.out.println(Math.abs(M-N));
            return;
        }

        int[] dp = new int[M+1];
        Arrays.fill(dp, M-N);
        dp[N] = 0;

        Queue<Integer> dist_queue = new LinkedList<>();
        dist_queue.add(N);
        while (!dist_queue.isEmpty()) {
            int cur = dist_queue.poll();

            int minus = cur-1;
            if (minus >= 0 && dp[minus] > dp[cur]+1) {
                dist_queue.add(minus);
                dp[minus] = dp[cur]+1;
            }

            int sum = cur+1;
            if (sum <= M && dp[sum] > dp[cur]+1) {
                if (sum < M) dist_queue.add(sum);
                dp[sum] = dp[cur]+1;
            } else if (sum > M && dp[M] > dp[cur]+1+(sum-M)) {
                dp[M] = dp[cur]+1+(sum-M);
            }

            int mul = cur*2;
            if (mul <= M && dp[mul] > dp[cur]) {
                dist_queue.add(mul);
                dp[mul] = dp[cur];
            } else if (mul > M && dp[M] > dp[cur]+(mul-M)) {
                dp[M] = dp[cur]+(mul-M);
            }
        }

        System.out.println(dp[M]);
    }
}