package Programmers.dfsbfs;


import java.util.ArrayList;
import java.util.List;

public class Lesson_49189 {
    List<Integer>[] record;
    int[] dp;

    public int solution(int n, int[][] edge) {
        record = new List[n+1];
        dp = new int[n + 1];
        for(int[] line : edge) {
            if(record[line[0]] == null) record[line[0]] = new ArrayList<>();
            if(record[line[1]] == null) record[line[1]] = new ArrayList<>();

            record[line[0]].add(line[1]);
            record[line[1]].add(line[0]);
        }

        boolean[] visited = new boolean[n+1];
        visited[1] = true;
        dfs(1, 0, visited);

        int maxValue = 0;
        int count = 0;
        for(int i : dp) {
            if (maxValue < i) {
                maxValue = i;
                count = 1;
                continue;
            }

            if(maxValue == i) count++;
        }

        return count;
    }

    private void dfs(int i, int count, boolean[] visited) {
        dp[i] = count;
        for(int j : record[i]) {
            if(!visited[j] && (dp[j] == 0 || dp[j] > count+1)) {
                visited[j] = true;
                dfs(j, count + 1, visited);
                visited[j] = false;
            }
        }
    }

    public static void main(String[] args) {
        Lesson_49189 sol = new Lesson_49189();
        int result = sol.solution(6, new int[][]{{3, 6}, {4, 2}, {3,2}, {1,3}, {1,2}, {2,4}, {5,2}});
        System.out.println(result);
    }
}
