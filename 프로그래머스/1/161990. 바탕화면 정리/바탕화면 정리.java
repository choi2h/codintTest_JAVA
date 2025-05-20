class Solution {
    public int[] solution(String[] wallpaper) {
        int lux=Integer.MAX_VALUE, luy=Integer.MAX_VALUE, rdx=0, rdy=0;
        
        for(int i=0; i<wallpaper.length; i++) {
            char[] arr = wallpaper[i].toCharArray();
            for(int j=0; j<arr.length; j++) {
                if(arr[j] == '#') {
                    lux = Math.min(i, lux);
                    luy = Math.min(j, luy);
                    rdx = Math.max(i+1, rdx);
                    rdy = Math.max(j+1, rdy);
                }
            }
        }
        
        
        return new int[]{lux, luy, rdx, rdy};
    }
}