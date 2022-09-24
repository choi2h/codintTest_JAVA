package inflearn.recursive;

public class Q3 {
    public int DFS(int n) {
        if(n > 1) {
            return n * DFS(n-1);
        }

        return 1;
    }

    public static void main(String[] args) {
        Q3 q = new Q3();
        System.out.println(q.DFS(5));
    }
}
