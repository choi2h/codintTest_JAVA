package Programmers.etc.level1;

/*
나머지가 1이 되는 수 찾기
URL : https://school.programmers.co.kr/learn/courses/30/lessons/87389
 */
public class Lesson_87389 {

    public int solution(int n) {
        int answer = 2;

        while(n%answer != 1) {
            answer++;
        }

        return answer;
    }

    public static void main(String[] args) {
        Lesson_87389 lesson = new Lesson_87389();
        int result = lesson.solution(12);
        System.out.println(result);
    }
}
