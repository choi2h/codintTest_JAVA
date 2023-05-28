package Programmers.Array.level2;

import java.util.*;

/*
가장 큰 수
URL : https://school.programmers.co.kr/learn/courses/30/lessons/42746

테스트 1 〉	통과 (167.62ms, 124MB)
테스트 2 〉	통과 (90.37ms, 101MB)
테스트 3 〉	통과 (205.62ms, 142MB)
테스트 4 〉	통과 (11.44ms, 84.1MB)
테스트 5 〉	통과 (119.61ms, 121MB)
테스트 6 〉	통과 (101.54ms, 124MB)
테스트 7 〉	통과 (1.82ms, 83.1MB)
테스트 8 〉	통과 (1.61ms, 77.1MB)
테스트 9 〉	통과 (2.33ms, 78.6MB)
테스트 10 〉	통과 (1.87ms, 76.9MB)
테스트 11 〉	통과 (1.72ms, 73.3MB)
테스트 12 〉	통과 (2.04ms, 73.7MB)
테스트 13 〉	통과 (2.14ms, 75.7MB)
테스트 14 〉	통과 (1.60ms, 77.5MB)
테스트 15 〉	통과 (1.56ms, 77.2MB)
 */
public class Lesson_42746 {

    public static void main(String[] args) {
        int[] test = {3, 30, 34, 5, 9, 959, 998, 345, 342,200, 202, 500, 434};
        int[] test2 = {3, 30, 34, 5, 9, 0, 0};

        int[] test3 = {0, 0, 0};

        Lesson_42746 le = new Lesson_42746();
        String result = le.solution(test2);
        System.out.println(result);

    }

    public String solution(int[] numbers) {
        String[] stringNumbers = new String[numbers.length];
        //int형 배열을 String형 배열로 바꿈
        for(int i = 0; i < numbers.length; i++) {
            stringNumbers[i] = Integer.toString(numbers[i]);
        }

        //두 수를 번갈아가며 합친 수 중 큰 값을 앞으로 정렬(내림차순 정렬)
        Arrays.sort(stringNumbers, new Comparator<String>() {
            @Override public int compare(String o1, String o2) {
                return (o2+o1).compareTo(o1+o2);
            }
        });

        if(stringNumbers[0].equals("0"))
            return "0";

        //문자열을 delimiter("") 기준으로 합침
        return String.join("", stringNumbers);
    }

}