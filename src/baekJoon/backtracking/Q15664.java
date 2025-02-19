package baekJoon.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// https://www.acmicpc.net/problem/15664
public class Q15664 {

    int[] arr;
    List<String> list = new ArrayList<>();

    private void solution(int m, int[] numbers) {
        arr = new int[m];
        Arrays.sort(numbers);

        dfs(numbers, m, 0, 0);

        StringBuilder sb = new StringBuilder();
        for (String s : list) {
            sb.append(s).append("\n");
        }

        System.out.println(sb);
    }

    private void dfs(int[] numbers, int m, int depth, int cur) {
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
        int[] numbers = new int[n];
        for(int i=0; i<n; i++) {
            numbers[i] = Integer.parseInt(inputNumbers[i]);
        }

        Q15664 q = new Q15664();
        q.solution(m, numbers);
    }
}
