package Programmers.etc.level1;

/*
크기가 작은 부분 문자열
URL : https://school.programmers.co.kr/learn/courses/30/lessons/147355
 */
public class Lesson_147355 {

    public int solution(String t, String p) {
        int answer = 0;

        long pi = Long.parseLong(p);
        int length = p.length();
        for(int i=0; i<=t.length()-length; i++) {
            String s = t.substring(i, i+length);
            System.out.println(s);
            long ti = Long.parseLong(s);
            if(ti <= pi) {
                answer++;
            }
        }

        return answer;
    }


    public static void main(String[] args) {
        Lesson_147355 lesson = new Lesson_147355();

//        String t = "3141592";
//        String p = "271";
        String t = "31";
        String p = "52";
//        String t = "500220839878";
//        String p = "7";
//        String t = "10203";
//        String p = "15";

        int result = lesson.solution(t, p);
        System.out.println(result);
    }
}
