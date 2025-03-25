package Programmers.search.binary;

import java.util.Arrays;

public class Lesson_43238 {
    public long solution(int n, int[] times) {
        long answer = 0;
        Arrays.sort(times);

        long s = 1;
        long e = (long) times[times.length - 1] * n;
        while (s<=e) {
            long mid = (s+e)/2;
            long count = 0;
            for(int t : times) {
                count += mid/t;
            }

            if(count < n) {
                s = mid+1;
            } else {
                answer = mid;
                e = mid-1;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Lesson_43238 lesson = new Lesson_43238();
//        System.out.println(lesson.solution(6, new int[]{7,10}));
        System.out.println(lesson.solution(10, new int[]{6, 8,10}));
//        System.out.println(lesson.solution(59, new int[]{1, 1}));
    }
}