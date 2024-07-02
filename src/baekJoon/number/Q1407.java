package baekJoon.number;

import java.util.Scanner;

public class Q1407 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long s = sc.nextLong();
        long e = sc.nextLong();

        long result = find(e, 0) - find(s-1, 0);

        System.out.println(result);
    }

    static long find(long n, int p) {
        if(n<=0) {
            return 0L;
        }

        long count = n%2==0 ? n/2 : (n/2)+1;
        return (long)(count*Math.pow(2, p)) + find(n-count, ++p);
    }
}
