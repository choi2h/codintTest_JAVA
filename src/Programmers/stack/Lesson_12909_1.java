package Programmers.stack;

import java.util.Stack;

public class Lesson_12909_1 {

    private static final char OPEN = '(';

    boolean solution(String s) {
        Stack<Character> stack = new Stack<>();
        for(char p : s.toCharArray()) {
            if(p == OPEN) {
                stack.push(p);
                continue;
            }

            if(stack.isEmpty()) return false;
            else stack.pop();
        }

        return stack.isEmpty();
    }

    private boolean isSameCount(String s) {
        int openCount = 0;
        int closeCount = 0;

        for(String p : s.split("")) {
            if(p.equals(OPEN)) openCount++;
            else closeCount++;
        }

        return openCount == closeCount;
    }

    /*
    "()()"	true
    "(())()"	true
    ")()("	false
    "(()("	false
     */
    public static void main(String[] args) {
        Lesson_12909_1 lesson = new Lesson_12909_1();
        System.out.println(lesson.solution("()()"));
        System.out.println(lesson.solution("(())()"));
        System.out.println(lesson.solution("(())()"));
        System.out.println(lesson.solution(")()("));
        System.out.println(lesson.solution("(()("));
    }
}
