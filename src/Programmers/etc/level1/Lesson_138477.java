package Programmers.etc.level1;

import java.util.Arrays;
import java.util.Collections;

/*
명예의 전당 (1)
URL : https://school.programmers.co.kr/learn/courses/30/lessons/138477
 */
public class Lesson_138477 {

    public int[] solution(int k, int[] score) {
        int[] answer = new int[score.length];


        for(int i=0; i<score.length; i++) {
            Integer[] arr = new Integer[i+1];
            for(int j=0; j<i+1; j++) {
                arr[j] = score[j];
            }

            Arrays.sort(arr, Collections.reverseOrder());

            int lowScore;
            if(arr.length > k) {
                lowScore = arr[k-1];
            } else {
                lowScore = arr[arr.length-1];
            }

            answer[i] = lowScore;
        }

        return answer;
    }

    public static void main(String[] args) {
        Lesson_138477 lesson = new Lesson_138477();

        int[] score = {0, 300, 40, 300, 20, 70, 150, 50, 500, 1000};
        int[] result = lesson.solution(4, score);
        for(int i : result) {
            System.out.println(i);
        }
    }
}
