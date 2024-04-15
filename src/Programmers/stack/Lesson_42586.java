package Programmers.stack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Lesson_42586 {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> answerList = new ArrayList<>();

        Stack<Integer> progressStack = new Stack<>();
        for(int i=progresses.length-1; i>=0; i--) {
            progressStack.push(progresses[i]);
        }

        int day = 0;
        int index = 0;
        int count = 0;
        while(!progressStack.isEmpty()) {
            int progress = progressStack.pop();
            int finishDay = getFinishDay(progress, speeds[index++]);
            if(count == 0) {
                count++;
                day = finishDay;
                continue;
            }

            if(day >= finishDay) {
                count++;
            } else {
                answerList.add(count);
                count = 1;
                day = finishDay;
            }
        }

        if(count != 0) {
            answerList.add(count);
        }

        return answerList.stream().mapToInt(i -> i).toArray();
    }

    private int getFinishDay(int progress, int speed) {
        int idleTime = 100-progress;
        return idleTime % speed == 0 ? idleTime/speed : idleTime/speed+1;
    }

    public static void main(String[] args) {
        Lesson_42586 lesson = new Lesson_42586();
        int[] progresses = {93, 30, 55};
        int[] speeds = {1, 30, 5};

        int[] result = lesson.solution(progresses, speeds);
        System.out.println(Arrays.toString(result));

    }
}
