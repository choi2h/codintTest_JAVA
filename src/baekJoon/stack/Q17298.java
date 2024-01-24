package baekJoon.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/*
오큰수
https://www.acmicpc.net/problem/17298
 */
public class Q17298 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());

        int[] array = new int[count];
        String[] list = br.readLine().split(" ");

        Stack<Integer> stack = new Stack<>();
        for(int i=0; i<count; i++) {
            array[i] = Integer.parseInt(list[i]);

            while(!stack.isEmpty() && array[stack.peek()] < array[i]) {
                array[stack.pop()] = array[i];
            }

            stack.push(i);
        }

        while(!stack.isEmpty()) {
            array[stack.pop()] = -1;
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<array.length-1; i++) {
            sb.append(array[i]).append(" ");
        }

        sb.append(-1);

        System.out.println(sb);
    }
}
