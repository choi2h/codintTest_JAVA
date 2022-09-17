package inflearn.stack;

import java.nio.file.Path;
import java.util.Scanner;
import java.util.Stack;

public class Q5 {
    public int solution(String str) {
        int answer=0;
        Stack<Character> stack = new Stack<>();
        /*
        boolean isOpen = true;
        for(char c : str.toCharArray()) {
            if(c == ')') {
                stack.pop();

                if(isOpen) {
                    answer += stack.size();
                } else {
                    answer += 1;
                }

                isOpen = false;
            } else {
                if(!isOpen) {
                    isOpen = true;
                }

                stack.push(c);
            }
        }
        */
        for(int i=0; i<str.length(); i++) {
            if(str.charAt(i)=='(') stack.push('(');
            else {
                stack.pop();
                if(str.charAt(i-1)== '(') answer += stack.size();
                else answer++;
            }
        }


        return answer;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.next();

        Q5 q = new Q5();
        int result = q.solution(str);
        System.out.println(result);
    }
}
