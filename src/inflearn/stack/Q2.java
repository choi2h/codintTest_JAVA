package inflearn.stack;

import java.util.Scanner;
import java.util.Stack;

public class Q2 {
    private String solution(String str1) {
        StringBuilder answer = new StringBuilder();
        /*
        int count=0;
        for(char c : str1.toCharArray()) {
            if(c == '(') {
                count++;
            } else if(c ==')') {
                count--;
            } else {
                if(count==0) {
                    answer.append(c);
                }
            }
        }
        */

        Stack<Character> stack = new Stack<>();
        for(char x : str1.toCharArray()) {
            if(x==')') {
                while(stack.pop()!='(');
            } else {
                stack.push(x);
            }
        }

        for(int i=0; i<stack.size(); i++) {
            answer.append(stack.get(i));
        }
        return answer.toString();
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str1 = in.next();
        Q2 q = new Q2();
        String result = q.solution(str1);
        System.out.println(result);
    }
}
