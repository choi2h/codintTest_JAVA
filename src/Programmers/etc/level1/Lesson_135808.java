package Programmers.etc.level1;

import java.util.Arrays;

/*
사과장수
URL : https://school.programmers.co.kr/learn/courses/30/lessons/135808
 */
public class Lesson_135808 {

    /*
    * k : 사과의 최대 점수
    * m : 한 상자에 들어가는 사과의 수
    * score : 사과들의 점수수
    */
    public int solution(int k, int m, int[] score) {
        int answer = 0;

        // score를 오름차순 정렬
        Arrays.sort(score);
        // 가장 끝에서부터 m개씩 빼면
        // 한 사과박스의 가장 낮은 사과점수가 나옴
        for(int i=score.length-m; i>=0; i -= m) {
            // 가장 낮은 사과 점수 * 한 박스의 사과 개수를 answer에 합해줌
            answer += score[i] * m;
        }

        return answer;
    }


    public static void main(String[] args) {
        Lesson_135808 lesson = new Lesson_135808();

        int k = 4;
        int m = 3;
        int[] score = {4, 1, 2, 2, 4, 4, 4, 4, 1, 2, 4, 2};

        int result = lesson.solution(k, m, score);
        System.out.println(result);
    }
}
