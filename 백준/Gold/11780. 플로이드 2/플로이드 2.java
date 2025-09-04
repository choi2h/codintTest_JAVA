import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    private static final int MAX_VALUE = 100_001;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        // 제공되는 버스비용 저장
        int[][] map = new int[n+1][n+1];
        // 경로 저장
        int[][] dp = new int[n+1][n+1];

        // 오류 방지를 위한 배열 값 초기화
        for (int i = 0; i <= n; i++) {
            for(int j=0; j <= n; j++) {
                if(i == j) continue;
                map[i][j] = MAX_VALUE;
                dp[i][j] = MAX_VALUE;
            }
        }

        // 제공되는 버스 값 초기화
        StringTokenizer st;
        for(int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            map[a][b] = Math.min(map[a][b], c);
            dp[a][b] = a;
        }

        floydWarshall(n, map, dp);

        StringBuilder sb = new StringBuilder();
        printMap(n, map, sb);
        printRoute(n, map, dp, sb);
        System.out.print(sb);
    }

    public static void floydWarshall(int n, int[][] map, int[][] dp) {
        // 중간에 거쳐가는 정점 (k)
        for(int k = 1; k <= n; k++) {
            // 출발 정점 (i)
            for(int i=1; i <= n; i++) {
                // 도착 정점 (j)
                for(int j=1; j <= n; j++) {
                    if(map[i][j] > map[i][k] + map[k][j]) {
                        // 기존에 저장된 최단 거리와 정점 k를 거쳐가는 (i → k) + (k → j) 경로 중 최소값
                        map[i][j] = map[i][k] + map[k][j];
                        // 중간 경로로 정점 k를 거쳐가도록 갱신
                        dp[i][j] = dp[k][j];
                    }
                }
            }
        }
    }

    private static void printMap(int n, int[][] map, StringBuilder sb) {
        for(int i=1; i<=n; i++) {
            for(int j=1; j<=n; j++) {
                sb.append(map[i][j] == MAX_VALUE ? "0" : map[i][j]);
                sb.append(" ");
            }
            sb.append("\n");
        }
    }

    private static void printRoute(int n, int[][] map, int[][] dp, StringBuilder sb) {
        Stack<Integer> stack = new Stack<>();
        for(int i=1; i<=n; i++) {
            for(int j=1; j<=n; j++) {
                if(i == j || map[i][j] == MAX_VALUE || dp[i][j] == MAX_VALUE) sb.append("0");
                else {
                    int pre = j;
                    stack.push(j);
                    while(i != dp[i][pre]) {
                        pre = dp[i][pre];
                        stack.push(pre);
                    }

                    sb.append(stack.size()+1).append(" ").append(i).append(" ");
                    while(!stack.isEmpty()) {
                        sb.append(stack.pop()).append(" ");
                    }
                }
                sb.append("\n");
            }
        }
    }
}