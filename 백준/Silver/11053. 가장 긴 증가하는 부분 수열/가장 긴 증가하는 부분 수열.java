import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] nums = new int[N];
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[N];
        dp[N-1] = 1;
        for (int i=N-2; i>=0; i--) {
            int max = 1;
            for (int j=i+1; j<N; j++) {
                if (nums[j] > nums[i]) {
                    max = Math.max(max, dp[j]+1);
                }
            }

            dp[i] = max;
        }

        int answer = 0;
        for (int i=0; i<N; i++) {
            answer = Math.max(dp[i], answer);
        }

        System.out.print(answer);
    }
}
