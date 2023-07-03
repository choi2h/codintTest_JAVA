package Programmers.etc.level1;
/*
문자열 나누기
URL : https://school.programmers.co.kr/learn/courses/30/lessons/140108
 */
public class Lesson_140108 {

    public int solution(String s) {
        int answer = 0;

        int sameCount = 0;
        int differentCount = 0;
        char standard = s.charAt(0);

        char[] charArray = s.toCharArray();
        for(int i=0; i<charArray.length; i++) {
            char c = charArray[i];

            if(sameCount == 0) {
                sameCount++;
                standard = c;
            } else if(standard == c){
                sameCount++;
            } else {
                differentCount++;
            }

            if(sameCount == differentCount) {
                answer++;
                sameCount=0;
                differentCount=0;
                standard = ' ';
            }

            if(i==charArray.length-1 && sameCount!=0) {
                answer++;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Lesson_140108 lesson = new Lesson_140108();
        int result = lesson.solution("banana");
        System.out.println(result);
    }
}
