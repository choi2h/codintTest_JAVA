package Programmers.hash.level1;

import java.util.HashMap;
import java.util.Map;

public class Lesson_42576_1 {
    public String solution(String[] participant, String[] completion) {
        Map<String, Integer> map = new HashMap<>();
        for (String name : completion) {
            map.put(name, map.getOrDefault(name, 0) + 1);
        }

        for(String name : participant) {
            if(!map.containsKey(name) || map.get(name) == 0) return name;
            map.put(name, map.get(name)-1);
        }

        return "";
    }

    public static void main(String[] args) {
        Lesson_42576_1 obj = new Lesson_42576_1();
        obj.solution(new String[]{"leo", "kiki", "eden"}, new String[]{"kiki", "eden"});
    }
}
