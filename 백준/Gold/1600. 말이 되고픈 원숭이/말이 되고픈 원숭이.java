import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    private static final int[] MOVE_X = {-1, 1, 0, 0};
    private static final int[] MOVE_Y = {0, 0, -1, 1};

    private static final int[] JUMP_X = {-2, -2, -1, -1, 1, 1, 2, 2};
    private static final int[] JUMP_Y = {-1, 1, -2, 2, -2, 2, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        int[][] map = new int[n][m];
        for (int x=0; x<n; x++) {
            st = new StringTokenizer(br.readLine());
            for (int y=0; y<m; y++) {
                map[x][y] = Integer.parseInt(st.nextToken());
            }
        }

        int maxValue = n*m+1;
        int[][][] check = new int[n][m][k+1];
        for (int x=0; x<n; x++) {
            for (int y=0; y<m; y++) {
                if (x == 0 && y == 0) continue;

                Arrays.fill(check[x][y], maxValue);
            }
        }


        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0, 0}); // x, y
        while(!queue.isEmpty()) {
            int[] cur = queue.poll();
            int curX = cur[0], curY = cur[1], curK = cur[2];

            for (int i=0; i<4; i++) {
                int nx = curX + MOVE_X[i];
                int ny = curY + MOVE_Y[i];

                if (nx >= 0 && nx < n && ny >= 0 && ny < m &&
                        map[nx][ny] == 0 && check[nx][ny][curK] > check[curX][curY][curK]+1) {
                    check[nx][ny][curK] = check[curX][curY][curK]+1;
                    queue.add(new int[]{nx, ny, curK});
                }
            }

            if (curK < k) {
                for (int i=0; i<8; i++) {
                    int nx = curX + JUMP_X[i];
                    int ny = curY + JUMP_Y[i];

                    if (nx >= 0 && nx < n && ny >= 0 && ny < m &&
                            map[nx][ny] == 0 && check[nx][ny][curK+1] > check[curX][curY][curK]+1) {
                        check[nx][ny][curK+1] = check[curX][curY][curK]+1;
                        queue.add(new int[]{nx, ny, curK+1});
                    }
                }
            }
        }

        int answer = maxValue;
        for (int j=0; j<=k; j++) {
            answer = Math.min(answer, check[n-1][m-1][j]);
        }

        System.out.println(answer == maxValue ? -1 : answer);
    }
}