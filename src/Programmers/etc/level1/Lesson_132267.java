package Programmers.etc.level1;

/*
콜라 문제
URL : https://school.programmers.co.kr/learn/courses/30/lessons/132267
 */
public class Lesson_132267 {

    public int solution(int a, int b, int n) {
        int answer = 0;

        // 가지고 있는 콜라가 반납 가능한 콜라의 개수보다 많으면 수행
        while(n >= a) {
            // 콜라 빈명 묶음 개수
            int groupCount = n/a;
            // 해당 묶음만큼 마트에 가져다 주었을 때 받는 새로운 콜라 개수
            int count = b*groupCount;
            // 받은 콜라 개수 누적
            answer += count;

            // 묶음에 포함이 안되어 남은 콜라(n%a)
            // 새로 받은 콜라
            // 두 개수를 합하면 가지고 있는 콜라 개수가 초기화 됨
            n = count + n%a;
        }

        return answer;
    }

    public static void main(String[] args) {
        Lesson_132267 lesson = new Lesson_132267();
        int result = lesson.solution(3, 1, 20);
        System.out.println(result);
    }
}
