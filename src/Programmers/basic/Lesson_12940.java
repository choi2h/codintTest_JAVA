package Programmers.basic;

public class Lesson_12940 {
    public int[] solution(int n, int m) {
        int gcd = getGCD(n, m);
        int lcm = getLCM(n, m, gcd);
        return new int[]{gcd, lcm};
    }

    private int getLCM(int a, int b, int gcd) {
        return a*b/gcd;
    }

    private int getGCD(int a, int b) {
        while(b > 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }

        return a;
    }
}
