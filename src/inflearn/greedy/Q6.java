package inflearn.greedy;

import java.util.Scanner;

public class Q6 {
    static int[] unf;

    public static int Find(int v) {
        if(v==unf[v]) { //학생의 번호와 해당 값이 같으면 v 그대로 응답
            return v;
        } else {
            return unf[v] = Find(unf[v]); //해당 학생이 가지고 있는 번호의 학생에게 가서 할당 번호 가져옴
        }
    }

    public static void Union(int a, int b) {
        int fa = Find(a);
        int fb = Find(b);
        if(fa!=fb) { // 두 값이 다르면
            unf[fa] = fb; // 위에서 받은 fa의 위치에 fb값을 삽입
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        unf = new int[n+1];
        for(int i=1; i<=n; i++) {
            unf[i] = i; // 각 학생에게 각자의 번호와 같은 집합번호 설정
        }
        for(int i=1; i<=m; i++) {
            int a = in.nextInt();
            int b = in.nextInt();
                Union(a, b); // 두 학생이 친구임을 표시하기위한 경로 압축
            }

        int a = in.nextInt();
        int b = in.nextInt();
        int fa = Find(a); // 연결되어있는 친구들을 통해 자신이 포함된 숫자 가져옴
        int fb = Find(b); // 연결되어있는 친구들을 통해 자신이 포함된 숫자 가져옴
        if(fa == fb) { // 두 숫자가 같으면 친구임
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
