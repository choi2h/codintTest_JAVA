package baekJoon.number;

import java.util.Scanner;

public class Q1407 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long s = sc.nextLong();
        long e = sc.nextInt();

        int answer = 0;
        for(long i=s; i<=e; i++) {
            if(i%2 != 0) {
                answer += 1;
                continue;
            }

            int p = 0;
            long o = 0;
            long n = (long) Math.pow(2, ++p);
            while(n <= i && i%n == 0) {
                o = n;
                n = (long) Math.pow(2, ++p);
            }

            answer += o;
        }

        System.out.println(answer);
    }
}
