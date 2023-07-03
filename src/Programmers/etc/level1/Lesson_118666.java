package Programmers.etc.level1;

import java.util.HashMap;
import java.util.Map;

/*
성격유형 검사하기
URL : https://school.programmers.co.kr/learn/courses/30/lessons/118666
 */
public class Lesson_118666 {
    /*
       0 : 라이언형(R), 튜브형(T)
       1 : 콘형(C), 프로도형(F)
       2 : 제이지형(J), 무지형(M)
       3 : 어피치형(A), 네오형(N)
    */
    public String solution(String[] survey, int[] choices) {
        Map<Character, Integer> scoreMap = new HashMap<>();

        for(int i =0; i<survey.length; i++) {
            // 두가지 지표를 배열로 변환
            char[] array = survey[i].toCharArray();
            // 위 지표에 대해 선택한 답안 받아옴
            int choice = choices[i];

            // 모르겠음을 선택했을 경우 아무 유형에도 점수가 올라가지 않음
            if(choice == 4) {
                continue;
            }

            // 비동의(1~3) 선택 시 앞에 유형에 점수 추가
            char c = array[0];
            if (choice > 4) {
                // 동의(5~7) 선택 시 뒤에 유형에 점수 추가
                c = array[1];
            }

            // 1~7까지 선택에 따른 점수 조회
            int score = getScore(choice);
            // map에 해당 유형의 점수 가져옴
            int preScore = scoreMap.getOrDefault(c, 0);
            // 위에서 가져온 점수(preScore)에 이번 선택답안(score) 더해서 map에 추가 혹은 덮어씀
            scoreMap.put(c, preScore+score);
        }

        // 맵에 담아놓은 유형별 점수에 따라 성격유형을 가져옴
        return getType(scoreMap);
    }

    private String getType(Map<Character, Integer> scoreMap) {
        // 둘 중 큰 점수의 유형을 가져옴
        // 점수가 같을 경우 알파벳 순서가 더 앞에 순서인 것을 가져옴
        return String.valueOf(getLargeScoreCharacter(scoreMap, 'R', 'T')) +
                getLargeScoreCharacter(scoreMap, 'C', 'F') +
                getLargeScoreCharacter(scoreMap, 'J', 'M') +
                getLargeScoreCharacter(scoreMap, 'A', 'N');
    }

    private char getLargeScoreCharacter(Map<Character, Integer> scoreMap, char a, char b) {
        int aScore = scoreMap.getOrDefault(a, 0);
        int bScore = scoreMap.getOrDefault(b, 0);

        if(aScore == bScore) {
            return a < b ? a : b;
        }

        return aScore > bScore ? a : b;
    }

    private int getScore(int choice) {
        int score;

        switch (choice) {
            case 1 :
            case 7 :
                score = 3;
                break;
            case 2 :
            case 6 :
                score = 2;
                break;
            case 3 :
            case 5 :
                score = 1;
                break;
            default :
                score = 0;
        };

        return score;
    }

    public static void main(String[] args) {
        Lesson_118666 lesson = new Lesson_118666();

//        String[] survey = {"AN", "CF", "MJ", "RT", "NA"};
//        String[] survey = {"AN", "CF", "MJ", "RT", "NA", "TR", "RT", "TR"};
//        String[] survey = {"TR", "RT", "TR"};
        String[] survey = {"RT", "RT"};
//        int[] choices = {5, 3, 2, 7, 5};
//        int[] choices = {5, 3, 2, 7, 5, 7, 1, 3};
//        int[] choices = {7, 1, 3};
//        int[] choices = {7, 5, 2};
        int[] choices = {7, 4};

        String result = lesson.solution(survey, choices);
        System.out.println(result);
    }
}
