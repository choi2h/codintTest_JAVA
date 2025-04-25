package Programmers.greedy.level2;

import java.util.Stack;

public class Lesson_42883_2 {
    public String solution(String number, int k) {
        Stack<Integer> stack = new Stack<>();
        for(int i=0; i<number.length(); i++) {
            int cur = Integer.parseInt(String.valueOf(number.charAt(i)));
            while(!stack.isEmpty()
                    && number.length()-i > number.length()-k-stack.size()
                    && stack.peek() < cur) stack.pop();
            stack.push(cur);
        }

        StringBuilder answer = new StringBuilder();
        while (!stack.isEmpty()) answer.insert(0, stack.pop());

        return answer.substring(0, number.length()-k);
    }

    public String solution2(String number, int k) {
        // 결과에 쓰일 숫자를 담는다
        // Stack을 사용한 이유 : 가장 마지막 숫자(배열에 가장 마지막에 추가한 숫자)와 비교를 하기 위해
        Stack<Integer> stack = new Stack<>();
        // 최종 문자 길이
        int resultLength = number.length()-k;
        // number의 숫자 순회
        for(int i=0; i<number.length(); i++) {
            // 해당 인덱스의 숫자를 int형으로 변환
            int cur = Character.getNumericValue(number.charAt(i));
            // 만약 제거해야할 숫자가 남아있을 때, 스택의 마지막 숫자가 현재 숫자보다 작으면 숫자 제거
            while(!stack.isEmpty() && k > 0 && stack.peek() < cur) {
                // 제거 숫자 개수 감소
                k--;
                // 숫자 제거
                stack.pop();
            }
            // 현재 숫자 추가
            stack.push(cur);
        }

        // 스택에 쌓아둔 모든 숫자를 넣은 순서대로 String 변환
        StringBuilder answer = new StringBuilder();
        while (!stack.isEmpty()) answer.insert(0, stack.pop());

        // 최종 문자길이만큼만 앞에서부터 잘라서 반환
        return answer.substring(0, resultLength);
    }

    public static void main(String[] args) {
        Lesson_42883_2 lesson = new Lesson_42883_2();
        System.out.println(lesson.solution2("4177252841", 4));
        System.out.println(lesson.solution2("4177252841", 0));
        System.out.println(lesson.solution2("4177252841", 10));
    }
}
