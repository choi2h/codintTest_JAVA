package Programmers.etc.level1;

import java.util.Arrays;

/*
없는 숫자 더하기
URL : https://school.programmers.co.kr/learn/courses/30/lessons/86051
 */
public class Lesson_86051 {

    public int solution(int[] numbers) {
        int answer=0;

        Arrays.sort(numbers);
        int index = 0;
        for(int i=0; i<10; i++) {
            if(index < numbers.length && numbers[index] == i) {
                index++;
            } else {
                answer += i;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Lesson_86051 lesson = new Lesson_86051();

//        int[] numbers = {1,2,3,4,6,7,8,0};
        int[] numbers = {5,8,4,0,6,7,9};
        int result = lesson.solution(numbers);
        System.out.println(result);
    }

    /*
    충격적인 다른 사람 풀이,, 이렇게 간단한 방법이,,!!
    public int solution(int[] numbers) {
        int sum = 45;
        for (int i : numbers) {
            sum -= i;
        }
        return sum;
    }
     */
}
