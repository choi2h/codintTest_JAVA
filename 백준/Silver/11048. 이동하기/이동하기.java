import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] rooms = new int[n][m];
        for (int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<m; j++) {
                rooms[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] candys = new int[n][m];
        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                int cur = candys[i][j] += rooms[i][j];

                if(i+1 < n) {
                    candys[i+1][j] = Math.max(candys[i+1][j], cur);
                }

                if(j+1 < m) {
                    candys[i][j+1] = Math.max(candys[i][j+1], cur);
                }

                if (i+1 < n && j+1 < m) {
                    candys[i+1][j+1] = Math.max(candys[i+1][j+1], cur);
                }
            }
        }

        System.out.print(candys[n-1][m-1]);
    }
}