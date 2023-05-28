package Programmers.Array.level1;

import java.util.HashMap;
import java.util.Map;

/*
추억 점수
URL : https://school.programmers.co.kr/learn/courses/30/lessons/176963

테스트 1 〉	통과 (0.04ms, 76.1MB)
테스트 2 〉	통과 (0.04ms, 75MB)
테스트 3 〉	통과 (0.16ms, 74.4MB)
테스트 4 〉	통과 (0.14ms, 86.2MB)
테스트 5 〉	통과 (0.37ms, 76.8MB)
테스트 6 〉	통과 (0.73ms, 80.4MB)
테스트 7 〉	통과 (0.86ms, 85.8MB)
테스트 8 〉	통과 (0.71ms, 82.4MB)
테스트 9 〉	통과 (1.21ms, 91.7MB)
테스트 10 〉	통과 (2.20ms, 92.4MB)
테스트 11 〉	통과 (1.57ms, 96.1MB)
테스트 12 〉	통과 (1.27ms, 96.2MB)
테스트 13 〉	통과 (0.09ms, 74.9MB)
테스트 14 〉	통과 (0.03ms, 74.6MB)
 */
public class Lesson_176963 {
    public static int[] solution(String[] names, int[] yearning, String[][] photos) {
        int[] answer = new int[photos.length];

        Map<String, Integer> yearningMap = new HashMap<>();
        for(int i=0; i<names.length; i++)  {
            String name = names[i];
            int year = yearning[i];

            yearningMap.put(name, year);
        }

        for(int i=0; i< photos.length; i++) {
            int score = 0;
            String[] photo = photos[i];
            for(String name : photo) {
                if(!yearningMap.containsKey(name)) {
                    continue;
                }

                score += yearningMap.get(name);
            }

            answer[i] = score;
        }

        return answer;
    }

    public static void main(String[] args) {
        String[] names = {"may", "kein", "kain", "radi"};
        int[] yearning = {5, 10, 1, 3};
        String[][] photos = {{"may", "kein", "kain", "radi"},{"may", "kein", "brin", "deny"}, {"kon", "kain", "may", "coni"}};

        int[] result = solution(names, yearning, photos);
        for(int score : result) {
            System.out.println(score);
        }
    }
}
