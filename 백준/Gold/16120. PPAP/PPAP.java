import java.util.Scanner;
import java.util.Stack;

public class Main {

    private static final String PPAP = "PPAP";
    private static final String NP = "NP";
    private static final String P = "P";
    private static final String A = "A";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] str = sc.nextLine().split("");
        System.out.println(getAnswer(str));
    }

    private static String getAnswer(String[] str) {
        Stack<String> stack = new Stack<>();
        for(int i=0; i<str.length; i++) {
            if(str[i].equals(P)) {
                stack.push(str[i]);
                continue;
            }

            if(stack.size() < 2) return NP;
            if(i+1 == str.length) return NP;

            String before1 = stack.pop();
            String before2 = stack.pop();
            if(before1.equals(P) && before2.equals(P) && str[i+1].equals(P)) {
                stack.push(str[++i]);
            } else {
                return NP;
            }
        }
        
        return stack.size() == 1 && stack.pop().equals(P) ? PPAP : NP;
    }
}