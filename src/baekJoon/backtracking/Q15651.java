package baekJoon.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://www.acmicpc.net/problem/15651
public class Q15651 {

    int[] arr;
    StringBuilder sb = new StringBuilder();

    private void solution(int n, int m) {
        arr = new int[m];

        dfs(n, m, 0);
        System.out.println(sb.toString());
    }

    private void dfs(int n, int m, int depth) {
        if (depth >= m) {
            for (int val : arr) {
                sb.append(val).append(" ");
            }

            sb.append("\n");
            return;
        }

        for (int i = 1; i <= n; i++) {
            arr[depth] = i;
            dfs(n, m, depth + 1);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");

        Q15651 q = new Q15651();
        q.solution(Integer.parseInt(inputs[0]), Integer.parseInt(inputs[1]));
    }
}
