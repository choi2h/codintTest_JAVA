package baekJoon.sum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q11660 {
    /*
        D - 구간합 배열 / A - 기존 배열
        D[i][j] = D[i][j-1] + D[i-1][j] - D[i-1][j-1] + A[i][j];
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 표의 크기 N과 합을 구해야 하는 횟수 M
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] sumNumbers = new int[n+1][n+1];
        for(int i=1; i<=n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<=n; j++) {
                sumNumbers[i][j] = sumNumbers[i][j-1] + sumNumbers[i-1][j] - sumNumbers[i-1][j-1] + Integer.parseInt(st.nextToken());
            }
        }

        for(int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());

            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            System.out.println(sumNumbers[x2][y2] - sumNumbers[x1-1][y2] - sumNumbers[x2][y1-1] + sumNumbers[x1-1][y1-1]);
        }
    }
}

