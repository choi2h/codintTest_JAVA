package inflearn.string;

import java.util.Scanner;

/*
    대소문자 변환
    character
    - 대문자 변환 : toUpperCase(char c)
    - 소문자 변환 : toLowerCase(char c)

    ASCII CODE
    대소문자 간 차이 32
    대문자 : 65~90
    소문자 : 97~122
 */
public class Q2 {

    public String solution(String str) {
        String answer="";
        char[] chars = str.toCharArray();
        for(char c : chars) {
            /* Character 함수 사용
            if(Character.isLowerCase(c)) {
                answer += Character.toUpperCase(c);
            } else {
                answer += Character.toLowerCase(c);
            }
            */

            //ASCII Code 사용
            if(c>=60 && c<=90) {
                answer += (char)(c+32);
            } else {
                answer += (char)(c-32);
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Q2 letterCase = new Q2();
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        System.out.print(letterCase.solution(str));
    }
}
