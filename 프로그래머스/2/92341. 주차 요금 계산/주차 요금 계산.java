import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

class Solution {
    private static final String LAST_TIME = "23:59";
    
    // fees 0-기본시간 1-기본요금 2-단위시간 3-단위요금
    public int[] solution(int[] fees, String[] records) {
        Map<String, String> inCars = new HashMap<>();
        Map<String, Integer> times = new HashMap<>();
        for(String r : records) {
            String[] record = r.split(" ");
            String time = record[0];
            String carNumber = record[1];
            String type = record[2];
            
            if (type.equals("IN")) {
                inCars.put(carNumber, time);
            } else {
                int diffMinute = getDiffMinutes(inCars.get(carNumber), time);
                times.put(carNumber, times.getOrDefault(carNumber, 0) + diffMinute);
                inCars.remove(carNumber);
            }
        }
        
        if(!inCars.isEmpty()) {
            for(String carNumber : inCars.keySet()) {
                int diffMinute = getDiffMinutes(inCars.get(carNumber), LAST_TIME);
                times.put(carNumber, times.getOrDefault(carNumber, 0) + diffMinute);
            }
        }
        
        List<String> carNumbers = new ArrayList(times.keySet());
        carNumbers.sort((a,b) -> Integer.parseInt(a)-Integer.parseInt(b));
        
        int[] answer = new int[carNumbers.size()];
        for(int i=0; i<carNumbers.size(); i++) {
            int diffMinute = times.get(carNumbers.get(i));
            int feeMinute = diffMinute > fees[0] ? diffMinute-fees[0] : 0;
            answer[i] = calculateFee(fees, feeMinute);
        }
        
            
        return answer;
    }
    
    private int calculateFee(int[] fees, int feeMinute) {
        int fee = fees[1];
        if(feeMinute > 0) {
            fee += (feeMinute/fees[2])*fees[3];
            if(feeMinute%fees[2] > 0) fee += fees[3];
        } 
        
        return fee;
    }
    
    private int getDiffMinutes(String inTime, String outTime) {
        String[] inTimeValues = inTime.split(":");
        String[] outTimeValues = outTime.split(":");
        
        int inHour = Integer.parseInt(inTimeValues[0]);
        int inMinute = Integer.parseInt(inTimeValues[1]);
        int outHour = Integer.parseInt(outTimeValues[0]);
        int outMinute = Integer.parseInt(outTimeValues[1]);
        
        if(inHour == outHour) return outMinute-inMinute;
        
        int diffMinuts = (60-inMinute)+outMinute; 
        int diffHours = outHour-(inHour+1);
        return diffMinuts + (diffHours*60);
    }
}