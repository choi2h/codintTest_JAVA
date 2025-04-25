package Programmers.hash.level2;

import java.util.*;

public class Lesson_17684 {
    public int[] solution(String msg) {
        List<Integer> indexes = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        for(char i='A'; i<='Z'; i++) {
            map.put(String.valueOf(i), i-'A'+1);
        }

        int i = 0;
        int maxIndex = map.get("Z");
        String[] str = msg.split("");
        while (i < msg.length()) {
            String w = str[i++];
            int index = map.get(w);
            while(i<msg.length() && map.containsKey(w+str[i])) {
                w += str[i++];
                index = map.get(w);
            }

            if(i<msg.length()) map.put(w+str[i], ++maxIndex);
            indexes.add(index);
        }

        return indexes.stream().mapToInt(j -> j).toArray();
    }

    public static void main(String[] args) {
        Lesson_17684 sol = new Lesson_17684();
        int[] result = sol.solution("KAKAO");
        System.out.println(Arrays.toString(result));
    }
}
