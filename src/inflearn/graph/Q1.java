package inflearn.graph;

import java.util.Scanner;

public class Q1 {
    static String answer="NO";
    static int[] array;
    static int[] ch;

    public void DFS(int L) { // L은 레벨의 인덱스로 사용
        if(L==array.length) { // 마지막 인덱스까지 다 돌았을 경우
            int sum=0;
            int sum2=0;
            for (int i=0; i<array.length; i++) { //전체 목록을 돌면서
                if(ch[i] == 0) { //포함 안하는 것은 안하는 것끼리 합하고
                    sum2+=array[i];
                } else { //포함하는 것들은 포함하는 것끼리 합친다.
                    sum += array[i];
                }
            }

            if(sum==sum2) { // 합친 두 값이 같으면 YES 반환
                answer="YES";
            }

            return;
        }

        ch[L] = 1; // 현재 인덱스의 값이 포함 되는 경우
        DFS(L+1); // 다음 인덱스로 넘어감

        ch[L] = 0; // 현재 인덱스의 값이 포함 안되는 경우
        DFS(L+1); // 다음 인덱스로 넘어감
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        array = new int[n];
        for(int i=0; i<n; i++) {
            array[i] = in.nextInt();
        }

        ch = new int[n];

        Q1 q = new Q1();
        q.DFS(1);
        System.out.println(answer);
    }
}
