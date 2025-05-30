import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    private static final int[][] MOVE_POINT
            = new int[][]{{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1,0}, {1, 1}};

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        while(true) {
            String[] inputCount = reader.readLine().split(" ");
            int w = Integer.parseInt(inputCount[0]);
            int h = Integer.parseInt(inputCount[1]);
            if(w == 0 && h == 0) break;

            int[][] arr = new int[h][w];
            for(int i=0; i<h; i++) {
                String[] inputArr = reader.readLine().split(" ");
                for(int j=0; j<inputArr.length; j++) {
                    arr[i][j] = Integer.parseInt(inputArr[j]);
                }
            }

            int count = 0;
            boolean[][] visited = new boolean[h][w];
            for(int i=0; i<h; i++) {
                for(int j=0; j<w; j++) {
                    if(arr[i][j] == 0 || visited[i][j]) continue;
                    checkVisited(visited, arr, i, j);
                    count++;
                }
            }

            sb.append(count).append(" ");
        }

        System.out.println(sb);
    }

    private static void checkVisited(boolean[][] visited, int[][] arr, int i, int j) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{i, j});
        while(!queue.isEmpty()) {
            int[] p = queue.poll();
            int curH = p[0];
            int curW = p[1];
            if(visited[curH][curW]) continue;
            visited[curH][curW] = true;

            for(int[] point : MOVE_POINT) {
                int nextH = curH+point[0];
                int nextW = curW+point[1];
                if(nextH >= 0 && nextH < arr.length &&
                        nextW >= 0 && nextW < arr[0].length &&
                        arr[nextH][nextW] > 0 && !visited[nextH][nextW]) {
                     queue.add(new int[]{nextH, nextW});
                }
            }
        }

    }
}