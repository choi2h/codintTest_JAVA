package Programmers.etc.level1;

/*
가장 가까운 같은 글자
URL : https://school.programmers.co.kr/learn/courses/30/lessons/142086
 */
public class Lesson_142086 {

    public int[] solution(String s) {
        int[] answer = new int[s.length()];

        char[] charArray = s.toCharArray();
        for(int i=0; i<charArray.length; i++) {
            char c = charArray[i];
            // indexOf()는 가장 처음 인덱스 값만 가져옴
            int index = s.indexOf(c);

            // 위에서 가져온 가장 처음 인덱스 값이 현재 인덱스와 같다면
            // 가장 처음 문자이므로 -1 저장
            if(index == i) {
                answer[i] = -1;
            }
            // 아니라면 앞에 다른 위치에 문자가 있다는 뜻으로
            else {
                // 처음부터 현재위치-1까지의 문자열을 가져와서
                String frontString = s.substring(0, i);
                // 문자가 가장 마지막 위치에 있는 인덱스 가져옴
                int frontIndex = frontString.lastIndexOf(c);
                // 현재 위치에서 가장 마지막 위치 인덱스를 빼면 문자끼리의 거리가 됨
                answer[i] = i-frontIndex;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Lesson_142086 lesson = new Lesson_142086();

        int[] result = lesson.solution("foobar");
        for(int i : result) {
            System.out.println(i);
        }
    }
}
