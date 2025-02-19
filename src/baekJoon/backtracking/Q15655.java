package baekJoon.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// https://www.acmicpc.net/problem/15655
public class Q15655 {

    int[] arr;
    StringBuilder sb = new StringBuilder();

    private void solution(int n, int m, int[] numbers) {
        arr = new int[m];
        Arrays.sort(numbers);

        dfs(numbers, m, 0, 0);

        System.out.println(sb.toString());
    }

    private void dfs(int[] numbers, int m, int depth, int cur) {
        if (depth >= m) {
            for (int val : arr) {
                sb.append(val).append(" ");
            }

            sb.append("\n");
            return;
        }

        for (int i = cur; i < numbers.length; i++) {
            arr[depth] = numbers[i];
            dfs(numbers, m, depth + 1, i+1);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        int n = Integer.parseInt(inputs[0]);
        int m = Integer.parseInt(inputs[1]);

        String[] inputNumbers = br.readLine().split(" ");
        int[] numbers = new int[inputNumbers.length];
        for(int i=0; i<inputNumbers.length; i++) {
            numbers[i] = Integer.parseInt(inputNumbers[i]);
        }

        Q15655 q = new Q15655();
        q.solution(n, m, numbers);
    }
}
