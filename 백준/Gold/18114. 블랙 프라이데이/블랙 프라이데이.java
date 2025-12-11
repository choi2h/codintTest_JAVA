import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int C = Integer.parseInt(input[1]);
        StringTokenizer  st = new StringTokenizer(br.readLine());
        int[] nums = new int[N];
        for (int i=0; i<N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());

            if (nums[i] == C) {
                System.out.println(1);
                return;
            }
        }

        Arrays.sort(nums);
        for (int i=0; i<N; i++) {
            int target = C-nums[i];
            int left = i+1, right = N-1;

            while (left < right) {
                int sum = nums[left] + nums[right];
                if (target == nums[left] || target == nums[right] || sum == target) {
                    System.out.println(1);
                    return;
                }

                if (sum < target) left++;
                else right--;
            }
        }

        System.out.print(0);
    }

}
