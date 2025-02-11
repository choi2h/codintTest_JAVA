package Programmers.stack;


import java.util.Arrays;
import java.util.Stack;

public class Lesson_154539 {

    public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];
        Stack<Integer> stack = new Stack<>();

        for(int i=0; i<numbers.length; i++) {
            if(stack.isEmpty() || numbers[i]<numbers[i-1]) {
                stack.push(i);
            } else {
                while (!stack.isEmpty() && numbers[stack.peek()] < numbers[i]) {
                    answer[stack.pop()] = numbers[i];
                }

                stack.push(i);
            }
        }

        while (!stack.isEmpty()) {
            answer[stack.pop()] = -1;
        }


        return answer;
    }

    //[2, 3, 3, 5]	[3, 5, 5, -1]
    //[9, 1, 5, 3, 6, 2]	[-1, 5, 6, 6, -1, -1]
    public static void main(String[] args) {
        Lesson_154539 lesson = new Lesson_154539();
//        int[] numbers = {2, 2, 2, 2, 2, 2, 2, 3, 2};
//        int[] numbers = {2, 3, 3, 5};
        int[] numbers = {9, 1, 5, 3, 6, 2};
//        int[] numbers = {9, 2, 1, 3, 4, 2};
        System.out.println(Arrays.toString(lesson.solution(numbers)));
    }
}
