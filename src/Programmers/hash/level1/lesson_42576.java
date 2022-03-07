package Programmers.hash.level1;


import java.util.HashMap;
import java.util.Map;
import java.util.Set;

class Solution {
    /*
    프로그래머스 > 해시 > Level1 > Lesson_42576 > 완주하지 못한 선수
    URL : https://programmers.co.kr/learn/courses/30/lessons/42576

    정확성  테스트
    테스트 1 〉    통과 (0.08ms, 73.9MB)
    테스트 2 〉    통과 (0.05ms, 76.2MB)
    테스트 3 〉    통과 (0.88ms, 79.4MB)
    테스트 4 〉    통과 (0.80ms, 77.4MB)
    테스트 5 〉    통과 (0.84ms, 80.9MB)
    효율성  테스트
    테스트 1 〉    통과 (45.85ms, 82.1MB)
    테스트 2 〉    통과 (73.38ms, 89.1MB)
    테스트 3 〉    통과 (59.83ms, 94.5MB)
    테스트 4 〉    통과 (75.20ms, 95.6MB)
    테스트 5 〉    통과 (86.07ms, 96.4MB)
     */

    public String solution(String[] participant, String[] completion) {
        Map<String, Integer> participantMap = new HashMap<>();

        for (String finishedParticipant : participant) {
            if (!participantMap.containsKey(finishedParticipant)) {
                participantMap.put(finishedParticipant, 1);
            } else {
                int existCount = participantMap.get(finishedParticipant);
                participantMap.put(finishedParticipant, ++existCount);
            }
        }

        for (String completionName : completion) {
            int count = participantMap.get(completionName);
            if (--count == 0) {
                participantMap.remove(completionName);
            } else {
                participantMap.put(completionName, count);
            }
        }

        Set<String> keySet = participantMap.keySet();

        String answer = "";
        for(String name : keySet) {
            answer = name;
            break;
        }
        return answer;
    }
}
