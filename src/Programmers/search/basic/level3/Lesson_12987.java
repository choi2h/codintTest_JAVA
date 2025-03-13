package Programmers.search.basic.level3;

import java.util.Arrays;

public class Lesson_12987 {
    public int solution(int[] A, int[] B) {
        int answer = 0;

        Arrays.sort(A);
        Arrays.sort(B);
        int a = A.length-1, be = B.length-1;
        int bs = 0;
        while(a >= 0 && bs <= be) {
            if(A[a] < B[be]) {
                be--;
                answer++;
            } else {
                bs++;
            }

            a--;
        }

        return answer;
    }

    public static void main(String[] args) {
        Lesson_12987 lesson = new Lesson_12987();

        int result = lesson.solution(new int[]{5,1,3,7}, new int[]{2,2,6,8});
        System.out.println(result);
    }
}
