import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private static final long MOD = 1_000_000_000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int bitRange = 1 << 10;
        long[][][] dp = new long[n+1][10][bitRange];
        for (int i=1; i<10; i++) {
            int cur = 1<<i;
            dp[1][i][cur] = 1;
        }

        for (int i=2; i<=n; i++) {
            for (int j=0; j<10; j++) {
                for (int k=0; k<bitRange; k++) {
                    long sum;
                    if (j==0) {
                        sum = dp[i-1][j+1][k];
                    } else if (j==9) {
                        sum = dp[i-1][j-1][k];
                    } else {
                        sum = dp[i-1][j-1][k] + dp[i-1][j+1][k];
                    }

                    int cur = k | 1<<j;
                    dp[i][j][cur] += sum%MOD;
                }
            }
        }

        long result = 0;
        int findBit = bitRange-1;
        for (int i=0; i<10; i++) {
            result += dp[n][i][findBit];
        }


        System.out.println(result%MOD);
    }
}