import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] nums = new int[N];
        for (int i=0; i<N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[N];
        int max_cnt = 0, max_cnt_index = 0;
        for (int i=0; i<N; i++) {
            dp[i] = 1;
            for (int j=i-1; j>=0; j--) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }

            if (max_cnt < dp[i]) {
               max_cnt = dp[i];
               max_cnt_index = i;
            }
        }

        Stack<Integer> stack = new Stack<>();
        stack.push(nums[max_cnt_index]);
        int before = nums[max_cnt_index];
        max_cnt--;
        int i = max_cnt_index-1;
        while (max_cnt > 0) {
            if (nums[i] < before && dp[i] == max_cnt) {
                stack.push(nums[i]);
                before = nums[i];
                max_cnt--;
            }
            i--;
        }

        StringBuilder sb = new StringBuilder();
        sb.append(dp[max_cnt_index]).append("\n");
        while (!stack.isEmpty()) {
            sb.append(stack.pop()).append(" ");
        }

        System.out.println(sb);
    }

}