import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] inputCounts = reader.readLine().split(" ");
        int numCount = Integer.parseInt(inputCounts[0]);
        int inputCount = Integer.parseInt(inputCounts[1]);

        int[] nums = new int[numCount+1];
        for(int i =0; i<nums.length; i++) {
            nums[i] = i;
        }

        for(int i=0; i<inputCount; i++) {
            StringTokenizer st = new StringTokenizer(reader.readLine());
            int type = Integer.parseInt(st.nextToken());
            int num1 = Integer.parseInt(st.nextToken());
            int num2 = Integer.parseInt(st.nextToken());

            int a = find(nums, num1);
            int b = find(nums, num2);
            if(type == 0 && a != b) {
                nums[b] = a;
            } else if(type == 1) {
                if(find(nums, num1) == find(nums, num2)) System.out.println("YES");
                else System.out.println("NO");
            }
        }
    }

    private static int find(int[] nums, int n) {
        if(nums[n] == n) {
            return n;
        }

        return nums[n] = find(nums, nums[n]);
    }
}