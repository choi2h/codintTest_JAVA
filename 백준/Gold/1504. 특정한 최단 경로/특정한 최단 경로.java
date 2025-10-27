import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        
        List<int[]>[] arr = new ArrayList[n+1];
        for(int i=1; i<=n; i++) {
            arr[i] = new ArrayList<>();
        }

        for(int i=0; i<e; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            arr[a].add(new int[]{b, c});
            arr[b].add(new int[]{a, c});
        }

        st = new StringTokenizer(br.readLine());
        int v1 = Integer.parseInt(st.nextToken());
        int v2 = Integer.parseInt(st.nextToken());
    
        long[] startDists = getDist(arr, 1);
        long[] v1Dists = getDist(arr, v1);
        long[] v2Dists = getDist(arr, v2);

        long s_v1_v2_n = startDists[v1] + v1Dists[v2] + v2Dists[n];
        long s_v2_v1_n = startDists[v2] + v2Dists[v1] + v1Dists[n];

        if (startDists[v1] > -1 && v1Dists[v2] > -1 && v2Dists[n] > -1 
        && startDists[v2] > -1 && v2Dists[v1] > -1 && v1Dists[n] > -1) System.out.print(Math.min(s_v1_v2_n, s_v2_v1_n));
        else if (startDists[v1] > -1 && v1Dists[v2] > -1 && v2Dists[n] > -1) System.out.print(s_v1_v2_n);
        else if (startDists[v2] > -1 && v2Dists[v1] > -1 && v1Dists[n] > -1) System.out.print(s_v1_v2_n);
        else System.out.print(-1);
    }

    private static long[] getDist(List<int[]>[] arr, int s) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[1]-b[1]);
        pq.add(new int[]{s, 0});
        
        long[] dists = new long[arr.length];
        Arrays.fill(dists, -1);
        while(!pq.isEmpty()) {
            int[] cur = pq.poll();

            if(dists[cur[0]] >= 0 && dists[cur[0]] <= cur[1]) continue;
            dists[cur[0]] = cur[1];
            for(int[] next : arr[cur[0]]) {
                if(dists[next[0]] > -1 && dists[next[0]] <= cur[1]+next[1]) continue;
                pq.add(new int[]{next[0], cur[1] + next[1]});
            }
        }

        return dists;
    }
    
}