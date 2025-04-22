package Programmers.basic;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Lesson_131127 {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;

        Map<String, Integer> map = new HashMap<>();
        for(int i=0; i<want.length; i++) {
            map.put(want[i], i);
        }

        for(int i=0; i<=discount.length-10; i++) {
            boolean isRegister = true;
            int[] tempNumbers = Arrays.copyOf(number, number.length);
            for(int j=i; j<i+10; j++) {
                String item = discount[j];
                if(!map.containsKey(item) || tempNumbers[map.get(item)] <= 0) {
                    if(!map.containsKey(item)) i=j;
                    isRegister = false;
                    break;
                } else tempNumbers[map.get(item)]--;
            }

            if(isRegister) answer++;
        }


        return answer;
    }

    public static void main(String[] args) {
        Lesson_131127 sol = new Lesson_131127();
        String[] want = {"banana", "apple", "rice", "pork", "pot"};
        int[] number = {3, 2, 2, 2, 1};
        String[] discount = {"chicken", "apple", "apple", "banana", "rice", "apple", "pork", "banana", "pork", "rice", "pot", "banana", "apple", "banana"};
        int result = sol.solution(want, number, discount);
        System.out.println(result);
    }
}
