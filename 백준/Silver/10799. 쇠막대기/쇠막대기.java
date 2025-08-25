import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<String> stack = new Stack<>();
        for(String s : br.readLine().split("")) {
            stack.push(s);
        }

        int openCount = 0;
        int answer = 0;
        while(!stack.isEmpty()) {
            String s = stack.pop();
            if(s.equals(")")) {
                if(stack.peek().equals("(")) {
                    answer += openCount;
                    stack.pop();
                } else openCount++;
            } else {
                answer++;
                openCount--;
            }
        }

        System.out.println(answer);
    }
}