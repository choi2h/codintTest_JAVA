package study;

import java.util.Scanner;

public class DynamicTopDown {

    static int[] DP;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        DP = new int[n+1];
        for(int i=0; i<=n; i++) {
            DP[i] = -1;
        }

        DP[0] = 0;
        DP[1] = 1;
        fibo(n);

        System.out.println(DP[n]);
    }

    /*
        재귀방식을 이용한 방식으로
        위에 값부터 시작하며 아래 값을 구해와서 계산하는 방식
     */
    static int fibo(int n) {
        if(DP[n] != -1) {
            return DP[n];
        }

        return DP[n] = fibo(n-1) + fibo(n-2);
    }
}
