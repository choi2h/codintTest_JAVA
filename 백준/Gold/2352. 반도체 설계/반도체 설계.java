import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] lines = new int[n+1];
        for(int i=1; i<=n; i++) {
            lines[i] = sc.nextInt();
        }

        int maxCount = 0;
        int[] dp = new int[n+1];
        for(int i=n; i>0; i--) {
            dp[i] = find(lines, dp, i);
            maxCount = Math.max(maxCount, dp[i]);
        }

        System.out.println(maxCount);
    }

    private static int find(int[] lines, int[] dp, int idx) {
        int maxCount = 1;
        for(int i=idx+1; i<lines.length; i++) {
            if(lines[idx] <= lines[i]) maxCount = Math.max(dp[i]+1, maxCount);
        }

        return maxCount;
    }
}