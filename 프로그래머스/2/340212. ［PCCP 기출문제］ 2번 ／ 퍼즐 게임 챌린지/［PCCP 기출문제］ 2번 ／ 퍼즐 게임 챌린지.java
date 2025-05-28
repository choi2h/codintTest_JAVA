class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        int answer = 0;
        
        int min = Integer.MAX_VALUE, max = 0;
        for(int i : diffs) {
            min = Math.min(min, i);
            max = Math.max(max, i);
        }
        
        while(min <= max) {
            int mid = (min+max)/2;
            long time = 0;
            for(int i=0; i<diffs.length; i++) {
                if(diffs[i] > mid) {
                    time += times[i] * (diffs[i]-mid+1);
                    if(i > 0) time += times[i-1] * (diffs[i]-mid);
                } else time += times[i];
            }
            
            if (time <= limit) {
                answer = mid;
                max=mid-1; 
            } else min = mid+1;
        }
        
        return answer;
    }
}