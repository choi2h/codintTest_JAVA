import java.util.Scanner;
import java.util.Stack;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        if(!isValid(input)) {
            System.out.print(0);
            return;
        }

        Stack<String> stack = new Stack<>();
        for(String s : input.split("")) {
            if(s.equals("(") || s.equals("[")) {
                stack.push(s);
                continue;
            }

            if(s.equals(")")) {
                int n = 0;
                while(!stack.isEmpty() && !stack.peek().equals("(")) {
                    n += Integer.parseInt(stack.pop());
                }
                stack.pop();
                stack.push(String.valueOf(n == 0 ? 2 : n*2));
            } else if(s.equals("]")) {
                int n = 0;
                while(!stack.isEmpty() && !stack.peek().equals("[")) {
                    n += Integer.parseInt(stack.pop());
                }
                stack.pop();
                stack.push(String.valueOf(n == 0 ? 3 : n*3));
            }
        }

        int result = 0;
        for(String s : stack) {
            result += Integer.parseInt(s);
        }

        System.out.print(result);
    }

    public static boolean isValid(String input) {
        Stack<Character> stack = new Stack<>();
        for(char c : input.toCharArray()) {
            if(c == '(' || c == '[') stack.push(c);
            else if(stack.isEmpty()) return false;
            else if(c == ')' && stack.peek() == '(') stack.pop();
            else if(c == ']' && stack.peek() == '[') stack.pop();
            else return false;
        }

        return stack.isEmpty();
    }
}