import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st;
        int[][] nodes = new int[n+1][n+1];
        for (int i=1; i<=n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<=n; j++) {
                nodes[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int k=1; k<=n; k++) {
            for (int i=1; i<=n; i++) {
                for (int j=1; j<=n; j++) {
                    nodes[i][j] = nodes[i][j] == 1 ? 1 : nodes[i][k] == 1 && nodes[k][j] == 1 ? 1 : 0;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i=1; i<=n; i++) {
            for (int j=1; j<=n; j++) {
                sb.append(nodes[i][j]).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}