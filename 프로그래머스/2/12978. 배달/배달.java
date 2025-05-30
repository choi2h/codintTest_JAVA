import java.util.List;
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;

class Solution {
    class Node {
        int num;
        int time;
        
        public Node(int num, int time) {
            this.num = num;
            this.time = time;
        }
    }
    
    public int solution(int N, int[][] road, int K) {
        List<Node>[] arr = new ArrayList[N+1]; 
        for(int i=0; i<arr.length; i++) {
            arr[i] = new ArrayList<>();
        }
        
        for(int i=0; i<road.length; i++) {
            int start = road[i][0];
            int end = road[i][1];
            int time = road[i][2];
            
            arr[start].add(new Node(end, time));
            arr[end].add(new Node(start, time));
        }
        
        int[] times = new int[N+1];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        while(!queue.isEmpty()) {
            int cur = queue.poll();
            
            for(Node next : arr[cur]) {
                int sumTime = times[cur] + next.time;
                if(times[next.num] > 0 && times[next.num] <= sumTime) continue;
                times[next.num] = sumTime;
                queue.add(next.num);
            }
        }
        
        int answer = 1;
        for(int i=2; i<times.length; i++) {
            if(times[i]>0 && times[i] <= K) answer++;
        }
        
        return answer;
    }
}