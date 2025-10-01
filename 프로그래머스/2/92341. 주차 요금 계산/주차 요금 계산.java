import java.util.Map;
import java.util.TreeMap;

class Solution {
    
    private static final int MAX_TIME = (23*60) + 59;
    
    public int[] solution(int[] fees, String[] records) {
        Map<String, Integer> map = new TreeMap<>();
        for(String record : records) {
            String[] recordInfo = record.split(" ");
            int sign = recordInfo[2].equals("IN") ? -1 : 1;
            int time = getTime(recordInfo[0]) * sign;
            String num = recordInfo[1];
            map.put(num, map.getOrDefault(num, 0) + time);
        }
    
        int idx = 0;
        int[] answer = new int[map.size()];
        for (int time : map.values()) {
            if(time <= 0) time += MAX_TIME;
            int cost = fees[1];
            if(time > fees[0]) {
                time -= fees[0];
                cost += ((time/fees[2]) + (time%fees[2] > 0 ? 1 : 0))*fees[3];
            }
            answer[idx++] = cost;
        }
        
        
        return answer;
    }
    
    private static int getTime(String time) {
        String[] times = time.split(":");
        return (Integer.parseInt(times[0])*60) + Integer.parseInt(times[1]);
    }
}