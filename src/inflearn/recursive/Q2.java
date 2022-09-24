package inflearn.recursive;

public class Q2 {
    public void DFS(int n) {

        if(n > 1) {
            DFS(n/2);
            System.out.print(n%2);
        } else {
            System.out.print(n);
        }
    }

    public static void main(String[] args) {
        Q2 q = new Q2();
        q.DFS(11);
    }
}
