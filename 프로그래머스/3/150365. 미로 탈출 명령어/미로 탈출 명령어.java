class Solution {
    public String solution(int n, int m, int x, int y, int r, int c, int k) {
        int maxMoveCount = Math.abs(r-x) + Math.abs(c-y);
        if(maxMoveCount%2 != k%2 || maxMoveCount > k) return "impossible";
        
        StringBuilder sb = new StringBuilder();
        while(k-- > 0) {
            int dx = x+1, ly = y-1, ry = y+1, ux = x-1;
            if(dx <= n && canMove(dx, y, r, c, k)) {
                x = dx;
                sb.append('d');
            } else if(ly > 0 && canMove(x, ly, r, c, k)) {
                y = ly;
                sb.append('l');
            } else if(ry <= m && canMove(x, ry, r, c, k)) {
                y = ry;
                sb.append('r');
            } else if(ux > 0 && canMove(ux, y, r, c, k)) {
                x = ux;
                sb.append('u');
            }
        }
        
        return sb.toString();
    }
    
    private boolean canMove(int x, int y, int r, int c, int count) {
        return Math.abs(r-x) + Math.abs(c-y) <= count;
    }
}