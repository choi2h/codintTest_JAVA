import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] str1 = br.readLine().toCharArray();
        char[] str2 = br.readLine().toCharArray();

        int size1 = str1.length+1;
        int size2 = str2.length+1;
        int[][] dp = new int[size1][size2];
        for (int i=1; i<size1; i++) {
            char cur = str1[i-1];
            for(int j=1; j<size2; j++) {
                int match = cur == str2[j-1] ? 1 : 0;
                dp[i][j] = Integer.max(dp[i-1][j-1] + match, dp[i-1][j]);
                dp[i][j] = Integer.max(dp[i][j], dp[i][j-1]);
            }
        }

        int max = 0;
        for (int i=1; i<size2; i++) {
            max = Math.max(dp[size1-1][i], max);
        }

        System.out.println(max);
    }
}