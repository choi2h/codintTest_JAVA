import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static int max = Integer.MIN_VALUE;
    private static int min = Integer.MAX_VALUE;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] nums = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        int[] calTypes = new int[4];
        for(int i=0; i<4; i++) {
            calTypes[i] = Integer.parseInt(st.nextToken());
        }

        dfs(nums, calTypes, 1, nums[0]);

        System.out.println(max + "\n" + min);
    }

    private static void dfs(int[] nums, int[] calTypes, int idx, int res) {
        if(idx == nums.length) {
            min = Math.min(min, res);
            max = Math.max(max, res);
        }

        for(int i=0; i<calTypes.length; i++) {
            if(calTypes[i] == 0) continue;

            calTypes[i]--;
            dfs(nums, calTypes, idx+1, calculate(res, nums[idx], i));
            calTypes[i]++;
        }
    }

    private static int calculate(int a, int b, int calType) {
        switch (calType) {
            case 0: return a+b;
            case 1: return a-b;
            case 2: return a*b;
            case 3: return a/b;
        }

        return a;
    }
}