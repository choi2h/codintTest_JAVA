package Programmers.dfsbfs;

import java.util.LinkedList;
import java.util.Queue;

public class Lesson_154538 {

    public int solution(int x, int y, int n) {
        int[] dp = new int[y+1];

        if(x == y) {
            return 0;
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(x);

        while (!queue.isEmpty()) {
            int cur = queue.poll();

            int[] nextNumber = {cur*3, cur*2, cur+n};
            for(int num : nextNumber) {
                if(num > y || (dp[num] > 0 && dp[num] <= dp[cur]+1)) {
                    continue;
                }

                dp[num] = dp[cur]+1;

                if(num < y) {
                    queue.offer(num);
                }
            }
        }

        return dp[y] == 0 ? -1 : dp[y];
    }

    /*
    10	40	5	2
    10	40	30	1
    2	5	4	-1
     */
    public static void main(String[] args) {
        Lesson_154538 lesson = new Lesson_154538();
        System.out.println(lesson.solution(10, 40, 5));
        System.out.println(lesson.solution(1000, 1000000, 5));
        System.out.println(lesson.solution(10, 40, 30));
        System.out.println(lesson.solution(2, 5, 4));
    }
}
