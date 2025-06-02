import java.util.Queue;
import java.util.LinkedList;


class Solution {
    
    private int[][] FIND_POINT = new int[][]{{0,1}, {0, -1}, {-1, 0}, {1, 0}};
    
    public int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;

        boolean[][] visited = new boolean[m][n];
        for(int x=0; x<m; x++) {
            for(int y=0; y<n; y++) {
                if(picture[x][y] > 0 && !visited[x][y]) {
                    numberOfArea++;
                    int size = getAreaSize(picture, visited, x, y);
                    maxSizeOfOneArea = Math.max(maxSizeOfOneArea, size);             
                }
            }
        }
        
        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }
    
    private int getAreaSize(int[][] picture, boolean[][] visited, int x, int y) {
        int size = 0;
        Queue<int[]> queue = new LinkedList();
        queue.add(new int[]{x,y});
        while(!queue.isEmpty()) {
            int[] p = queue.poll();
            int cx = p[0];
            int cy = p[1];
            
            if(visited[cx][cy]) continue;
            visited[cx][cy] = true;
            size++;
            for(int[] move : FIND_POINT) {
                int mx = cx + move[0];
                int my = cy + move[1];
                if(mx >= 0 && mx < picture.length &&
                  my >= 0 && my < picture[0].length &&
                  picture[mx][my] == picture[x][y] && 
                  !visited[mx][my]) {
                    queue.add(new int[]{mx,my});
                }
            }
        }
        
        return size;
    }
}