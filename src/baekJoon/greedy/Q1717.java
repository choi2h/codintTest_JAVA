package baekJoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q1717 {
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line1 = br.readLine().split(" ");
        int n = Integer.parseInt(line1[0]);
        int m = Integer.parseInt(line1[1]);

        parent = new int[n+1];
        for(int i=0; i<=n; i++) {
            parent[i] = i;
        }

        int[][] arr = new int[m][3];
        for(int i=0; i<m; i++) {
            String[] line = br.readLine().split(" ");
            arr[i][0] = Integer.parseInt(line[0]);
            arr[i][1] = Integer.parseInt(line[1]);
            arr[i][2] = Integer.parseInt(line[2]);
        }

        for(int i=0; i<m; i++) {
            int x = arr[i][0];
            int a = arr[i][1];
            int b = arr[i][2];

            if(x == 1) {
                System.out.println(union(a, b, false));
            } else {
                union(a, b, true);
            }
        }

    }

    static String union(int a, int b, boolean isUnion) {
        int fa = find(a);
        int fb = find(b);

        if(fa == fb) {
            return "YES";
        } else {
            if(isUnion) {
                parent[fb] = fa;
            }
            return "NO";
        }
    }

    static int find(int n) {
        if(parent[n] == n) {
            return n;
        }

        return parent[n] = find(parent[n]);
    }
}
