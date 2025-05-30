import java.util.*;

class Solution {
    public int solution(int[] numbers) {
        int answer=0;

        Arrays.sort(numbers);
        int index = 0;
        for(int i=0; i<10; i++) {
            if(index < numbers.length && numbers[index] == i) {
                index++;
            } else {
                answer += i;
            }
        }

        return answer;
    }
}