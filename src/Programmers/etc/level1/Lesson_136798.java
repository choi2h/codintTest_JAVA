package Programmers.etc.level1;

import java.util.ArrayList;
import java.util.List;

public class Lesson_136798 {

    public int solution(int number, int limit, int power) {
        int answer = 1;

        for(int i=2; i<=number; i++) {
            int count = getCount(i);
            answer += count>limit ? power : count;
        }



        return answer;
    }

    private int getCount(int number) {
        // Math.sqrt() 제곱근 계산
        double sqr = Math.sqrt(number);

        int count = 0;
        for(int i=1; i<sqr; i++) {
            if(number % i == 0) {
                count+=2;
            }
        }

        if(sqr % 1 == 0.0) {
            count++;
        }

        return count;
    }

    public static void main(String[] args) {
        Lesson_136798 lesson = new Lesson_136798();
        int number = 21;
        int limit = 3;
        int power = 2;

        int result = lesson.solution(number, limit, power);
        System.out.println(result);
    }
}
