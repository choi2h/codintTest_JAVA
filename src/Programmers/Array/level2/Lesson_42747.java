package Programmers.Array.level2;

import java.util.Arrays;

public class Lesson_42747 {
    public int solution(int[] citations) {
        Arrays.sort(citations);

        int answer = 0;
        for(int i = 0; i<citations.length; i++) {
            if(citations.length-i <= citations[i]) {
                answer = citations.length-i;
                break;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Lesson_42747 obj = new Lesson_42747();
        System.out.println(obj.solution(new int[]{3, 0, 6, 1, 5, 5, 9, 8, 12, 9, 10}));
        System.out.println(obj.solution(new int[]{0, 1, 1, 2, 2}));
    }
}