import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    private static final int[] X_MOVE = {-1, 1, 0, 0};
    private static final int[] Y_MOVE = {0, 0, -1, 1};
    private static final String PRINT_FORMAT = "Problem %d: %d";
    private static final int MAX_VALUE = 125*9+1;

    // 잃을 수 밖에 없는 최소 금액
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testNum = 1;
        while (true) {
            int N = Integer.parseInt(br.readLine());
            if (N == 0) break;

            StringTokenizer st;
            int[][] map = new int[N][N];
            for (int x=0; x<N; x++) {
                st= new StringTokenizer(br.readLine());
                for (int y=0; y<N; y++) {
                    map[x][y] = Integer.parseInt(st.nextToken());
                }
            }

            int minValue = getMinAmount(N, map);
            System.out.println(String.format(PRINT_FORMAT, testNum++, minValue));
        }
    }

    private static int getMinAmount(int N, int[][] map) {
        int[][] checkMap = new int[N][N];
        for (int i=0; i<N; i++) {
            Arrays.fill(checkMap[i], MAX_VALUE);
        }
        checkMap[0][0] = map[0][0];

        Queue<Integer> xMap = new LinkedList<>();
        Queue<Integer> yMap = new LinkedList<>();
        xMap.add(0);
        yMap.add(0);
        while (!xMap.isEmpty() && !yMap.isEmpty()) {
            int curX = xMap.poll();
            int curY = yMap.poll();
            int curAmount = checkMap[curX][curY];

            for (int i=0; i<X_MOVE.length; i++) {
                int nx = curX + X_MOVE[i];
                int ny = curY + Y_MOVE[i];

                if (nx >= 0 && nx < N && ny >= 0 && ny < N
                        && checkMap[nx][ny] > curAmount + map[nx][ny]) {
                    xMap.add(nx);
                    yMap.add(ny);
                    checkMap[nx][ny] = curAmount + map[nx][ny];
                }
            }
        }

        return checkMap[N-1][N-1];
    }
}