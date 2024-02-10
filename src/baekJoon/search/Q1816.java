package baekJoon.search;

import java.util.Scanner;

/*
암호키
https://www.acmicpc.net/problem/1816
 */
public class Q1816 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());

        for(int i=0; i<n; i++) {
            long number = Long.parseLong(sc.nextLine());

            for(int j=2; j<=1000000; j++) {
                if(number%j == 0) {
                    System.out.println("NO");
                    break;
                }

                if(j == 1000000) {
                    System.out.println("YES");
                }
            }
        }
    }
}
