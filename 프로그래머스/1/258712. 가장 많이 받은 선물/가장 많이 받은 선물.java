import java.util.Map;
import java.util.HashMap;

class Solution {
    
    public int solution(String[] friends, String[] gifts) {
        int friendsCount = friends.length;        
        Map<String, Integer> friendsMap = new HashMap<>();
        for(int i=0; i<friendsCount; i++) {
            friendsMap.put(friends[i], i);
        }
        
        int[] giftIndex = new int[friendsCount];
        int[][] giftCount = new int[friendsCount][friendsCount];
        for(int i=0; i<gifts.length; i++) {
            String[] giftRecord = gifts[i].split(" ");
            int from = friendsMap.get(giftRecord[0]);
            int to = friendsMap.get(giftRecord[1]);
            
            giftIndex[from]++;
            giftIndex[to]--;
            giftCount[from][to]++;
        }
        
        int answer = 0;
        for(int i=0; i<friendsCount; i++) {
            int count=0;
            for(int j=0; j<friendsCount; j++) {
                if(i == j) continue;
                
                if((giftCount[i][j] == giftCount[j][i] && giftIndex[i] > giftIndex[j]) 
                  || giftCount[i][j] > giftCount[j][i]){
                    count++;
                }
            }
            
            answer = Math.max(count, answer);
        }
        
        return answer;
    }
}