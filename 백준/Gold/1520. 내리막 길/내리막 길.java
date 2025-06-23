import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer input = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(input.nextToken());
        int n = Integer.parseInt(input.nextToken());
        int[][] arr = new int[m][n];

        for(int i = 0; i < m; i++) {
            input = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++) {
                arr[i][j] = Integer.parseInt(input.nextToken());
            }
        }

        int[][] movePoints = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        int[][] dp = new int[m][n];
        boolean[][] visited = new boolean[m][n];
        dp[m - 1][n - 1] = 1;
        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o[2]));
        queue.add(new int[]{m-1, n-1, arr[m-1][n-1]});
        while(!queue.isEmpty()) {
            int[] cur = queue.poll();
            int curX = cur[0], curY = cur[1], curHeight = cur[2];

            if(visited[curX][curY]) continue;
            visited[curX][curY] = true;
            for(int[] move: movePoints) {
                int x = curX + move[0];
                int y = curY + move[1];

                if(x < 0 || x >= arr.length
                        || y<0 || y >= arr[0].length
                        || arr[x][y] <= curHeight) continue;

                queue.add(new int[]{x, y, arr[x][y]});
                dp[x][y] += dp[curX][curY];
            }
        }

        System.out.println(dp[0][0]);
    }
}