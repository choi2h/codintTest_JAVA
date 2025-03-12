package Programmers.search.basic.level1;

import java.util.Arrays;

public class Lesson_12954 {

    public long[] solution(int x, int n) {
        long[] answer = new long[n];

        answer[0] = x;
        for(int i=1; i<n; i++) {
            answer[i] = answer[i-1] + x;
        }

        return answer;
    }

    public static void main(String[] args) {
        Lesson_12954 lesson = new Lesson_12954();
        System.out.println(Arrays.toString(lesson.solution(2, 5)));
        System.out.println(Arrays.toString(lesson.solution(4, 3)));
        System.out.println(Arrays.toString(lesson.solution(-4, 2)));
    }
}
