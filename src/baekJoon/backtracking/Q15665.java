package baekJoon.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// https://www.acmicpc.net/problem/15665
public class Q15665 {

    int[] arr;
    StringBuilder sb = new StringBuilder();

    private void solution(int m, int[] numbers) {
        arr = new int[m];
        Arrays.sort(numbers);

        dfs(numbers, m, 0);

        System.out.println(sb);
    }

    private void dfs(int[] numbers, int m, int depth) {
        if (depth >= m) {
            for (int val : arr) {
                sb.append(val).append(" ");
            }

            sb.append("\n");
            return;
        }

        for (int i = 0; i < numbers.length; i++) {
            if(i>0 && numbers[i-1] == numbers[i]) {
                continue;
            }

            arr[depth] = numbers[i];
            dfs(numbers, m, depth + 1);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        int n = Integer.parseInt(inputs[0]);
        int m = Integer.parseInt(inputs[1]);

        String[] inputNumbers = br.readLine().split(" ");
        int[] numbers = new int[n];
        for(int i=0; i<n; i++) {
            numbers[i] = Integer.parseInt(inputNumbers[i]);
        }

        Q15665 q = new Q15665();
        q.solution(m, numbers);
    }
}
