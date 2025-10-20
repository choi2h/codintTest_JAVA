import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private static int[][] dp = new int[41][2];
    private static boolean[] visited = new boolean[41];

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        dp[0][0] = 1;
        dp[0][1] = 0;
        dp[1][0] = 0;
        dp[1][1] = 1; 
        visited[0] = true;
        visited[1] = true;

        StringBuilder sb = new StringBuilder();
        while(t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            if(!visited[n]) fibonacci(n);
            sb.append(dp[n][0]).append(" ").append(dp[n][1]).append("\n");
        }

        System.out.print(sb);
    }

    private static void fibonacci(int n) {
        if (!visited[n-1]) fibonacci(n-1);
        if (!visited[n-2]) fibonacci(n-2);

        dp[n][0] = dp[n-1][0] + dp[n-2][0];
        dp[n][1] = dp[n-1][1] + dp[n-2][1];
        visited[n] = true;
    }   
}