import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {

    private static final int MAX_VALUE = 10_000_001;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        int[][] map = new int[n+1][n+1];
        for(int i=1; i<=n; i++) {
            for(int j=1; j<=n; j++) {
                map[i][j] = MAX_VALUE;
            }
        }

        StringTokenizer st;
        for(int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            map[a][b] = Math.min(map[a][b], c);
        }

        floydwarshall(n, map);
        print(n, map);
    }

    private static void floydwarshall(int n, int[][] map) {
        for(int k=1; k<=n; k++) {
            for(int i=1; i<=n; i++) {
                for(int j=1; j<=n; j++) {
                    if(map[i][j] > map[i][k] + map[k][j]) {
                        map[i][j] = map[i][k] + map[k][j];
                    }
                }
            }
        }
    }

    private static void print(int n, int[][] map) {
        StringBuilder sb = new StringBuilder();

        for(int i=1; i<=n; i++) {
            for(int j=1; j<=n; j++) {
                if(i==j || map[i][j] == MAX_VALUE) sb.append(0);
                else sb.append(map[i][j]);

                sb.append(" ");
            }
            sb.append("\n");
        }

        System.out.print(sb);
    }
}