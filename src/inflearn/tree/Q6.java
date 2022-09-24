package inflearn.tree;

/*
왼쪽 : 사용
오른쪽 : 사용안함
            1
            /\
          2    2
        /\      /\
      3   3    3   3
     /\   /\   /\   /\
  123 12 13 1 23 2 3  x   -> 결과
 */
public class Q6 {
    static int n;
    static int[] ch; // 사용여부 저장
    public void DFS(int L) {
        if(L==n+1) { // n까지의 값만 필요하므로 n+1의 값이 들어오면 끝 : 출력
            String tmp ="";
            for(int i=1; i<=n; i++) { //1~N까지 중 사용(1)로 설정된 값만 tmp에 더하여 출력
                if(ch[i] == 1) {
                    tmp += i + " ";
                }
            }
            if(tmp.length() > 0) {
                System.out.println(tmp);
            }
        } else {
            ch[L] = 1; // 현재값을 사용
            DFS(L +1); // 자식 노드 DFS 실행
            ch[L] = 0; // 현재값 미사용
            DFS(L +1); // 자식 노드의 DFS 실행
        }
    }

    public static void main(String[] args) {
        Q6 q = new Q6();
        n = 3;
        ch = new int[n+1]; //1부터 n까지의 부분집합을 구하는 것이므로 0을 제외한 1~N 인덱스 생성
        q.DFS(1);
    }
}
