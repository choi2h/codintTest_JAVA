import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static class Node {
        int idx;
        int x1;
        int x2;
        int y;

        Node(int idx, int x1, int x2, int y) {
            this.idx = idx;
            this.x1 = x1;
            this.x2 = x2;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());

        Node[] arr = new Node[n+1];
        arr[0] = new Node(0, 0, 0, 0);
        int[] records = new int[n+1];
        for(int i=1; i<=n; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            arr[i] = new Node(i, x1, x2, y);
            records[i] = i;
        }

        Arrays.sort(arr, (a, b) -> a.x1 == b.x1 ? a.x2-b.x2 : a.x1-b.x1 );

        int maxRight = arr[1].x2;
        StringBuilder sb = new StringBuilder();
        for(int i=2; i<arr.length; i++) {
            if(arr[i].x1 <= maxRight) {
                union(records, arr[i-1].idx, arr[i].idx);
                maxRight = Math.max(arr[i].x2, maxRight);
            } else {
                maxRight = arr[i].x2;
            }
        }

        for(int i=1; i<=q; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            int result = find(records, start) == find(records, end) ? 1 : 0;
            sb.append(result).append("\n");
        }

        System.out.println(sb);
    }

    private static void union(int[] record, int a, int b) {
        int fa = find(record, a);
        int fb = find(record, b);

        if(fa == fb) return;
        record[fa] = fb;
    }

    private static int find(int[] record, int n) {
        if(record[n] == n) return n;
        return record[n] = find(record, record[n]);
    }
}