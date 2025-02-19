package baekJoon.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// https://www.acmicpc.net/problem/15654
public class Q15654 {

    boolean[] visit;
    int[] arr;
    StringBuilder sb = new StringBuilder();

    private void solution(int n, int m, int[] numbers) {
        arr = new int[m];
        visit = new boolean[n];
        Arrays.sort(numbers);

        dfs(numbers, m, 0);

        System.out.println(sb.toString());
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
            if(!visit[i]) {
                visit[i] = true;
                arr[depth] = numbers[i];

                dfs(numbers, m, depth + 1);
                visit[i] = false;
            }
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

        Q15654 q = new Q15654();
        q.solution(n, m, numbers);
    }
}
