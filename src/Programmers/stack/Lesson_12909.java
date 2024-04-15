package Programmers.stack;

import java.util.Stack;

public class Lesson_12909 {
    boolean solution(String s) {
        char[] parentheses = s.toCharArray();
        Stack<Character> stack= new Stack<>();

        for(char c : parentheses) {
            if(c == '(') {
                stack.push(c);
            } else if(c == ')'){
                if(!stack.isEmpty() && stack.peek() == '('){
                    stack.pop();
                } else {
                    return false;
                }
            }
        }


        return stack.isEmpty();
    }

    /*
    "()()"	true
    "(())()"	true
    ")()("	false
    "(()("	false
     */
    public static void main(String[] args) {
//        String s = "()()";
//        String s = "(())()";
        String s = ")()(";
//        String s = "(()(";


        Lesson_12909 lesson = new Lesson_12909();
        System.out.println(lesson.solution(s));
    }
}
