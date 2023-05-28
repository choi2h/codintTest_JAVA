package Programmers.Array.level1;

import java.util.HashMap;
import java.util.Map;

/*
달리기 경주
URL : https://school.programmers.co.kr/learn/courses/30/lessons/178871

테스트 1 〉	통과 (0.06ms, 79.8MB)
테스트 2 〉	통과 (0.03ms, 73.6MB)
테스트 3 〉	통과 (0.13ms, 71.5MB)
테스트 4 〉	통과 (0.72ms, 74.3MB)
테스트 5 〉	통과 (1.69ms, 81.4MB)
테스트 6 〉	통과 (4.02ms, 93.3MB)
테스트 7 〉	통과 (18.34ms, 124MB)
테스트 8 〉	통과 (48.89ms, 130MB)
테스트 9 〉	통과 (98.02ms, 151MB)
테스트 10 〉	통과 (289.19ms, 230MB)
테스트 11 〉	통과 (597.61ms, 361MB)
테스트 12 〉	통과 (349.39ms, 356MB)
테스트 13 〉	통과 (704.75ms, 392MB)
테스트 14 〉	통과 (0.05ms, 73.7MB)
테스트 15 〉	통과 (0.05ms, 81MB)
테스트 16 〉	통과 (0.04ms, 83.5MB)
 */
public class Lesson_178871 {

    public static String[] solution(String[] players, String[] callings) {
        Map<String, Integer> ranks = new HashMap<>();
        for(int i=0; i<players.length; i++) {
            ranks.put(players[i], i);
        }

        for(String callName : callings) {
            int rank = ranks.get(callName);

            String prePlayer = players[rank-1];

            players[rank-1] = callName;
            players[rank] = prePlayer;

            ranks.put(prePlayer, rank);
            ranks.put(callName, rank-1);
        }

        return players;
    }

    public static void main(String[] args) {
        String[] players = {"mumu", "soe", "poe", "kai", "mine"};
        String[] callings = {"kai", "kai", "mine", "mine"};

        String[] result = solution(players, callings);
        for(String name : result) {
            System.out.println(name);
        }
    }
}
