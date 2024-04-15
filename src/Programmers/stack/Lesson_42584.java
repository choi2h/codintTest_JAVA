package Programmers.stack;

import java.util.Arrays;
import java.util.Stack;

public class Lesson_42584 {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];

        Stack<Integer> stack = new Stack<>();

        int index=0;
        // 모든 가격 순회
        while(index < prices.length) {
            // 가격 기록(stack) 비어있지 않으나 가장 근래의 가격이 현재 가격보다 비쌀 경우 == 이전보다 가격이 떨어짐
            while (!stack.isEmpty() && prices[stack.peek()] > prices[index]) {
                // 이전 가격을 기록에서 제거
                int beforeIndex = stack.pop();
                // 해당 인덱스에 현재까지의 초과된 초를 구하여 결과 배열에 삽입
                // 현재까지 초과된 초 => 현재 인덱스-이전 가격 인덱스
                answer[beforeIndex] = index-beforeIndex;
            }

            // 현재 가격 추가
            stack.push(index++);
        }

        while(!stack.isEmpty()) {
            int beforeIndex = stack.pop();
            answer[beforeIndex] = index-1-beforeIndex;
        }

        return answer;
    }

    //[1, 2, 3, 2, 3]	[4, 3, 1, 1, 0]
    public static void main(String[] args) {
        Lesson_42584 lesson = new Lesson_42584();
        int[] prices = {1, 2, 3, 2, 3};

        int[] solution = lesson.solution(prices);
        System.out.println(Arrays.toString(solution));
    }
}
