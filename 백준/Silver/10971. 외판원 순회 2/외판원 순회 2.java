import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    private static final int MAX_VALUE = 11_000_001;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[][] roads = new int[n][n];
        for(int i=0; i<n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j=0; j<n; j++) {
                roads[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int result = MAX_VALUE;
        int allVisited = (1<<n) -1;
        Queue<Integer> queue = new LinkedList<>();
        Queue<Integer> sumQueue = new LinkedList<>();
        Queue<Integer> visitedQueue = new LinkedList<>();
        queue.add(0);
        sumQueue.add(0);
        visitedQueue.add(1);

        while (!queue.isEmpty() && !visitedQueue.isEmpty()) {
            int cur = queue.poll();
            int sum = sumQueue.poll();
            int visit = visitedQueue.poll();

            for (int i=0; i<n; i++) {
                if (roads[cur][i] == 0 || 0 != (visit & (1<<i))) continue;

                int nextVisited = visit | (1<<i);
                if (nextVisited == allVisited) {
                    if (roads[i][0] == 0) continue;

                    result = Math.min(result, sum + roads[cur][i] + roads[i][0]);
                } else {
                    queue.add(i);
                    sumQueue.add(sum + roads[cur][i]);
                    visitedQueue.add(nextVisited);
                }
            }
        }

        System.out.println(result);
    }

}