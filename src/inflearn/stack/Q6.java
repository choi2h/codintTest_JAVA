package inflearn.stack;

import java.util.*;

public class Q6 {
    public int solution(int n, int m) {
        int answer =0;
       /*
       List<Integer> list = new ArrayList<>();

        for(int i=1; i<=n; i++) {
            list.add(i);
        }

        int index = m-1;
        while (list.size() > 1) {
            while(index >= list.size()) {
                index -= list.size();
            }

            list.remove(index);
            index += m-1;
        }

        answer = list.get(0);
        */

        Queue<Integer> Q = new LinkedList<>();
        for(int i=1; i<=n; i++) {
            Q.offer(i);
        }

        while(!Q.isEmpty()) {
            for(int i=1; i<m; i++) {
                Q.offer(Q.poll());
            }

            Q.poll();

            if(Q.size()==1) {
                answer = Q.poll();
            }
        }


        return answer;
    }

    public static void main(String[] args) {
        Scanner in  = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();

        Q6 q = new Q6();
        int result = q.solution(n, m);
        System.out.println(result);
    }
}
