import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

class Solution {
    private static final String IN_SIGN = "IN";
    private static final String OUT_SIGN = "OUT";
    private static final int[] MAX_TIME = new int[]{23, 59};
    
    public int[] solution(int[] fees, String[] records) {
        int baseTime = fees[0];
        int baseFee = fees[1];
        int unitTime = fees[2];
        int unitFee = fees[3];
        
        Map<String, Integer> sumRecords = new HashMap<>();
        Map<String, int[]> inRecords = new HashMap<>();
        for(String record : records) {
            String[] recordInfo = record.split(" ");
            int[] time = convertStringToIntArr(recordInfo[0]);
            String num = recordInfo[1];
            String sign = recordInfo[2];
            
            if(sign.equals(IN_SIGN)) inRecords.put(num, time);
            else {
                int timeInterval = getTimeInterval(inRecords.get(num), time);
                sumRecords.put(num, sumRecords.getOrDefault(num, 0) + timeInterval);
                inRecords.remove(num);
            }
        }
        
        for (String num : inRecords.keySet()) {
            int timeInterval = getTimeInterval(inRecords.get(num), MAX_TIME);
            sumRecords.put(num, sumRecords.getOrDefault(num, 0) + timeInterval);
        }
        
        List<String> nums = new ArrayList<>(sumRecords.keySet());
        Collections.sort(nums);
        int[] answer = new int[sumRecords.size()];
        for (int i=0; i<nums.size(); i++) {
            int time = sumRecords.get(nums.get(i));
            answer[i] += baseFee;
            
            if(time > baseTime) {
                int overTime = time-baseTime;
                answer[i] += ((overTime/unitTime) + (overTime%unitTime > 0 ? 1 : 0))*unitFee;
            }
        }
        
        
        return answer;
    }
    
    private static int[] convertStringToIntArr(String time) {
        String[] times = time.split(":");
        int[] arr = new int[2];
        for(int i=0; i<2; i++) {
            arr[i] = Integer.parseInt(times[i]);
        }
        
        return arr;
    }
    
    private static int getTimeInterval(int[] before, int[] after) {
        int hour = after[0]-(before[0]+1);
        int time = (60-before[1])+after[1];
        return (hour*60) + time;
    }
}