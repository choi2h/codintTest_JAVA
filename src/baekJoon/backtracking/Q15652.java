package baekJoon.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://www.acmicpc.net/problem/15652
public class Q15652 {

    int[] arr;
    StringBuilder sb = new StringBuilder();

    private void solution(int n, int m) {
        arr = new int[m];

        dfs(n, m, 0, 1);
        System.out.println(sb.toString());
    }

    private void dfs(int n, int m, int depth, int cur) {
        if (depth >= m) {
            for (int val : arr) {
                sb.append(val).append(" ");
            }

            sb.append("\n");
            return;
        }

        for (int i = cur; i <= n; i++) {
            arr[depth] = i;
            dfs(n, m, depth + 1, i);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");

        Q15652 q = new Q15652();
        q.solution(Integer.parseInt(inputs[0]), Integer.parseInt(inputs[1]));
    }
}
