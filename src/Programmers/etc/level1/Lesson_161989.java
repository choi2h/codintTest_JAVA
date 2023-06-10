package Programmers.etc.level1;

/*
덧칠하기
URL : https://school.programmers.co.kr/learn/courses/30/lessons/161989
 */
public class Lesson_161989 {
    public int solution(int n, int m, int[] section) {
        int answer = 0;

        // 현재 페인트를 칠한 위치
        int cur = 0;
        // 페인트를 칠해야할 섹션
        for(int i : section) {
            // 현재 페인트를 칠한 위치보다 뒤에 있으면 거기(i)서부터 다시 페인트 칠함
            if(cur < i) {
                // 페인트 칠함 횟수 증가
                answer++;
                // i의 위치부터 m의 길이만큼 칠하고 난 위치를 cur에 저장
                cur = i + m-1;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Lesson_161989 lesson = new Lesson_161989();

        int n = 4;
        int m = 1;
        int[] section = {1, 2, 3, 4};
        int result = lesson.solution(n, m, section);

        System.out.println(result);
    }
}
