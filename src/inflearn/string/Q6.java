package inflearn.string;

import java.util.Scanner;

/*
    중복문자제거
    String s => s.charAt(i) : i번째의 character 반환
    str.indexOf(char) : 해당 문자가 가장 처음 존재하는 위치 반환
 */
public class Q6 {
    public String solution(String str) {
        String answer="";

        for(int i=0; i<str.length(); i++) {
            char nowChar = str.charAt(i);
//            System.out.println(str.charAt(i) + " " + i + " " + str.indexOf(str.charAt(i)));
            if(str.indexOf(nowChar) == i) {
                answer += nowChar;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Q6 T = new Q6();
        Scanner s = new Scanner(System.in);
        String str = s.next();

        String result = T.solution(str);
        System.out.println(result);
    }
}
