package Programmers.greedy.level1;

import java.util.Arrays;

public class Lesson_42862_1 {

    private static final int RESERVE = 1;
    private static final int NONE = 0;
    private static final int LOST = -1;

    public int solution(int n, int[] lost, int[] reserve) {
        int answer = n-lost.length;
        int[] statusArr = new int[n+1];
        for(int i : reserve) {
            statusArr[i] = RESERVE;
        }

        for(int i : lost) {
            if(statusArr[i] == RESERVE) {
                statusArr[i] = NONE;
                answer++;
            } else statusArr[i] = LOST;

        }

        Arrays.sort(lost);
        for(int i : lost) {
            if(statusArr[i] == NONE) continue;
            if(i > 1 && statusArr[i-1] == RESERVE) {
                statusArr[i-1] = NONE;
                answer++;
            } else if(i<statusArr.length-1 && statusArr[i+1] == RESERVE) {
                statusArr[i+1] = NONE;
                answer++;
            }
        }

        return answer;
    }

    /**
     * n	lost	reserve	return
     * 5	[2, 4]	[1, 3, 5]	5
     * 5	[2, 4]	[3]	4
     * 3	[3]	[1]	2
     */

    public static void main(String[] args) {
        Lesson_42862_1 lesson = new Lesson_42862_1();
        int n = 5;
        int[] lost = {2, 3};
        int[] reserve = {3, 4};

        int result = lesson.solution(n, lost, reserve);
        System.out.println("result = " + result);
    }
}
