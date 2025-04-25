package Programmers.basic;

public class Lesson_134240 {
    public String solution(int[] food) {
        StringBuilder answer = new StringBuilder();
        for (int i = 1; i < food.length; i++) {
            answer.append(String.valueOf(i).repeat(food[i]/2));
        }
        return answer.toString() + "0" + answer.reverse();
    }
}
