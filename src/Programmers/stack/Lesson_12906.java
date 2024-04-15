package Programmers.stack;

import java.util.Arrays;
import java.util.Stack;

public class Lesson_12906 {

    public int[] solution(int []arr) {
        Stack<Integer> stack = new Stack<>();

        for(int i : arr) {
            if(!stack.isEmpty() && stack.peek() == i) {
                continue;
            }

            stack.push(i);
        }

        int index = stack.size()-1;
        int[] answer = new int[stack.size()];
        while(!stack.isEmpty()) {
            answer[index--] = stack.pop();
        }

        return answer;
    }

    /*
    [1,1,3,3,0,1,1]	[1,3,0,1]
    [4,4,4,3,3]	[4,3]
     */
    public static void main(String[] args) {
        Lesson_12906 lesson = new Lesson_12906();
//        int[] arr = {1,1,3,3,0,1,1};
        int[] arr = {4,4,4,3,3};
        int[] result = lesson.solution(arr);
        System.out.println(Arrays.toString(result));
    }
}
