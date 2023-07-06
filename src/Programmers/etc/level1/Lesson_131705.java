package Programmers.etc.level1;

/*
삼총사
URL : https://school.programmers.co.kr/learn/courses/30/lessons/131705
 */
public class Lesson_131705 {
    public int solution(int[] number) {
        int answer = 0;

        // 뒤에서 3번째 학생까지만 검사 (삼총사라 마지막 뒤는 이미 앞에서 다 검사됨)
        for(int i=0; i<number.length-2; i++) {
            // 결과로 받은 삼총사 가능 횟수를 answer에 누적
            answer += checkTriple(number, 1, i, 0);
        }

        return answer;
    }

    // number : 학생 정수 리스트
    // order : 현재 삼총사 중 몇번째 학생인지 => 3일경우 삼총사 최대 인원이 가득 찼으므로 더 이상 검사하지 않는다.
    // index : 현재 학생의 위치
    // sum : 이전 학생들의 정수 합
    private int checkTriple(int[] number, int order, int index, int sum) {
        // 세번째 학생일 경우 정수를 더하여 0이 되는지 확인
        if(order == 3) {
            // 0이 되면 가능하다고 1응답 안되면 0응답
            return sum + number[index] == 0 ? 1 : 0;
        }

        int count = 0;
        // 현재 index학생 이후의 학생들을 대상으로 모든 경우의 수 검사
        for(int i=index+1; i<number.length; i++) {
            //응답 받은 숫자를 가능 횟수에 누적
            count += checkTriple(number, order+1, i, sum+number[index]);
        }

        // 누적된 가능 횟수 응답
        return count;
    }

    public static void main(String[] args) {
        Lesson_131705 lesson = new Lesson_131705();
//        int[] number = {-2, 3, 0, 2, -5};
        int[] number = {-3, -2, -1, 0, 1, 2, 3};
        int result = lesson.solution(number);
        System.out.println(result);
    }
}
