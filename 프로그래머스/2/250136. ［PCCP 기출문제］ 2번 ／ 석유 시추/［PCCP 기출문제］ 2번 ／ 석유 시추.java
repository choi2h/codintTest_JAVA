import java.util.Queue;
import java.util.LinkedList;

class Solution {
    
    private static final int[][] find_point = {{-1,0}, {1,0}, {0,-1}, {0,1}};
    private static final int VISIT_CHECK = 10;
    
    public int solution(int[][] land) {
        int n = land.length;
        int m = land[0].length;
        
        int[] record = new int[m];
        int index = 10;
        for(int x=0; x<n; x++) {
            for(int y=0; y<m; y++) {
                if(land[x][y] == 1) addOil(land, record, x, y);
            }
        }
        
        int answer = 0;
        for(int r : record) {
            answer = Math.max(answer, r);
        }
        
        return answer;
    }
    
    private void addOil(int[][] land, int[] record, int x, int y) {
        boolean[] visitedY = new boolean[land[0].length];
        Queue<int[]> queue = new LinkedList();
        queue.add(new int[]{x, y});

        int size = 0;
        while(!queue.isEmpty()) {
            int[] p = queue.poll();
            int cx = p[0];
            int cy = p[1];

            if(land[cx][cy] == VISIT_CHECK) continue;
            land[cx][cy] = VISIT_CHECK;
            visitedY[cy] = true;
            size++;
            for(int[] move : find_point) {
                int mx = cx + move[0];
                int my = cy + move[1];

                if(isValidIndex(mx, land.length) && 
                   isValidIndex(my, land[0].length) &&
                  land[mx][my] == 1) {
                    queue.add(new int[]{mx, my});
                }
            }   
        }
        
        for(int i=0; i<visitedY.length; i++) {
            if(visitedY[i]) record[i] += size;
        }
    }
    
    private boolean isValidIndex(int index, int max) {
        return index >= 0 && index < max;
    }    
}