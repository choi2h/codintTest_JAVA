package baekJoon.number;

import java.util.Scanner;
// 소인수분해
// https://www.acmicpc.net/problem/11653
public class Q11653 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        StringBuilder sb = new StringBuilder();
        for(int i=2; i<=Math.sqrt(n); i++) {
            while(n%i == 0) {
                n = n/i;
                sb.append(i).append("\n");
            }
        }

        if(n!=1) {
            sb.append(n);
        }
        System.out.println(sb);
    }
}
