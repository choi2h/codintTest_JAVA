package Programmers.queue;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

public class Lesson_12927 {
    public long solution(int n, int[] works) {
        Queue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        for( int i : works) {
            queue.add(i);
        }

        while(!queue.isEmpty() && n > 0) {
            n--;
            int num = queue.remove()-1;
            if(num > 0) queue.add(num);
        }


        long answer = 0;
        while (!queue.isEmpty()) {
            answer += (long) Math.pow(queue.remove(), 2);
        }
        return answer;
    }

    public static void main(String[] args) {
        Lesson_12927 lesson = new Lesson_12927();
//        System.out.println(lesson.solution(4, new int[]{4, 3, 3}));
//        System.out.println(lesson.solution(1, new int[]{2, 1, 2}));
//        System.out.println(lesson.solution(3, new int[]{1, 1}));
        System.out.println(lesson.solution(10, new int[]{10, 10, 1}));
    }
}
