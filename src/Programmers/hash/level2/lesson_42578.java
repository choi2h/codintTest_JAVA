package Programmers.hash.level2;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

class Solution{
      /*
      프로그래머스 > 해시 > Level1 > Lesson_42578 > 위장
        URL : https://programmers.co.kr/learn/courses/30/lessons/42578

        정확성  테스트
        테스트 1 〉	통과 (0.06ms, 78.4MB)
        테스트 2 〉	통과 (0.04ms, 67.1MB)
        테스트 3 〉	통과 (0.06ms, 75.4MB)
        테스트 4 〉	통과 (0.07ms, 76MB)
        테스트 5 〉	통과 (0.05ms, 75MB)
        테스트 6 〉	통과 (0.03ms, 82.7MB)
        테스트 7 〉	통과 (0.06ms, 74.4MB)
        테스트 8 〉	통과 (0.07ms, 75.8MB)
        테스트 9 〉	통과 (0.06ms, 88.5MB)
        테스트 10 〉	통과 (0.04ms, 72.9MB)
        테스트 11 〉	통과 (0.05ms, 74.6MB)
        테스트 12 〉	통과 (0.07ms, 74MB)
        테스트 13 〉	통과 (0.09ms, 76.2MB)
        테스트 14 〉	통과 (0.06ms, 76.8MB)
        테스트 15 〉	통과 (0.06ms, 83.5MB)
        테스트 16 〉	통과 (0.05ms, 66.4MB)
        테스트 17 〉	통과 (0.06ms, 73.7MB)
        테스트 18 〉	통과 (0.06ms, 74.2MB)
        테스트 19 〉	통과 (0.05ms, 75MB)
        테스트 20 〉	통과 (0.05ms, 77.5MB)
        테스트 21 〉	통과 (0.04ms, 76.1MB)
        테스트 22 〉	통과 (0.03ms, 76.2MB)
        테스트 23 〉	통과 (0.04ms, 73.6MB)
        테스트 24 〉	통과 (0.04ms, 72.1MB)
        테스트 25 〉	통과 (0.04ms, 76.3MB)
        테스트 26 〉	통과 (0.06ms, 73.7MB)
        테스트 27 〉	통과 (0.04ms, 76.2MB)
        테스트 28 〉	통과 (0.08ms, 77.1MB)
    */
    public int solution(String[][] clothes) {
        Map<String, Integer> clotheMap = new HashMap<>();

        for (int i = 0; i < clothes.length; i++) {
            String clothingType = clothes[i][1];

            int count = clotheMap.getOrDefault(clothingType, 0) + 1;
            clotheMap.put(clothingType, count);
        }

        int totalClotheCount = 1;

        Set<String> clotheSet = clotheMap.keySet();
        for (String clotheType : clotheSet) {
            totalClotheCount *= clotheMap.get(clotheType) + 1;
        }


        return totalClotheCount - 1;
    }
}
