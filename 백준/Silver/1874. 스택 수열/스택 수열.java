import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());

        int[] nums = new int[count];
        for (int i = 0; i < count; i++) {
            nums[i] = Integer.parseInt(br.readLine());
        }

        int cur = 1, index = 0;
        StringBuilder sb = new StringBuilder();
        Stack<Integer> stack = new Stack<>();
        while (index < nums.length) {
            if (cur <= count && (stack.isEmpty() || stack.peek() < nums[index])) {
                stack.push(cur++);
                sb.append("+").append("\n");
            } else if (!stack.isEmpty() && stack.peek() >= nums[index]) {
                if(stack.peek() == nums[index]) index++;
                stack.pop();
                sb.append("-").append("\n");
            } else {
                break;
            }
        }

        if(cur <= count || !stack.isEmpty() || index < nums.length) System.out.println("NO");
        else System.out.println(sb);
    }
}