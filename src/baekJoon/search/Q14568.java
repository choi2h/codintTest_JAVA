package baekJoon.search;

import java.util.Scanner;
/*
2017 연세대학교 프로그래밍 경시대회
https://www.acmicpc.net/problem/14568
 */
public class Q14568 {

    /*
        1. 남는 사탕이 없어야 합니다.
        2. A는 B보다 2개 '이상' 많은 사탕을 가져야 합니다.
        3. 셋 중 사탕을 하나도 못 받는 친구는 없어야 합니다.
        4. C가 받는 사탕의 수는 짝수입니다.
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 사탕의 개수 n
        int n = sc.nextInt();

        // 경우의 수를 저장하는 변수 answer
        int answer = 0;

       for(int a=0; a<=n; a++) {
           for(int b=0; b<=n; b++) {
               for(int c=0; c<=n; c++) {
                   if(a+b+c == n) {
                       if(a!=0 && b!=0 && c!=0) {
                           if(a >= b+2) {
                               if(c%2 == 0) {
                                   answer++;
                               }
                           }
                       }
                   }
               }
           }
        }

        System.out.println(answer);
    }
}
