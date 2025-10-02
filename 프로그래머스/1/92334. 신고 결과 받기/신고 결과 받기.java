import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.HashSet;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        Map<String, Set<String>> record = new HashMap<>();
        for(String r : report) {
            String[] names = r.split(" ");
            Set<String> arr = record.getOrDefault(names[1], new HashSet<>());
            arr.add(names[0]);
            record.put(names[1], arr);
        }
        
        Map<String, Integer> counts = new HashMap<>();
        for(String to : record.keySet()) {
            if(!record.containsKey(to)) continue;
            Set<String> arr = record.get(to);
            
            if(arr.size() < k) continue;
            for(String from : arr) {
                counts.put(from, counts.getOrDefault(from, 0) + 1);
            }
        }
        
        int[] answer = new int[id_list.length];
        for(int i=0; i<id_list.length; i++) {
            answer[i] = counts.getOrDefault(id_list[i], 0);
        }
        
        return answer;
    }
}