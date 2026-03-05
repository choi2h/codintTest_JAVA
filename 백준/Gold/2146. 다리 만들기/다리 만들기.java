import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    private static final int[] MOVE_X = {-1, 1, 0, 0};
    private static final int[] MOVE_Y = {0, 0, -1, 1};
    private static Queue<Integer> xQueue = new LinkedList<>();
    private static Queue<Integer> yQueue = new LinkedList<>();
    private static final int MAX_VALUE = 10001;
    private static int answer = MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[][] map = new int[n][n];
        int[][] checkArr = new int[n][n];
        for (int x=0; x<n; x++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int y=0; y<n; y++) {
                map[x][y] = Integer.parseInt(st.nextToken());
                checkArr[x][y] = map[x][y] == 1 ? 0 : MAX_VALUE;
            }
        }

        int cnt = 2;
        for (int x=0; x<n; x++) {
            for (int y=0; y<n; y++) {
                if (map[x][y] == 1) checkCnt(map, x, y, n, cnt++);
            }
        }


        for (int x=0; x<n; x++) {
            for (int y=0; y<n; y++) {
                if (map[x][y] == 0 || !isCheck(map, x, y, n)) continue;
                check(checkArr, map, x, y, n);
            }
        }


        System.out.println(answer);
    }

    private static void checkCnt(int[][] map, int x, int y, int n, int cnt) {
        xQueue.add(x);
        yQueue.add(y);
        map[x][y] = cnt;
        while (!xQueue.isEmpty() && !yQueue.isEmpty()) {
            int curX = xQueue.poll();
            int curY = yQueue.poll();

            for (int i=0; i<4; i++) {
                int mx = curX + MOVE_X[i];
                int my = curY + MOVE_Y[i];

                if (mx >= 0 && mx < n && my >= 0 && my < n && map[mx][my] == 1) {
                    map[mx][my] = cnt;

                    xQueue.add(mx);
                    yQueue.add(my);
                }
            }
        }
    }

    private static boolean isCheck(int[][] map, int x, int y, int n) {
        for (int i=0; i<4; i++) {
            int mx = x + MOVE_X[i];
            int my = y + MOVE_Y[i];

            if (mx >= 0 && mx < n && my >= 0 && my < n) {
                if (map[mx][my] == 0) return true;
            }
        }

        return false;
    }

    private static void check(int[][] checkArr, int[][] map, int x, int y, int n) {
        xQueue.add(x);
        yQueue.add(y);

        while (!xQueue.isEmpty() && !yQueue.isEmpty()) {
            int curX = xQueue.poll();
            int curY = yQueue.poll();
            int nextNum = checkArr[curX][curY] + 1;
            if (answer < nextNum) continue;

            for (int i=0; i<4; i++) {
                int mx = curX + MOVE_X[i];
                int my = curY + MOVE_Y[i];

                if (mx >= 0 && mx < n && my >= 0 && my < n) {
                    if (map[mx][my] > 1 && map[mx][my] != map[x][y] && answer > checkArr[curX][curY]) {
                        answer = checkArr[curX][curY];
                        continue;
                    }

                    if (checkArr[mx][my] <= nextNum) continue;

                    checkArr[mx][my] = nextNum;
                    xQueue.add(mx);
                    yQueue.add(my);
                }
            }
        }
    }

}