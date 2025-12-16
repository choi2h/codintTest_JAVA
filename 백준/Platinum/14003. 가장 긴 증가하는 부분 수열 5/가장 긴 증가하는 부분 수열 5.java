import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] nums = new int[N];
        for (int i=0; i<N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[N];
        int[] record = new int[N];
        int max_cnt=0, max_cnt_index=0;
        for (int i=0; i<N; i++) {
            int index = searchIndex(record, nums[i], max_cnt);
            record[index] = nums[i];
            dp[i] = index+1;
            if (max_cnt < index+1) {
                max_cnt = index+1;
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

    private static int searchIndex(int[] nums, int target, int max_index) {
        if (max_index == 0) return 0;

        int l = 0, r = max_index-1;
        int index = 0;
        while (l <= r) {
            int mid = (r+l) / 2;

            if (nums[mid] <= target) {
                l = mid +1;
                index = Math.max(index, mid);
            } else {
                r = mid-1;
            }
        }

        return nums[index] < target ? index+1 : index;
    }
}
