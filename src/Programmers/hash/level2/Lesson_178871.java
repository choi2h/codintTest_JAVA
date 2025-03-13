package Programmers.hash.level2;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Lesson_178871 {
    public String[] solution(String[] players, String[] callings) {
        Map<String, Integer> map = new HashMap<>();
        for(int i=0; i<players.length; i++) {
            map.put(players[i], i);
        }

        for(String calling : callings) {
            int index = map.get(calling);
            players[index] = players[index-1];
            players[index-1] = calling;

            map.put(calling, index-1);
            map.put(players[index], index);

        }

        return players;
    }

    public static void main(String[] args) {
        Lesson_178871 lesson = new Lesson_178871();
        String[] players = {"mumu", "soe", "poe", "kai", "mine"};
        String[] callings = {"kai", "kai", "mine", "mine"};

        String[] result = lesson.solution(players, callings);
        System.out.println(Arrays.toString(result));
    }
}
