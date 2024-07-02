package baekJoon.dynamic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q12865 {

    static int solution(int n, int maxWeight, int[][] stuffs) {
        // [n번째 물건이 들어갈 때] [무게별] = 최대 가치를 넣음
        int[][] dp = new int[n + 1][maxWeight + 1];

        for (int k = 1; k <= maxWeight; k++) { // 무게
            for (int i = 1; i <= n; i++) { // stuffs
                // 이전 물건까지의 최대 가치 저장
                dp[i][k] = dp[i - 1][k];
                // 무게 w에서 지금 물건(i번째 item)을 넣을 수 있다면
                // 즉, 무게가 지금 물건의 무게보다 크다면
                if (k >= stuffs[i][0]) {
                    // 짐을 더 넣을 수 있는지를 확인해서 합한 값이 더 가치가 크다면 갱신
                    // 이전 물건까지의 현재 무게 최대 가치보다
                    // 현재 물건을 넣었을 때의 가치가 더 클 경우 값을 갱신해준다.
                    dp[i][k] = Math.max(dp[i - 1][k], stuffs[i][1] + dp[i - 1][k - stuffs[i][0]]);
                }
            }
        }

        // 최대 가치를 반환
        return dp[n][maxWeight];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] values = bf.readLine().split(" ");
        int n = Integer.parseInt(values[0]);
        int maxWeight = Integer.parseInt(values[1]);

        int[][] stuffs = new int[n+1][2];
        for(int i=1; i<=n; i++) {
            String[] line = bf.readLine().split(" ");
            stuffs[i][0] = Integer.parseInt(line[0]);
            stuffs[i][1] = Integer.parseInt(line[1]);
        }

        int result = solution(n, maxWeight, stuffs);
        System.out.println(result);
    }
}
