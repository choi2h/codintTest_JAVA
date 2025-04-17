package Programmers.basic;

import java.util.Stack;

public class Lesson_76502 {
    public int solution(String s) {
        int answer = 0;
        char[] arr = s.toCharArray();
        for(int i=0; i<arr.length; i++) {
            if(check(arr, i)) answer++;
        }

        return answer;
    }

    private boolean check(char[] arr, int start) {
        Stack<Character> stack = new Stack<>();

        int count = 0;
        while(count<arr.length) {
            char c = arr[start++];
            switch(c) {
                case ']' -> {
                    if(stack.isEmpty() || stack.pop() != '[') return false;
                }
                case '}' -> {
                    if(stack.isEmpty() || stack.pop() != '{') return false;
                }
                case ')' -> {
                    if(stack.isEmpty() || stack.pop() != '(') return false;
                }
                default -> stack.push(c);
            }
            count++;
            if(start >= arr.length) start = 0;
        }

        return stack.isEmpty();
    }

    public static void main(String[] args) {
        Lesson_76502 solution = new Lesson_76502();
        System.out.println(solution.solution("{"));
    }
}
