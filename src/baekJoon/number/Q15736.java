package baekJoon.number;

import java.util.Scanner;

// 청기백기
// https://www.acmicpc.net/problem/15736
public class Q15736 {

    // 제곱수를 구하는 문제
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int count = 0;
        for(int i=1; i<=n; i++) {
            // 1부터 제곱수 구함
            // 제곱수가 최대값 n보다 크면 범위 초과로 중단
            if(Math.pow(i, 2) > n) {
                break;
            }

            // 제곱수가 범위 안에 포함되면 백기로 판단하여 count 추가
            count++;
        }

        System.out.println(count);
    }
}
