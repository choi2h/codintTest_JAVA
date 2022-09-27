package inflearn.tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*
    현수는 송아지의 위치까지 가고싶다.
    송아지는 이동하지 않으며 현수는 스카이콩콩을 타고 앞으로 1, 뒤로 1, 앞으로 5로만 이동할 수 있다.
    현수는 몇번을 이동해야 송아지에게 도착할 수 있나?
 */
public class Q8 {
    int[] dis={1, -1, 5}; // 움직일 수 있는 범위
    int[] ch; // 방문한 곳 표시
    Queue<Integer> Q = new LinkedList<>(); //방문 가능한 곳 저장

    public int BFS(int s, int e) {
        // 방문한 곳 표시를 위한 배열 초기화 : 좌표는 10000까지 나올 수 있음
        // -> index가 10000이 나오려면 0부터시작이니 사이즈는 10001이 되야한다.
        ch = new int[10001];
        ch[s] = 1; // 현재 현수의 위치는 이미 서있는 위치이니 방문 표시
        Q.offer(s); // 큐에도 삽입
        int L=0; // 노드의 레벨 표시 = 현수가 움직인 횟수
        while(!Q.isEmpty()) { //큐가 비어있을 때 멈춰야함
            int len = Q.size(); // 레벨에 있는 노드의 개수
            for(int i=0; i<len; i++) {  //현재 레벨의 위치에서 움직일 수 있는 경우의 수를 찾아보자.
                int x = Q.poll(); // 현재 노드 위치 확인

                for(int j=0; j<3; j++) { // 현수가 움직일 수 있는 범위를 경우의 수로 다 돌아본다.
                    int nx = x+dis[j];

                    if(nx==e) { // 만약 이 위치가 목표지점과 같다면
                        return L+1; // 움직인 횟수 반환
                    }

                    if(nx>=1 && nx<=10000 && ch[nx]==0) { //최소 1에서 10000까지로 범위를 지정했으니 유효성 검사 후 현수가 들르지 않은 곳이라면
                        ch[nx] = 1; // 들렀다는 표시 설정
                        Q.offer(nx); // 큐에 추가해준다.
                    }
                }
            }
            L++; // 다음 레벨로 이동한다. (다음 이동 길을 또 찾아본다.)
        }

        return 0;
    }

    public static void main(String[] args) {
        Q8 q = new Q8();
        Scanner kb = new Scanner(System.in);
        int s = kb.nextInt(); // 현수의 위치
        int e = kb.nextInt(); // 송아지의 위치
        System.out.println(q.BFS(s, e));
    }
}
