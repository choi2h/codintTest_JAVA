package Programmers.basic;

import java.util.Arrays;

public class Lesson_12953 {
    public int solution(int[] arr) {
        int answer = arr[0];
        for(int i=1; i<arr.length; i++) {
            // LCM(Least Common Multiple)
            // 두 수를 곱한 값에 최대공약수를 나누어주면 최소공배수가 나온다.
            answer = (answer*arr[i])/gcd(answer, arr[i]);
        }

        return answer;
    }

    // GCD(Greatest Common Divisor) : 최대공약수
    // 유클리드 호제법 : 최대공약수를 구하는 알고리즘으로
    // a를 b로 나눈 나머지가 0이 될 때까지 나누면 해당 나머지는 최대공약수가 된다.
    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }

        return a;
    }

    public static void main(String[] args) {
        int[] arr = {2,6,8,14};
        int[] arr2 = {1,2,3};

        Lesson_12953 lesson = new Lesson_12953();
        System.out.println(lesson.solution(arr));
        System.out.println(lesson.solution(arr2));
    }
}
