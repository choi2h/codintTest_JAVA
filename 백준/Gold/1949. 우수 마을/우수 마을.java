import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.List;
import java.util.ArrayList;

public class Main {

    private static int[] cnts;
    private static List<Integer>[] roads;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        cnts = new int[N];
        roads = new ArrayList[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            cnts[i] = Integer.parseInt(st.nextToken());
            roads[i] = new ArrayList<>();
        }

        for (int i=0; i<N-1; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken())-1;
            int e = Integer.parseInt(st.nextToken())-1;
            roads[s].add(e);
            roads[e].add(s);
        }

        int[][] dp = new int[N][2];
        boolean[] visited = new boolean[N];
        find(dp, visited, 0);

        System.out.println(Math.max(dp[0][0], dp[0][1]));
    }

    private static void find(int[][] dp, boolean[] visited, int cur) {
        visited[cur] = true;

        int bestVillageCnt = cnts[cur];
        int normalVillageCnt = 0;
        boolean isExistBestVillage = false;
        for (int next : roads[cur]) {
            if (!visited[next]) find(dp, visited, next);
            bestVillageCnt += dp[next][1];

            if (dp[next][0] > dp[next][1]) {
                isExistBestVillage = true;
                normalVillageCnt += dp[next][0];
            } else {
                normalVillageCnt += dp[next][1];
            }
        }

        if (!isExistBestVillage) {
           int minGap = Integer.MAX_VALUE, maxIdx = 0;
           for (int next : roads[cur]) {
               if (dp[next][1]-dp[next][0] < minGap) {
                   minGap = dp[next][1]-dp[next][0];
               }
           }

           normalVillageCnt -= dp[maxIdx][1];
           normalVillageCnt += dp[maxIdx][0];
        }

        dp[cur][0] = bestVillageCnt;
        dp[cur][1] = normalVillageCnt;
    }

}