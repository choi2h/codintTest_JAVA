import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        List<Integer>[] friends = new ArrayList[N+1];
        for (int i=1; i<N+1; i++) {
            friends[i] = new ArrayList<>();
        }

        int[] counts = new int[N+1];
        for (int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            friends[a].add(b);
            friends[b].add(a);
        }

        int minFriend = 0;
        int minCount = Integer.MAX_VALUE;
        boolean[] visited = new boolean[N+1];
        Queue<Integer> nodeQueue = new LinkedList<>();
        for (int i=1; i<=N; i++) {
            visited[i] = true;
            find(i, friends, nodeQueue, counts, visited);
            nodeQueue.clear();

            int sum = sum(counts);
            if (sum < minCount) {
                minCount = sum;
                minFriend = i;
            }
            Arrays.fill(counts, 0);
            Arrays.fill(visited, false);
        }

        System.out.println(minFriend);
    }

    private static void find(int n, List<Integer>[] friends,
            Queue<Integer> nodeQueue, int[] counts, boolean[] visited) {
        nodeQueue.add(n);

        while(!nodeQueue.isEmpty()) {
            int cur = nodeQueue.poll();

            int curCnt = counts[cur];
            for (int next : friends[cur]) {
                if (visited[next]) continue;

                if (counts[next] == 0) counts[next] = curCnt+1;
                visited[next] = true;
                nodeQueue.add(next);
            }
        }
    }

    private static int sum(int[] counts) {
        int sum = 0;
        for (int cnt : counts) {
            sum += cnt;
        }

        return sum;
    }
}