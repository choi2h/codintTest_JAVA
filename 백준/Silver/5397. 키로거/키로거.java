import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringBuffer sb = new StringBuffer();
        Stack<Character> forward = new Stack<>();
        Stack<Character> backward = new Stack<>();
        while(n-- > 0) {
            String input = br.readLine();

            for(char c : input.toCharArray()) {
                if(c == '-') {
                    if(!forward.isEmpty()) forward.pop();
                } else if (c == '<') {
                    if(!forward.isEmpty()) backward.push(forward.pop());
                } else if (c == '>') {
                    if(!backward.isEmpty()) forward.push(backward.pop());
                } else {
                    forward.push(c);
                }
            }

            StringBuilder result = new StringBuilder();
            for(char c : forward) {
                result.append(c);
            }
            while(!backward.isEmpty()) {
                result.append(backward.pop());
            }

            sb.append(result.append("\n"));
            forward.clear();
            backward.clear();
        }

        System.out.print(sb);
    }
}