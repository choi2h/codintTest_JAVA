package Programmers.search.basic.level3;

import java.util.Arrays;

public class Lesson_12938 {

    public int[] solution(int n, int s) {
        if(s < n) return new int[]{-1};

        int[] result = new int[n];

        int common = s/n;
        int idle = s%n;
        for(int i=n-1; i>=0; i--) {
            if(idle > 0) {
                result[i] = common+1;
                idle--;
            } else {
                result[i] =common;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Lesson_12938 lesson = new Lesson_12938();
        int[] result = lesson.solution(2, 9);
//        int[] result = lesson.solution(2, 8);
//        int[] result = lesson.solution(2, 1);
        System.out.println(Arrays.toString(result));
    }
}
