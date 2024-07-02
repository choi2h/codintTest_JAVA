package baekJoon.dynamic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Q11570 {

    private static int[][] visitDp;

    public static int solution(int[] arr) {
        visitDp = new int[arr.length+1][arr.length+1];
        for (int[] ints : visitDp) {
            Arrays.fill(ints, -1);
        }
        return sum(arr, 0, -1, -1);
    }


    public static int sum(int[] arr, int i, int a, int b) {
        if(i >= arr.length) {
            return 0;
        }

        if(visitDp[a+1][b+1] > -1) {
            return visitDp[a+1][b+1];
        }

        // 모든 인덱스 방문
        int aScore = (a==-1? 0 : Math.abs(arr[i]-arr[a])) + sum(arr, i+1, i, b);
        int bScore = (b==-1? 0 : Math.abs(arr[i]-arr[b])) + sum(arr, i+1, a, i);

        return visitDp[a+1][b+1] = Math.min(aScore, bScore);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        String[] inputArr = br.readLine().split(" ");
        for(int i=0; i<arr.length; i++) {
            arr[i] = Integer.parseInt(inputArr[i]);
        }

        int result = solution(arr);
        System.out.println(result);
    }
}

/*
 public static int solution(int[] arr) {
        visitDp = new int[arr.length+1][arr.length+1];
        int[][] dp = new int[arr.length+1][arr.length+1];
        for(int i=1; i<=arr.length; i++) {
            for(int j=1; j<i; j++) {
                dp[i][j] = Math.abs(arr[i-1]-arr[j-1]);
            }
            System.out.println(Arrays.toString(dp[i]));
        }



        return sum(dp, 1, 0, 0);
    }


    public static int sum(int[][] dp, int i, int a, int b) {
        System.out.println("dp.length=" + dp.length + ", i=" + i);
        if(i >= dp.length) {
            return 0;
        }

        if(visitDp[a][b] > 0) {
            return visitDp[a][b];
        }

        // 모든 인덱스 방문
        int aScore = dp[i][a] + sum(dp, i+1, i, b);
        int bScore = dp[i][b] + sum(dp, i+1, a, i);

        System.out.println("a=" + a + ", b="  + b + ", aScore=" + aScore + ", bScore=" + bScore);

        return visitDp[a][b] = Math.min(aScore, bScore);
    }
 */