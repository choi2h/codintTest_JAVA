import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    // 동 1, 서 2, 북 3, 남 4
    private static final int[] MOVE_X = {0, 0, 0, -1, 1};
    private static final int[] MOVE_Y = {0, 1, -1, 0, 0};
    private static final int[] TOP = {1, 1};
    private static final int[] BOTTOM = {3, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int curX = Integer.parseInt(st.nextToken());
        int curY = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[][] map = new int[N][M];
        for (int x=0; x<N; x++) {
            st = new StringTokenizer(br.readLine());
            for (int y=0; y<M; y++) {
                map[x][y] = Integer.parseInt(st.nextToken());
            }
        }

        int[] orders = new int[K];
        st = new StringTokenizer(br.readLine());
        for (int i=0; i<K; i++) {
            orders[i] = Integer.parseInt(st.nextToken());
        }

        int top = 1;
        int[][] dice = {{0,2,0}, {4, 1, 3}, {0, 5, 0}, {0, 6, 0}};
        int[] diceNum = {0, 0, 0, 0, 0, 0, 0};

        /// 동 1, 서 2, 북 3, 남 4
        StringBuilder sb = new StringBuilder();
        for (int order : orders) {
            int mx = curX + MOVE_X[order];
            int my = curY + MOVE_Y[order];

            if (mx < 0 || mx >= N || my < 0 || my >= M) {
                continue;
            }

            moveDice(dice, order);

            top = dice[TOP[0]][TOP[1]];
            int bottom = dice[BOTTOM[0]][BOTTOM[1]];
            int num = map[mx][my];
            if (num == 0) {
                map[mx][my] = diceNum[bottom];
            } else {
                diceNum[bottom] = num;
                map[mx][my] = 0;
            }

            sb.append(diceNum[top]).append("\n");
            curX = mx;
            curY = my;
        }

        System.out.println(sb);
    }

    private static void moveDice(int[][] dice, int direction) {
        switch (direction) {
            case 1:
                moveRight(dice);
                break;
            case 2:
                moveLeft(dice);
                break;
            case 3:
                moveTop(dice);
                break;
            case 4:
                moveBottom(dice);
                break;
        }
    }

    private static void moveTop(int[][] dice) {
        int tmp = dice[0][1];
        for (int i=0; i<dice.length-1; i++) {
            dice[i][1] = dice[i+1][1];
        }

        dice[dice.length-1][1] = tmp;
    }

    private static void moveBottom(int[][] dice) {
        int tmp = dice[dice.length-1][1];
        for (int i=dice.length-1; i>0; i--) {
            dice[i][1] = dice[i-1][1];
        }

        dice[0][1] = tmp;
    }

    private static void moveLeft(int[][] dice) {
        int tmp = dice[1][0];
        dice[1][0] = dice[1][1];
        dice[1][1] = dice[1][2];
        dice[1][2] = dice[3][1];
        dice[3][1] = tmp;
    }

    private static void moveRight(int[][] dice) {
        int tmp = dice[1][2];
        dice[1][2] = dice[1][1];
        dice[1][1] = dice[1][0];
        dice[1][0] = dice[3][1];
        dice[3][1] = tmp;
    }


}