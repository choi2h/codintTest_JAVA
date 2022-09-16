package inflearn.stack;

import java.util.Scanner;
import java.util.Stack;

public class Q1 {
    private String solution(String str1) {
        String answer = "YES";
       /* int count=0;
        for(char c : str1.toCharArray()) {
            if(c == '(') {
                count++;
            } else {
                if(count>0) {
                    count--;
                } else {
                    return answer;
                }
            }
        }

        if(count!=0) answer="NO";
        */

        Stack<Character> stack = new Stack<>();
        for(char x : str1.toCharArray()) {
            if(x == '(') stack.push(x);
            else {
                if(stack.isEmpty()) return "NO";
                stack.pop();
            }
        }

        if(!stack.isEmpty()) return "NO";

        return answer;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str1 = in.next();


        Q1 q = new Q1();
        String result = q.solution(str1);
        System.out.println(result);
    }
}
