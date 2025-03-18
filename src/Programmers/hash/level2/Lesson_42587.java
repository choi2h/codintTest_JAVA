package Programmers.hash.level2;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Lesson_42587 {

    public int solution(int[] priorities, int location) {
        int answer = 0;

        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < priorities.length; i++) {
            queue.offer(i);
        }

        int[] arr = Arrays.copyOf(priorities, priorities.length);
        Arrays.sort(arr);

        int checkIndex = arr.length-1;
        while (!queue.isEmpty()) {
            int index = queue.remove();
            if(arr[checkIndex] == priorities[index]) {
                if(index == location) {
                    answer = arr.length-checkIndex;
                    break;
                }
                checkIndex--;
            } else {
                queue.add(index);
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Lesson_42587 lesson = new Lesson_42587();
        int result = lesson.solution(new int[]{2, 1, 3, 2}, 2);
//        int result = lesson.solution(new int[]{1, 1, 9, 1, 1, 1}, 0);
        System.out.println(result);
    }
}
