package Programmers.etc.level1;

/*
푸드 파이트 대회
URL : https://school.programmers.co.kr/learn/courses/30/lessons/134240
 */
public class Lesson_134240 {

    public String solution(int[] food) {
        StringBuilder sb = new StringBuilder();

        for(int i=1; i<food.length; i++) {
            int count = food[i]/2;

            if(count <= 0) {
                continue;
            }

            sb.append(String.valueOf(i).repeat(count));
        }

        String answer = sb + "0";
        return answer + sb.reverse();
    }

    public static void main(String[] args) {
        Lesson_134240 lesson = new Lesson_134240();

//        int[] food = {1, 3, 4, 6};
        int[] food = {1, 7, 1, 2};

        String result = lesson.solution(food);
        System.out.println(result);
    }
}
