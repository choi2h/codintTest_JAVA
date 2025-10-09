import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

class Solution {
    private static final int MAX_VALUE = 10_000_001;
    
    // 출입구 - 처음과 끝 한번씩 / 봉우리는 한번만 포함
    public int[] solution(int n, int[][] paths, int[] gates, int[] summits) {
        // 경로 저장
        List<int[]>[] pathList = new ArrayList[n+1];
        for(int i=1; i<=n; i++) pathList[i] = new ArrayList<>();
        
        for(int[] path : paths) {
            pathList[path[0]].add(new int[]{path[1], path[2]});
            pathList[path[1]].add(new int[]{path[0], path[2]});
        }
        
        // 특정 제한지역 체크 gate: 1 / summit: 2
        int[] check = new int[n+1];
        for(int gate : gates) check[gate] = 1;
        for(int summit : summits) check[summit] = 2;
        
        int[] dist = new int[n+1];
        Arrays.fill(dist, MAX_VALUE);
        
        PriorityQueue<int[]> queue = 
            new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));
        for(int gate : gates) {
            dist[gate] = 0;
            queue.offer(new int[]{gate, 0});
        }
        
        while(!queue.isEmpty()) {
            int[] cur = queue.poll();
            int c = cur[0], i = cur[1];
            
            if(dist[c] < i) continue;
            for(int[] path : pathList[c]) {
                int np = path[0], w = path[1];
                if(check[np]==1) continue;
                
                int nw = Math.max(i, w);
                if(dist[np] > nw) {
                    dist[np] = nw;
                    if(check[np] != 2) queue.offer(new int[]{np, nw});
                }
            }
        }
        
        Arrays.sort(summits);
        int[] answer = new int[]{MAX_VALUE, MAX_VALUE};
        for(int summit : summits) {
            if(dist[summit] < answer[1]) {
                answer[0] = summit;
                answer[1] = dist[summit];
            }
        }
        
        return answer;
    }
}