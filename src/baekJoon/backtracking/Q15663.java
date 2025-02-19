package baekJoon.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// https://www.acmicpc.net/problem/15663
public class Q15663 {

    int[] arr;
    boolean[] visited;
    List<String> list = new ArrayList<>();

    private void solution(int m, int[] numbers) {
        arr = new int[m];
        visited = new boolean[numbers.length];
        Arrays.sort(numbers);

        dfs(numbers, m, 0);

        StringBuilder sb = new StringBuilder();
        for (String s : list) {
            sb.append(s).append("\n");
        }

        System.out.println(sb);
    }

    private void dfs(int[] numbers, int m, int depth) {
        if (depth >= m) {
            StringBuilder str = new StringBuilder();
            for (int val : arr) {
                str.append(val).append(" ");
            }

            if(!list.contains(str.toString())) {
                list.add(str.toString());
            }

            return;
        }

        for (int i = 0; i < numbers.length; i++) {
            if(!visited[i]) {
                visited[i] = true;
                arr[depth] = numbers[i];
                dfs(numbers, m, depth + 1);

                visited[i] = false;
            }
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

        Q15663 q = new Q15663();
        q.solution(m, numbers);
    }
}
