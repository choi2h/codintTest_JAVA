package Programmers.Array;

import java.util.Arrays;

public class Lesson_87946 {

    int maxCount = 0;

    public int solution(int k, int[][] dungeons) {
        Arrays.sort(dungeons, (a, b) -> a[0] == b[0] ? a[1]-b[1] : b[0]-a[0]);
        for(int[] d : dungeons) {
            System.out.println(Arrays.toString(d));
        }

        boolean[] visited = new boolean[dungeons.length];
        find(dungeons, visited, k, 0);
        return maxCount;
    }

    private void find(int[][] dungeons, boolean[] visited, int k, int count) {
        maxCount = Math.max(maxCount, count);

        for(int i=0; i<dungeons.length; i++) {
            if(visited[i] || k < dungeons[i][0]) continue;
            visited[i] = true;
            find(dungeons, visited, k-dungeons[i][1], count+1);
            visited[i] = false;
        }
    }

    public static void main(String[] args) {
        Lesson_87946 obj = new Lesson_87946();
        int result = obj.solution(80, new int[][]{{80, 20}, {50, 40}, {30,10}});
        System.out.println(result);
    }
}
