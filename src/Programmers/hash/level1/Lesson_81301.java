package Programmers.hash.level1;

import java.util.HashMap;
import java.util.Map;

public class Lesson_81301 {

    public int solution2(String s) {
        String[] numbers = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        for(int i=0; i<10; i++) {
            s = s.replaceAll(numbers[i], i+"");
        }
        return Integer.parseInt(s);
    }

    public int solution(String s) {
        int answer = 0;

        Map<String, Integer> numberMap = new HashMap<>();
        numberMap.put("zero", 0);
        numberMap.put("one", 1);
        numberMap.put("two", 2);
        numberMap.put("three", 3);
        numberMap.put("four", 4);
        numberMap.put("five", 5);
        numberMap.put("six", 6);
        numberMap.put("seven", 7);
        numberMap.put("eight", 8);
        numberMap.put("nine", 9);

        while (!s.isEmpty()) {
            if(Character.isDigit(s.charAt(0))) {
                answer = answer*10 + s.charAt(0) - '0';
                s = s.substring(1);
                continue;
            }

            for(String number : numberMap.keySet()) {
                if(s.startsWith(number)) {
                    answer = answer*10 + numberMap.get(number);
                    s = s.replaceFirst(number, "");
                    break;
                }
            }
        }

        return answer;
    }
}
