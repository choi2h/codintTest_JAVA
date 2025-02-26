package Programmers;

import java.util.Arrays;

public class Lesson_12941 {
    public int solution(int[] A, int[] B)
    {
        int answer = 0;

        Arrays.sort(A);
        Arrays.sort(B);

        for(int i=0; i<A.length; i++) {
            answer += A[i] * B[B.length-1-i];
        }

        return answer;
    }

    public static void main(String[] args) {
        Lesson_12941 solution = new Lesson_12941();

//        int result = solution.solution(new int[]{1, 2},  new int[]{3,4});
        int result = solution.solution(new int[]{1, 4, 2}, new int[]{5, 4, 4});
        System.out.println(result);
    }
}
