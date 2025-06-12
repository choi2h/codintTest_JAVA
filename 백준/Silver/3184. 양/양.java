import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    private static final String SHEEP = "o";
    private static final String WOLF = "v";
    private static final String FENCE = "#";
    private static final int[][] FIND_MOVE_POINT = new int[][]{{-1,0}, {0,-1}, {0,1}, {1,0}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int r = Integer.parseInt(input[0]);
        int c = Integer.parseInt(input[1]);

        String[][] map = new String[r][c];
        for(int i=0; i<r; i++) {
            input = br.readLine().split("");
            for(int j=0; j<c; j++) {
                map[i][j] = input[j];
            }
        }

        boolean[][] visited = new boolean[r][c];
        int sheepCount = 0, wolfCount = 0;
        for(int x=0; x<r; x++) {
            for(int y=0; y<c; y++) {
                if(!visited[x][y] && (map[x][y].equals(SHEEP) || map[x][y].equals(WOLF))) {
                    Queue<int[]> queue = new LinkedList<>();
                    queue.add(new int[]{x, y});
                    int sCount = 0; int wCount = 0;
                    while(!queue.isEmpty()) {
                        int[] cur = queue.poll();
                        int cx = cur[0], cy = cur[1];

                        if(visited[cx][cy]) continue;
                        visited[cx][cy] = true;
                        if(map[cx][cy].equals(SHEEP)) sCount++;
                        else if(map[cx][cy].equals(WOLF)) wCount++;

                        for(int[] move : FIND_MOVE_POINT) {
                            int mx = cx + move[0];
                            int my = cy + move[1];

                            if(isValidPosition(mx, r) && isValidPosition(my, c)
                                    && !visited[mx][my] && !map[mx][my].equals(FENCE)) {
                                queue.add(new int[]{mx, my});
                            }
                        }
                    }

                    if(sCount > wCount) sheepCount += sCount;
                    else wolfCount += wCount;
                }
            }
        }

        System.out.println(sheepCount + " " + wolfCount);
    }

    private static boolean isValidPosition(int p, int max) {
        return p>=0 && p<max;
    }
}