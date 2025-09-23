import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    private static int[][] checkPoints = {{-1, 0},{1, 0}, {0, -1}, {0, 1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer input = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(input.nextToken());
        int m = Integer.parseInt(input.nextToken());
        int[][] arr = new int[n][m];

        int[] startPoint = new int[2];
        int totalCount = 0;

        for(int i=0; i<n; i++) {
            input = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++) {
                arr[i][j] = Integer.parseInt(input.nextToken());

                if(arr[i][j] > 0) {
                    totalCount++;
                    startPoint[0] = i;
                    startPoint[1] = j;
                }
            }
        }

        Queue<int[]> queue = new LinkedList<>();
        int answer = 0;
        while(true) {
            boolean[][] visited = new boolean[n][m];
            int[][] newArr = new int[n][m];
            queue.offer(startPoint);
            int idleCount = 0;

            while(!queue.isEmpty()) {
                int[] cur = queue.poll();
                int x = cur[0];
                int y = cur[1];

                if(visited[x][y]) continue;
                visited[x][y] = true;
                totalCount--;

                int zeroCount = 0;
                for(int[] checkPoint : checkPoints) {
                    int nx = x + checkPoint[0];
                    int ny = y + checkPoint[1];

                    if(nx >= 0 && nx < n && ny >= 0 && ny < m) {
                        if(arr[nx][ny] <= 0) zeroCount++;
                        else if(!visited[nx][ny]) queue.offer(new int[]{nx, ny});
                    }
                }
                
                if(arr[x][y] - zeroCount > 0) {
                    newArr[x][y] = arr[x][y] - zeroCount;
                    idleCount++;

                    startPoint[0] = x;
                    startPoint[1] = y;
                }
            }

            if(totalCount > 0) break;

            answer++;
            arr = newArr;
            if(idleCount == 0) {
                answer = 0;
                break;
            } else totalCount = idleCount;
        }

        System.out.print(answer);
    }
}