import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static final int MAX_COUNT=5;
    private static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[][] map = new int[10][10];
        for(int i=0; i<10; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<10; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[] papers = new int[6];
        for(int i=0; i<6; i++) {
            papers[i] = MAX_COUNT;
        }

        answer = Integer.MAX_VALUE;
        dfs(map, 0, 0, papers, 0);
        System.out.println(answer == Integer.MAX_VALUE ? -1 : answer);
    }

    private static void dfs(int[][] map, int x, int y, int[] paper, int count) {
        if(x>=map.length-1 && y>=map[0].length) {
            answer = Math.min(answer, count);
            return;
        }

        if(answer <= count) return;

        if(y == map[0].length) {
            dfs(map, x+1, 0, paper, count);
            return;
        }

        if(map[x][y] == 0) {
            dfs(map, x, y+1, paper, count);
            return;
        }

        for(int i=5; i>0; i--) {
            if(paper[i] <= 0 || !isValidSquare(map, x, y, i)) continue;

            fillSquare(map, x, y, i, 0);
            paper[i]--;
            dfs(map, x, y+i, paper, count+1);
            paper[i]++;
            fillSquare(map, x, y, i, 1);
        }
    }


    private static boolean isValidSquare(int[][] map, int x, int y, int n) {
        if(x+n-1 >= map.length || y+n-1 >= map[0].length) return false;

        for(int i=x; i<x+n; i++) {
            for(int j=y; j<y+n; j++) {
                if(map[i][j] != 1) return false;
            }
        }

        return true;
    }

    private static void fillSquare(int[][] map, int x, int y, int n, int fillValue) {
        for(int i=x; i<x+n; i++) {
            for(int j=y; j<y+n; j++) {
                    map[i][j] = fillValue;
            }
        }
    }
}