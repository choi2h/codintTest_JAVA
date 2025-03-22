package Programmers.dfsbfs;

import java.util.*;

public class Lesson_49189 {

    public int solution(int n, int[][] edge) {
        List<Integer>[] record = new List[n+1];
        for(int[] line : edge) {
            if(record[line[0]] == null) record[line[0]] = new ArrayList<>();
            if(record[line[1]] == null) record[line[1]] = new ArrayList<>();

            record[line[0]].add(line[1]);
            record[line[1]].add(line[0]);
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        boolean[] visited = new boolean[n+1];
        int[] dp = new int[n + 1];
        while (!queue.isEmpty()) {
            int cur =  queue.remove();
            if(visited[cur]) continue;

            visited[cur] = true;
            for(int i : record[cur]) {
                queue.add(i);
                dp[i] = !visited[i] && dp[i] == 0 ? dp[cur]+1 : Math.min(dp[cur] + 1, dp[i]);
            }
        }

        int maxValue = 0;
        int count = 0;
        for(int j : dp) {
            if (maxValue < j) {
                maxValue = j;
                count = 1;
            } else if(maxValue == j) count++;
        }

        return count;
    }

    public static void main(String[] args) {
        Lesson_49189 sol = new Lesson_49189();
        int result = sol.solution(6, new int[][]{{3, 6}, {4, 2}, {3,2}, {1,3}, {1,2}, {2,4}, {5,2}});
//        int result = sol.solution(6, new int[][]{{3, 6}, {4, 2}, {3,2}, {1,2}, {2,4}, {5,4}});
        System.out.println(result);
    }
}
