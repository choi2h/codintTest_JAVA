import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static final int[][] MOVE_FORWARD_POINTS = {{-1,0}, {0,1}, {1,0}, {0,-1}};
    private static final int[][] MOVE_BACK_POINTS = {{1,0}, {0,-1}, {-1,0}, {0,1}};
    private static final int UNCLEAN = 0;
    private static final int WALL = 1;
    private static final int CLEAN = 2;

    private static int N;
    private static int M;
    private static int[][] room;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        // 방 크기
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        // 주어지는 좌표도 0,0으로 시작
        st = new StringTokenizer(br.readLine());
        // 로봇청소기 좌표 + 바라보는 방향
        int[] cur = new int[3];
        cur[0] = Integer.parseInt(st.nextToken()); // x
        cur[1] = Integer.parseInt(st.nextToken()); // y
        cur[2] = Integer.parseInt(st.nextToken()); // 방향

        room = new int[N][M];
        for(int x=0; x<N; x++) {
            st = new StringTokenizer(br.readLine());
            for (int y=0; y<M; y++) {
                room[x][y] = Integer.parseInt(st.nextToken());
            }
        }

        int cleanCnt = 0;
        while (true) {
            int curX = cur[0];
            int curY = cur[1];
            if (isUnclean(curX, curY)) {
                clean(curX, curY);
                cleanCnt++;
            }

            int mx = curX, my = curY;
            int direction = cur[2];
            if (isExistUnclean(curX, curY)) {
                while (!isUnclean(mx, my)) {
                    direction = getDirectionIdx(direction);
                    mx = getMovePointForX(curX, direction, true);
                    my = getMovePointForY(curY, direction, true);
                }

                cur[2] = direction;
            } else {
                mx = getMovePointForX(curX, direction, false);
                my = getMovePointForY(curY, direction, false);
                if (isWall(mx, my)) break;
            }

            cur[0] = mx;
            cur[1] = my;
        }

        System.out.println(cleanCnt);
    }

    private static boolean isExistUnclean(int x, int y) {
        for (int[] move : MOVE_FORWARD_POINTS) {
            int mx = x + move[0];
            int my = y + move[1];

            if(isCanMove(mx, my) && isUnclean(mx, my)) return true;
        }

        return false;
    }

    private static boolean isUnclean(int x, int y) {
        return room[x][y] == UNCLEAN;
    }

    private static boolean isCanMove(int x, int y) {
        return x>=0 && x<N && y>=0 && y<M;
    }

    private static boolean isWall(int x, int y) {
        return room[x][y] == WALL;
    }

    private static void clean(int x, int y) {
        room[x][y] = CLEAN;
    }

    private static int getDirectionIdx(int cur) {
        return cur == 0 ? MOVE_FORWARD_POINTS.length-1 : cur-1;
    }

    private static int getMovePointForX(int x, int direction, boolean isForward) {
        return isForward ?
                x + MOVE_FORWARD_POINTS[direction][0] :
                x + MOVE_BACK_POINTS[direction][0];
    }

    private static int getMovePointForY(int y, int direction, boolean isForward) {
        return isForward ?
                y + MOVE_FORWARD_POINTS[direction][1] :
                y + MOVE_BACK_POINTS[direction][1];
    }

}
