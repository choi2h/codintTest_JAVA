package inflearn.string;

import java.util.Scanner;

/*
    문장 속 단어
    indexOf()
    subString()
 */
public class Q3 {
    public String solution(String str) {
        String answer="";

        int max = Integer.MIN_VALUE, pos;
        while((pos=str.indexOf(' '))!= -1) { // indexOf의 파라미터값을 발견하지 못하면 -1이 반환되며 발견 시 해당 문자의 위치가 반환된다.
            String tmp = str.substring(0, pos); //첫번째 문자부터 pos 위치 전까지 반환
            int len = tmp.length();
            if(len > max) {
                max = len;
                answer = tmp;
            }
            str = str.substring(pos+1); //앞서 체크한 단어는 제외한 문장을 반환한다.
        }

        if(str.length()>max) {
            answer = str;
        }

      /* String String[] strings = str.split(" ");
        for(String s : strings) {
            int len = s.length();
            if(len > max) {
                max = len;
                answer = s;
            }
        }*/

        return answer;
    }

    public static void main(String[] args) {
        Q3 T = new Q3();
        Scanner scanner = new Scanner(System.in);
        String sentence = scanner.nextLine();
        System.out.print(T.solution(sentence));
    }

}
