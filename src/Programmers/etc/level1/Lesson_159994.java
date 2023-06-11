package Programmers.etc.level1;

/*
카드 뭉치
URL : https://school.programmers.co.kr/learn/courses/30/lessons/159994
 */
public class Lesson_159994 {

    public String solution(String[] cards1, String[] cards2, String[] goal) {
        String answer = "Yes";

        // cards1을 조회할 인덱스
        int indexForCards1 = 0;
        // cards2를 조회할 인덱스
        int indexForCards2 = 0;

        // 만들고자하는 문자 리스트 순차 순회
        for(String s : goal) {
            // 카드1 리스트 맨 앞순서에 해당 문자가 있는지 확인
            if(indexForCards1 < cards1.length && cards1[indexForCards1].equals(s)) {
                // 카드1 다음 인덱스로 이동
                indexForCards1++;
            }
            // 카드2 리스트 맨 앞순서에 해당 문자가 있는지 확인
            else if(indexForCards2 < cards2.length && cards2[indexForCards2].equals(s)) {
                // 카드2 다음 인덱스로 이동
                indexForCards2++;
            }
            // 카드1에도 카드2에도 현 순서에 해당 문자가 없으면 문장 완성 불가 판단
            else {
                // No 응답
                answer = "No";
                break;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Lesson_159994 lesson = new Lesson_159994();

        String[] cards1 = {"i", "water", "drink"};
        String[] cards2 = {"want", "to"};
        String[] goals = {"i", "want", "to", "drink", "water"};
        String result = lesson.solution(cards1, cards2, goals);

        System.out.println(result);
    }
}
