import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer input = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(input.nextToken());
        int m = Integer.parseInt(input.nextToken());
        int x = Integer.parseInt(input.nextToken());

        List<int[]>[] villages = new ArrayList[n+1];
        for(int i=1; i<n+1; i++) {
            villages[i] = new ArrayList<>();
        }

        for(int i=0; i<m; i++) {
            StringTokenizer input2 = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(input2.nextToken());
            int e = Integer.parseInt(input2.nextToken());
            int t = Integer.parseInt(input2.nextToken());

            villages[s].add(new int[]{e,t});
        }

        int[] distsGoHome = getMinDistsForTarget(villages, x);

        int max = 0;
        for(int i=1; i<=n; i++) {
            if(i==x) continue;
            int dist = getMinDistsForTarget(villages, i)[x] + distsGoHome[i];
            max = Math.max(max, dist);
        }

        System.out.println(max);
    }

    private static int[] getMinDistsForTarget(List<int[]>[] villages, int start) {
        int[] dists = new int[villages.length];
        boolean[] visited = new boolean[villages.length];
        PriorityQueue<int[]> q = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));
        q.add(new int[]{start, 0});
        while(!q.isEmpty()) {
            int[] cur = q.poll();

            if(visited[cur[0]]) continue;
            visited[cur[0]] = true;
            for(int[] next : villages[cur[0]]) {
                int nextIndex = next[0];
                int nextDist = dists[cur[0]] + next[1];
                if(dists[nextIndex] != 0 && dists[nextIndex] <= nextDist) continue;

                dists[nextIndex] = nextDist;
                q.add(new int[]{nextIndex, nextDist});
            }
        }

        return dists;
    }
}