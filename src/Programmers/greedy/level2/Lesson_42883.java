package Programmers.greedy.level2;

import java.util.Stack;

public class Lesson_42883 {

    public String solution(String number, int k) {
        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        for(int i=0; i<number.length(); i++) {
            char c = number.charAt(i);
            while (!stack.isEmpty() && stack.peek() < c && k > 0) {
                stack.pop();
                k--;
            }

            stack.push(c);
        }

        while(!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        return sb.reverse().substring(0, sb.length()-k);
    }

    /*
    number	k	return
    "1924"	2	"94"
    "1231234"	3	"3234"
    "4177252841"	4	"775841"
     */
    public static void main(String[] args) {
        Lesson_42883 lesson = new Lesson_42883();
//        String result = lesson.solution("1924", 2);
//        String result = lesson.solution("4177252841", 4);
        String result = lesson.solution("9876543214", 4);
        System.out.println(result);
    }
}
