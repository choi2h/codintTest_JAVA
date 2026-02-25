import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st;
        int[][] map = new int[n][n];
        for (int x=0; x<n; x++) {
            st = new StringTokenizer(br.readLine());
            for (int y=0; y<n; y++) {
                map[x][y] = Integer.parseInt(st.nextToken());
            }
        }

        boolean isArrived = false;
        boolean[][] visited = new boolean[n][n];
        Queue<Integer> xMap = new LinkedList<>();
        Queue<Integer> yMap = new LinkedList<>();
        xMap.add(0);
        yMap.add(0);
        while (!xMap.isEmpty() && !yMap.isEmpty()) {
            int x = xMap.remove();
            int y = yMap.remove();

            if (visited[x][y]) continue;

            if (map[x][y] == -1) {
                isArrived = true;
                break;
            }

            visited[x][y] = true;
            int moveCnt = map[x][y];
            if (x+moveCnt < n) {
                xMap.add(x+moveCnt);
                yMap.add(y);
            }

            if (y+moveCnt < n) {
                xMap.add(x);
                yMap.add(y+moveCnt);
            }
        }

        System.out.println(isArrived ? "HaruHaru" : "Hing");
    }
}
