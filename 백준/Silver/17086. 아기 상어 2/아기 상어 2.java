import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    private static final int[] X_MOVE = {-1, 0, 1, -1, 1, -1, 0, 1};
    private static final int[] Y_MOVE = {-1, -1, -1, 0, 0, 1, 1, 1};
    private static final int MAX_VALUE = 51;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] check = new int[N][M];
        List<int[]> sharks = new ArrayList<>();
        for (int x=0; x<N; x++) {
            st = new StringTokenizer(br.readLine());
            for (int y=0; y<M; y++) {
                int n = Integer.parseInt(st.nextToken());
                check[x][y] = n == 1 ? 0 : MAX_VALUE;
                if (n == 1) sharks.add(new int[]{x,y});
            }
        }

        Queue<int[]> queue = new LinkedList<>();
        for (int[] shark : sharks) {
            int x = shark[0];
            int y = shark[1];

            queue.add(new int[]{x, y, 0});
            while (!queue.isEmpty()) {
                int[] cur = queue.remove();
                int cx = cur[0], cy = cur[1], cnt = check[cx][cy];

                for (int mx : X_MOVE) {
                    for (int my : Y_MOVE) {
                        int nx = cx+mx;
                        int ny = cy+my;
                        if (nx >= 0 && nx < N && ny >= 0 && ny < M && check[nx][ny] > cnt+1) {
                            check[nx][ny] = cnt+1;
                            queue.add(new int[]{nx, ny, cnt+1});
                        }
                    }
                }
            }
        }

        int maxValue = 0;
        for (int x=0; x<N; x++) {
            for (int y=0; y<M; y++) {
                maxValue = Math.max(check[x][y], maxValue);
            }
        }
        System.out.println(maxValue);
    }
}