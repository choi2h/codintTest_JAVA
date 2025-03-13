package Programmers.hash.level2;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Lesson_176963 {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        Map<String, Integer> map = new HashMap<>();
        for(int i=0; i<name.length; i++) {
            map.put(name[i], yearning[i]);
        }

        int[] answer = new int[photo.length];
        for(int i=0; i<photo.length; i++) {
            int sum = 0;
            for(String s : photo[i]) {
                sum += map.getOrDefault(s, 0);
            }

            answer[i] = sum;
        }

        return answer;
    }

    public static void main(String[] args) {
        Lesson_176963 obj = new Lesson_176963();
        String[] name = {"may", "kein", "kain", "radi"};
        int[] yearning = {5, 10, 1, 3};
        String[][] photo = {{"may", "kein", "kain", "radi"},{"may", "kein", "brin", "deny"}, {"kon", "kain", "may", "coni"}};
        int[] result = obj.solution(name, yearning, photo);
        System.out.println(Arrays.toString(result));
    }
}
