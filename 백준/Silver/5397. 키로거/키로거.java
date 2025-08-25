import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringBuffer sb = new StringBuffer();
        Stack<String> forward = new Stack<>();
        Stack<String> backward = new Stack<>();
        while(n-- > 0) {
            String input = br.readLine();

            for(String s : input.split("")) {
                if(s.equals("-")) {
                    if(!forward.isEmpty()) forward.pop();
                } else if (s.equals("<")) {
                    if(!forward.isEmpty()) backward.push(forward.pop());
                } else if (s.equals(">")) {
                    if(!backward.isEmpty()) forward.push(backward.pop());
                } else {
                    forward.push(s);
                }
            }

            StringBuilder result = new StringBuilder();
            if(!forward.isEmpty()) result.append(String.join("", forward));
            while(!backward.isEmpty()) {
                result.append(backward.pop());
            }

            sb.append(result.append("\n"));
            forward.clear();
            backward.clear();
        }

        System.out.println(sb);
    }
}