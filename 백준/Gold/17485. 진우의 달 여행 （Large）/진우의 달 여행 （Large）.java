import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] input1 = reader.readLine().split(" ");
        int x = Integer.parseInt(input1[0]);
        int y = Integer.parseInt(input1[1]);

        int[][] arr = new int[x][y];
        for(int i=0; i<x; i++) {
            String[] input2 = reader.readLine().split(" ");
            for(int j=0; j<y; j++) {
                arr[i][j] = Integer.parseInt(input2[j]);
            }
        }

        // 0 - 왼쪽 아래 이동, 1 - 수직 이동, 2- 오른쪽 아래 이동
        int[][][] dp = new int[x][y][3];
        for(int i=0; i<arr[0].length; i++) {
            dp[0][i][0] = arr[0][i];
            dp[0][i][1] = arr[0][i];
            dp[0][i][2] = arr[0][i];
        }

        for(int i=1; i<x; i++) {
            for(int j=0; j<y; j++) {
                dp[i][j][0] = j+1 < y ? getMin(dp[i-1][j+1][1], dp[i-1][j+1][2])+arr[i][j] : 0;
                dp[i][j][1] = getMin(dp[i-1][j][0], dp[i-1][j][2])+arr[i][j];
                dp[i][j][2] = j-1 >= 0 ? getMin(dp[i-1][j-1][0], dp[i-1][j-1][1])+arr[i][j] : 0;
            }
        }

        int result = Integer.MAX_VALUE;
        for(int i=0; i<y; i++) {
            result = dp[x-1][i][0] > 0 ? Math.min(dp[x-1][i][0], result) : result;
            result = dp[x-1][i][1] > 0 ? Math.min(dp[x-1][i][1], result) : result;
            result = dp[x-1][i][2] > 0 ? Math.min(dp[x-1][i][2], result) : result;
        }

        System.out.println(result);
    }

    private static int getMin(int a, int b) {
        if(a == 0) return b;
        if(b == 0) return a;

        return Math.min(a,b);
    }
}