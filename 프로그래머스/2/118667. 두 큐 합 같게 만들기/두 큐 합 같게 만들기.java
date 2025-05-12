import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int n = queue1.length;
        Queue<Integer> q1 = new LinkedList();
        Queue<Integer> q2 = new LinkedList();
        long tot1 = 0, tot2 = 0;
        for (int j : queue1) {
            tot1 += j;
            q1.add(j);
        }
        for(int i = 0; i < n; i++){
            tot2 += queue2[i];
            q2.add(queue2[i]);
        }

        for(int i = 0; i < 4*n + 1; i++){
            if(tot1 == tot2) return i;
            if(tot1 < tot2){
                int x = q2.poll();
                tot1 += x;
                tot2 -= x;
                q1.add(x);
            }
            else{
                int x = q1.poll();
                tot2 += x;
                tot1 -= x;
                q2.add(x);
            }
        }

        return -1;
    }
}