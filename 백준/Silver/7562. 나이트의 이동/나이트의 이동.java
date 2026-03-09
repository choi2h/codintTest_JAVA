import java.io.*;
import java.util.*;

public class Main {

    private static Queue<Integer> xQueue = new LinkedList<>();
    private static Queue<Integer> yQueue = new LinkedList<>();
    private static int[] MOVE_X = {-2, -2, -1, -1, 1, 1, 2, 2};
    private static int[] MOVE_Y = {-1, 1, -2, 2, -2, 2, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            int sx = Integer.parseInt(st.nextToken());
            int sy = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            int ex = Integer.parseInt(st.nextToken());
            int ey = Integer.parseInt(st.nextToken());

            sb.append(getShortestMoveCount(n, sx, sy, ex, ey)).append("\n");
            xQueue.clear();
            yQueue.clear();
        }

        System.out.println(sb);
    }

    private static int getShortestMoveCount(int n, int sx, int sy, int ex, int ey) {
        if (sx == ex && sy == ey) return 0;

        int[][] board = new int[n][n];
        boolean[][] visited = new boolean[n][n];

        xQueue.add(sx);
        yQueue.add(sy);
        board[sx][sy] = 0;
        visited[sx][sy] = true;
        while (!xQueue.isEmpty() && !yQueue.isEmpty()) {
            int cx = xQueue.poll();
            int cy = yQueue.poll();
            int nextCnt = board[cx][cy]+1;

            for (int i=0; i<MOVE_X.length; i++) {
                int nx = cx + MOVE_X[i];
                int ny = cy + MOVE_Y[i];
                if (nx >= 0 && nx < n && ny >= 0 && ny < n && !visited[nx][ny]) {
                    if (nx == ex && ny == ey) return nextCnt;

                    board[nx][ny] = nextCnt;
                    visited[nx][ny] = true;
                    xQueue.add(nx);
                    yQueue.add(ny);
                }
            }
        }

        return board[ex][ey];
    }
}