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

        int max = 0;
        for(int i=1; i<=n; i++) {
            if(i==x) continue;
            int dist = getMinDistForTarget(villages, i, x) + getMinDistForTarget(villages, x, i);
            max = Math.max(max, dist);
        }

        System.out.println(max);
    }

    private static int getMinDistForTarget(List<int[]>[] villages, int start, int target) {
        int min = Integer.MAX_VALUE;
        int[] records = new int[villages.length];
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        while(!q.isEmpty()) {
            int cur = q.poll();

            for(int[] next : villages[cur]) {
                int nextIndex = next[0];
                int nextDist = next[1] + records[cur];
                if(nextIndex == target) {
                    min = Math.min(min, records[cur] + next[1]);
                    continue;
                }

                if(records[nextIndex] > 0 && records[nextIndex] <= nextDist) continue;
                records[nextIndex] = nextDist;
                q.add(nextIndex);
            }
        }

        return min;
    }
}