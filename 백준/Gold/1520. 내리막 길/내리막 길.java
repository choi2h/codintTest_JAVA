import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer input = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(input.nextToken());
        int n = Integer.parseInt(input.nextToken());
        int[][] arr = new int[m][n];
        int[][] dp = new int[m][n];

        for(int i = 0; i < m; i++) {
            input = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++) {
                arr[i][j] = Integer.parseInt(input.nextToken());
                dp[i][j] = -1;
            }
        }

        dp[m-1][n-1] = 1;
        int[][] movePoints = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        dfs(arr, 0, 0, movePoints, dp);


        System.out.println(dp[0][0]);
    }

    private static int dfs(int[][] arr, int x, int y, int[][] movePoints, int[][] dp) {
        if(x >= arr.length && y >= arr[0].length) return 0;

        int count = 0;
        for(int[] move: movePoints) {
            int mx = x + move[0], my = y + move[1];

            if(mx < 0 || mx >= arr.length
                    || my<0 || my >= arr[0].length
                    || arr[mx][my] >= arr[x][y]) continue;

            if(dp[mx][my] == -1) dfs(arr, mx, my, movePoints, dp);
            count += dp[mx][my];
        }

        return dp[x][y] = count;
    }
}
