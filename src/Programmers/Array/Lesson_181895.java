package Programmers.Array;

import java.util.Arrays;

public class Lesson_181895 {
    public int[] solution(int[] arr, int[][] intervals) {
        int count = 0;
        for (int[] interval : intervals) {
            count += interval[1] - interval[0]+1;
        }

        int[] answer = new int[count];
        int index = 0;
        for (int[] interval : intervals) {
            for(int i = interval[0]; i <= interval[1]; i++) {
                answer[index++] = arr[i];
            }
        }

        return answer;
    }
}
