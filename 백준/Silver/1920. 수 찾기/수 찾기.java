import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reander = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reander.readLine());

        int[] nums = new int[n];
        StringTokenizer nNumberTokens = new StringTokenizer(reander.readLine());
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(nNumberTokens.nextToken());
        }

        int m = Integer.parseInt(reander.readLine());
        int[] findNums = new int[m];
        StringTokenizer mNumberTokens = new StringTokenizer(reander.readLine());
        for(int i = 0; i < m; i++) {
            findNums[i] = Integer.parseInt(mNumberTokens.nextToken());
        }

        Arrays.sort(nums);
        int[] result = new int[m];
        for(int i = 0; i < m; i++) {
            boolean isExist = false;

            int l = 0, r = nums.length;
            while (l < r) {
                int mid = (l+r)/2;
                if(nums[mid] == findNums[i]) {
                    isExist = true;
                    break;
                }

                if(findNums[i]<nums[mid]) r = mid;
                else l = mid + 1;
            }

            result[i] = isExist ? 1 : 0;
        }

        for(int i : result) {
            System.out.println(i);
        }
    }
}