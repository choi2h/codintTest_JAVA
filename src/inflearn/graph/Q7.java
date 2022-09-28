package inflearn.graph;

import java.util.Scanner;

public class Q7 {
    int[][] dy = new int[35][35];

   /* public int DFS(int n, int r) {
        if(n==r || r==0) {
            return 1;
        } else {
            return DFS(n-1, r-1) + DFS(n-1, r);
        }
    } */

    public int DFS(int n, int r) {
        if(dy[n][r]>0) {
            return dy[n][r];
        }

        if(n==r || r==0) {
            return 1;
        } else {
            return dy[n][r] = DFS(n-1, r-1) + DFS(n-1, r);
        }
    }

    public static void main(String[] args) {
        Q7 q = new Q7();
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int r = in.nextInt();
        System.out.println(q.DFS(n, r));
    }
}
