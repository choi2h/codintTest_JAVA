package Programmers.hash.level2;

public class Lesson_42584 {
    public int[] solution(int[] prices) {
        int[] answer = {};
        return answer;
    }

    public static void main(String[] args) {
        Lesson_42584 lesson = new Lesson_42584();
        int[] result = lesson.solution(new int[]{1, 2, 3, 2, 3});
    }

}


/*
import java.util.Arrays;
import java.util.Stack;

class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];

        Stack<Integer> stack = new Stack<>();

        int index=0;
        while(index < prices.length) {
            while (!stack.isEmpty() && prices[stack.peek()] > prices[index]) {
                int beforeIndex = stack.pop();
                answer[beforeIndex] = index-beforeIndex;
            }

            stack.push(index++);
        }

        while(!stack.isEmpty()) {
            int beforeIndex = stack.pop();
            answer[beforeIndex] = index-1-beforeIndex;
        }

        return answer;
    }
}
 */