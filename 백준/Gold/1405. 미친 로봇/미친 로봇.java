import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static double result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer input = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(input.nextToken());
        double[] roads = new double[4];
        roads[0] = Double.parseDouble(input.nextToken()) / 100;
        roads[1] = Double.parseDouble(input.nextToken()) / 100;
        roads[2] = Double.parseDouble(input.nextToken()) / 100;
        roads[3] = Double.parseDouble(input.nextToken()) / 100;


        boolean[][] visited = new boolean[30][30];
        visited[14][14] = true;
        dfs(N, roads, visited, 0, 14, 14, 1);
        System.out.println(result);
    }

    private static void dfs(int N, double[] roads, boolean[][] visited, int count, int x, int y, double per) {
        if(count == N) {
            result += per;
            return;
        }

        for(int i=0; i<roads.length; i++) {
            if(roads[i] <= 0) continue;
            int mx = x;
            int my = y;
            switch (i) {
                case 0: mx++; break;
                case 1: mx--; break;
                case 2: my++; break;
                case 3: my--; break;
            }

            if(mx < 0 || mx >= visited.length || my < 0 || my >= visited[0].length) continue;
            if(visited[mx][my]) continue;

            visited[mx][my] = true;
            dfs(N, roads, visited, count + 1, mx, my, per*roads[i]);
            visited[mx][my] = false;
        }
    }
}