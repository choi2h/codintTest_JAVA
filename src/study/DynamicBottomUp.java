package study;

import java.util.Scanner;

public class DynamicBottomUp {
    static int[] DP;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        DP = new int[n+1];

        for(int i=0; i<=n; i++) {
            DP[i]=-1;
        }
        DP[0] = 0;
        DP[1] = 1;
        /*
        반복문을 사용하며
        아래값부터 미리 계산을 해놓고 해당 값들을 이용하여 위에값들을 구해가는 방식
         */
        for(int i=2; i<=n; i++) {
            DP[i] = DP[i-1] + DP[i-2];
        }

        System.out.println(DP[n]);
    }
}
