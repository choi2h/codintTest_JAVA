package Programmers.hash.level3;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

// https://school.programmers.co.kr/learn/courses/30/lessons/67258
public class Lesson_67258 {
    public int[] solution(String[] gems) {
        Map<String, Integer> map = new HashMap<>();
        for (String gem : gems) {
            if(!map.containsKey(gem)) map.put(gem, 0);
        }

        if(map.size() == 1) return new int[]{1,1};

        int s=0, e=gems.length;
        int start = 0, count = 1;
        map.put(gems[0], 1);
        for(int i=1; i<gems.length; i++) {
            int nowCount = map.get(gems[i]);
            if(nowCount == 0) count++;
            map.put(gems[i], ++nowCount);

            if(gems[start].equals(gems[i])) {
                do {
                    map.put(gems[start], map.get(gems[start++]) - 1);
                } while (map.get(gems[start]) > 1);
            }

            if(count == map.size() && i-start < e-s) {
                s = start;
                e = i;
            }
        }

        return new int[]{s+1, e+1};
    }

    public static void main(String[] args) {
        Lesson_67258 obj = new Lesson_67258();
//        int[] result = obj.solution(new String[]{"DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA"});
        int[] result = obj.solution(new String[]{"DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "EMERALD", "DIA", "RUBY"});
//        int[] result = obj.solution(new String[]{"A", "B", "A", "A", "A", "C", "A", "B"});
//        int[] result = obj.solution(new String[]{"AA", "AB", "AC", "AA", "AC"});
//        int[] result = obj.solution(new String[]{"ZZZ", "YYY", "NNNN", "YYY", "BBB"});
//        int[] result = obj.solution(new String[]{"XYZ", "XYZ", "XYZ"});

        System.out.println(Arrays.toString(result));
    }
}
