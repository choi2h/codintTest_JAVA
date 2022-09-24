package inflearn.recursive;

public class Q4 {
    private static int[] FIBO;
    public int DFS(int n) {
        if(FIBO[n] > 0) return FIBO[n];

        if(n==1 || n==2) {
            return FIBO[n] = 1;
        } else {
            return FIBO[n] = DFS(n-2) + DFS(n-1);
        }
    }

    public static void main(String[] args) {
        Q4 q = new Q4();
        int n = 10;
        FIBO = new int[n+1];
        q.DFS(n);
        for(int i=1; i<=n; i++) {
            System.out.print(FIBO[i] + " ");
        }
    }
}
