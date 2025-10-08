class Solution {
    private static final int[][] MOVE = {{1, 0}, {0, -1}, {0, 1}, {-1, 0}};
    private static final char[] MOVE_MESSAGE = {'d', 'l', 'r', 'u'};
    private static boolean[][] checked;
    
    public String solution(int n, int m, int x, int y, int r, int c, int k) {
        int maxMoveCount = Math.abs(r-x) + Math.abs(c-y);
        if(maxMoveCount%2 != k%2) return "impossible";
        
        int[] table = new int[]{n, m};
        int[] end = new int[]{r, c};
        checked = new boolean[n+1][m+1];
        
        String answer = find(table, x, y, end, 0, k);
        if(answer.isEmpty()) return "impossible";
        return answer;
    }
    
    private String find
        (int[] table, int x, int y, int[] arrived, int count, int max) {
        if(checked[x][y] || 
            Math.abs(arrived[0]-x) + Math.abs(arrived[1]-y) > max-count) {
            checked[x][y] = true;
            return "";
        }
        
        for(int i=0; i<MOVE.length; i++) {
            int mx = x+MOVE[i][0];
            int my = y+MOVE[i][1];
            if(!canMove(table, mx, my)) continue;
            if(count+1 < max && !checked[mx][my]) {
                String result = MOVE_MESSAGE[i] + 
                    find(table, mx, my, arrived, count+1, max);
                if(result.length() == max-count) return result;
            } else if(count+1 == max && mx == arrived[0] && my == arrived[1]) {
                return  "" + MOVE_MESSAGE[i];
            }
        }
        
        return "";
    }
    
    private boolean canMove(int[] table, int x, int y) {
        return x > 0 && x <= table[0] && y > 0 && y <= table[1];
    }
}