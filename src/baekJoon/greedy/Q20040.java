package baekJoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q20040 {

    static int[] parent;

    private static int solution(int n, int[][] arr) {
        parent = new int[n];

        for(int i=0; i<n; i++) {
            parent[i] = i;
        }

        for(int i=0; i<arr.length; i++) {
            int a = arr[i][0];
            int b = arr[i][1];

            int fa = find(a);
            int fb = find(b);
            if(fa != fb) {
                parent[fa] = fb;
            }  else {
                return i+1;
            }
        }

        return 0;
    }

    private static int find(int n) {
        if(parent[n] == n) {
            return n;
        } else {
            return parent[n] = find(parent[n]);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line1 = br.readLine().split(" ");
        int n = Integer.parseInt(line1[0]);
        int m = Integer.parseInt(line1[1]);

        int[][] arr = new int[m][2];
        for(int i=0; i<m; i++) {
            String[] line = br.readLine().split(" ");
            arr[i][0] = Integer.parseInt(line[0]);
            arr[i][1] = Integer.parseInt(line[1]);
        }

        int result = solution(n, arr);
        System.out.println(result);
    }
}
