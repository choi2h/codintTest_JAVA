import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private int solution(int[][] arr) {
        int[][] dp = new int[arr.length][arr[0].length];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                dp[i][j] = arr[i][j];

                if(i > 0) dp[i][j] += getMin(dp[i-1], j);
            }
        }

        return getMin(dp[arr.length-1], -1);
    }

    private int getMin(int[] arr, int excludeIndex) {
        int min = Integer.MAX_VALUE;
        for(int i=0; i<arr.length; i++) {
            if(i != excludeIndex) min = Math.min(min, arr[i]);
        }
        return min;
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[][] arr = new int[n][3];
        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
            arr[i][2] = Integer.parseInt(st.nextToken());
        }

        System.out.println(main.solution(arr));
    }
}