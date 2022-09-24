package inflearn.recursive;

public class Q1 {
    public void dfs(int n) {
        if(n > 1) {
            dfs(n-1);
        }

        System.out.println(n);
    }

    public static void main(String[] args) {
        Q1 q = new Q1();
        q.dfs(3);
    }
}
