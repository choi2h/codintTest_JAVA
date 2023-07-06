package Programmers.etc.level1;

/*
숫자 짝꿍
URL : https://school.programmers.co.kr/learn/courses/30/lessons/131128
 */
public class Lesson_131128 {
    public String solution(String X, String Y) {
        int[] array = new int[10];

        for(int i=0; i<10; i++) {
            String num = String.valueOf(i);
            int xCount = X.length() - X.replace(num, "").length();
            int yCount = Y.length() - Y.replace(num, "").length();

            int min = Math.min(xCount, yCount);
            array[i] = min;
        }

        StringBuilder sb = new StringBuilder();
        for(int i=array.length-1; i>=0; i--) {
            if(array[i] > 0) {
                sb.append(String.valueOf(i).repeat(array[i]));
            }
        }

        String answer = sb.toString();
        if(answer.length() == 0) {
            answer = "-1";
        } else if(answer.replace("0", "").length() == 0){
            answer = "0";
        }

        return answer;
    }

    public static void main(String[] args) {
        Lesson_131128 lesson = new Lesson_131128();
//        String x="100";
//        String y="2345";
//        String x="100";
//        String y="203045";
//        String x="100";
//        String y="123450";
//        String x="12321";
//        String y="42531";
        String x="5525";
        String y="1255";

        String result = lesson.solution(x, y);
        System.out.println(result);
    }
}
