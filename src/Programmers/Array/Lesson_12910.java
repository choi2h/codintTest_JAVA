package Programmers.Array;

import java.util.Arrays;

public class Lesson_12910 {

    public int[] solution(int[] arr, int divisor) {
        int[] answer = new int[arr.length];

        int index = 0;
        for(int i : arr) {
            if(i%divisor == 0) answer[index++] = i;
        }

        if(index == 0) {
            return new int[]{-1};
        }

        answer = Arrays.copyOfRange(answer, 0, index);
        Arrays.sort(answer);
        return answer;
    }

    public static void main(String[] args) {
        Lesson_12910 obj = new Lesson_12910();
        int[] arr = {5, 9, 7, 10};
        int[] result = obj.solution(arr, 5);
        System.out.println(Arrays.toString(result));
    }
}
